package com.example.ramonmedina.menu78.List;

import android.content.Intent;
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


    public int Index = 0;
    public ArrayAdapter<String> itemsAdapter;

    private String TAG_List = "List: ";
    public String townNameIndex = "";
    private String[] townAguadilla = { "Boca Loca", "Desecheo", "Cinco"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        RestaurantList = (ListView)findViewById(R.id.restaurantList);

        //Gets the town the user selected.
        Intent receiveExtra = getIntent();
        townNameIndex = receiveExtra.getStringExtra("TownSent");
        Index = Integer.valueOf(townNameIndex);
        //Initiates list with corresponding towns
        findRestaurants(Index);

        //Reacts to a list element being selected
        RestaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String item = (String) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                intent.putExtra("TownSent", townNameIndex);
                intent.putExtra("Restaurant", item);
                startActivity(intent);
            }
        });
    }

    //Method that fills list with restaurants
    public void findRestaurants(int Town)
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
}
