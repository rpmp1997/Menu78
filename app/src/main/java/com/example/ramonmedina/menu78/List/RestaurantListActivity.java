package com.example.ramonmedina.menu78.List;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ramonmedina.menu78.R;
import com.example.ramonmedina.menu78.Restaurant.RestaurantActivity;

public class RestaurantListActivity extends AppCompatActivity {

    ListView RestaurantList;

    private int categoryIndex = 0;
    public int Index = 0;

    public boolean isCuisine = false;

    public ArrayAdapter<String> itemsAdapter;
    public  Intent intent;

    private String TAG_List = "List: ";
    public String townNameIndex = "";
    private String[] townAguadilla = {"Boca Loca", "Desecheo", "Cinco"};
    private String[] pastaRestaurants = {"Past1", "Past2", "Past3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        RestaurantList = (ListView)findViewById(R.id.restaurantList);

        //Ensures boolean is set up for goToRestaurant
        isCuisine = false;

        //Gets the town the user selected.
        Intent receiveExtra = getIntent();
        fillList(receiveExtra);

        //Reacts to a list element being selected
        RestaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                goToRestaurant(i);
                startActivity(intent);
            }
        });
    }

    //Method that fills list with restaurants
    public void findTownRestaurants(int Town)
    {

        switch (Town){
            case 0:
                break;
            case 1:
                break;
            case 2:
                itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, townAguadilla);
                RestaurantList.setAdapter(itemsAdapter);
                break;
            default:
                Toast.makeText(getBaseContext(), "Not Found", Toast.LENGTH_SHORT);
        }
    }

    //Method that fills list with restaurants
    public void findCategoryRestaurants(int Category)
    {
        switch (Category){
            case 0:
                break;
            case 1:
                break;
            case 2:
                itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pastaRestaurants);
                RestaurantList.setAdapter(itemsAdapter);
                break;
            default:
                Toast.makeText(getBaseContext(), "Not Found", Toast.LENGTH_SHORT);
        }
    }

    public void fillList(Intent intent)
    {
        //We use the try clause assumoing the intent came from TownTab, if intent came from Cuisine tab we use the catch clause
        try
        {
            //Gets index of town
            townNameIndex = intent.getStringExtra("TownSent");
            //Converts to int
            Index = Integer.valueOf(townNameIndex);
            //Finds Restaurant with index
            findTownRestaurants(Index);
        }
        catch (Exception e)
        {
            //Get index of category
            categoryIndex = intent.getIntExtra("Category", 0);
            //Finds Restaurant with index
            findCategoryRestaurants(categoryIndex);
            //Let us know that event came from Cuisine Tab
            isCuisine = true;

        }
    }

    public void goToRestaurant(int res)
    {
        if(isCuisine==true)
        {
            intent.putExtra("Restaurante", pastaRestaurants[res]);
        }
        else
        {
            intent.putExtra("TownSent", townNameIndex);
            intent.putExtra("Restaurant", townAguadilla[res]);
        }
    }

}
