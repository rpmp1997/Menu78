package com.example.ramonmedina.menu78.Restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ramonmedina.menu78.MainActivity;
import com.example.ramonmedina.menu78.R;
import com.google.android.gms.maps.model.LatLng;

public class RestaurantActivity extends AppCompatActivity {

    private static final LatLng boca_loca = new LatLng(18.4343864,-67.1571215);
    private static final LatLng desecheo = new LatLng(18.4671791,-67.15581691);
    private static final LatLng cinco = new LatLng(18.5037576,-67.1191542);

    private String RESTAURANTE;
    private String TownIndex;
    private String TOWN;
    private String TAG = "Check: ";

    private int CUISINE;

    private String LOCATION_LAT;
    private String LOCATION_LNG;
    private String [] LAT_LNG;

    private ImageView fotoRestaurante;
    private TextView nombreRestaurante;
    private TextView descRestaurante;
    private TextView locaRestaurante;
    private TextView cateRestaurante;

    private Button puebloMapa;

    private Intent receiveExtraRes, receiveExtraTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        fotoRestaurante = (ImageView)findViewById(R.id.imgPuebloRestaurant);
        nombreRestaurante = (TextView) findViewById(R.id.nombrePueblo);
        descRestaurante = (TextView) findViewById(R.id.descParraPueblo);
        locaRestaurante = (TextView) findViewById(R.id.locaPueblo);
        cateRestaurante = (TextView) findViewById(R.id.catePueblo);
        puebloMapa = (Button)findViewById(R.id.PuebloBtn);


        receiveExtraRes = getIntent();
        receiveExtraTab = getIntent();

        fillRestaurant(receiveExtraTab, receiveExtraRes);

        puebloMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle data = new Bundle();//create bundle instance
                Bundle data2 = new Bundle();//create bundle instance
                data.putString("LAT", LOCATION_LAT);
                data2.putString("LONG", LOCATION_LNG);


                Intent intent = new Intent(RestaurantActivity.this, MainActivity.class);
                intent.putExtras(data);
                intent.putExtras(data2);
                intent.putExtra("Name", nombreRestaurante.getText().toString());
                intent.putExtra("Pressed", true);
                startActivity(intent);

            }
        });
    }

    public void restaurantTownInformation(String town, String res)
    {
        Log.d(TAG, town);
        if (town.equals(String.valueOf("Aguadilla")))
        {
            if (res.equals(String.valueOf("Boca Loca"))) {
                fotoRestaurante.setImageResource(R.mipmap.criolla);
                nombreRestaurante.setText("Boca Loca");
                descRestaurante.setText("Boca Loca se especializa en comida latina de diversos paises");
                locaRestaurante.setText("Calle Stahl #57, 00603");
                cateRestaurante.setText("Latina");
                LAT_LNG = boca_loca.toString().split(",");
                LOCATION_LAT = LAT_LNG[0];
                LOCATION_LNG = LAT_LNG[1];
            } else if (res.equals(String.valueOf("Desecheo"))) {
                fotoRestaurante.setImageResource(R.mipmap.criolla);
                nombreRestaurante.setText("Desecheo");
                descRestaurante.setText("Resaurante reconocido por comida  criolla");
                locaRestaurante.setText(" 2052 Pedro Albizu Campos, Aguadilla Pueblo, PR 00603");
                cateRestaurante.setText("Criollo");
                LAT_LNG = desecheo.toString().split(",");
                LOCATION_LAT = LAT_LNG[0];
                LOCATION_LNG = LAT_LNG[1];
            } else if (res.equals(String.valueOf("Cinco"))) {
                fotoRestaurante.setImageResource(R.mipmap.criolla);
                nombreRestaurante.setText("Cinco");
                descRestaurante.setText("Restaurante de comida latina y criolla");
                locaRestaurante.setText("KM. 9.2 PR-110, Aguadilla Pueblo");
                cateRestaurante.setText("Criollo, Latina");
                LAT_LNG = cinco.toString().split(",");
                LOCATION_LAT = LAT_LNG[0];
                LOCATION_LNG = LAT_LNG[1];
            }
        }
    }

    public void restaurantCategoryInformation(String res)
    {

            if (res.equals(String.valueOf("Past1"))) {
                fotoRestaurante.setImageResource(R.mipmap.italiano);
                nombreRestaurante.setText("AAAAAA");
                descRestaurante.setText("Boca Loca se especializa en comida latina de diversos paises");
                locaRestaurante.setText("Calle Stahl #57, 00603");
                cateRestaurante.setText("Latina");
            } else if (res.equals(String.valueOf("Past2"))) {
                fotoRestaurante.setImageResource(R.mipmap.italiano);
                nombreRestaurante.setText("EEEEEE");
                descRestaurante.setText("Resaurante reconocido por comida  criolla");
                locaRestaurante.setText(" 2052 Pedro Albizu Campos, Aguadilla Pueblo, PR 00603");
                cateRestaurante.setText("Criollo");
            } else if (res.equals(String.valueOf("Past3"))) {
                fotoRestaurante.setImageResource(R.mipmap.italiano);
                nombreRestaurante.setText("IIIIIII");
                descRestaurante.setText("Restaurante de comida latina y criolla");
                locaRestaurante.setText("KM. 9.2 PR-110, Aguadilla Pueblo");
                cateRestaurante.setText("Criollo, Latina");
            }
    }

    public void fillRestaurant(Intent intentTab, Intent intentRest)
    {
        //If restaurant came from Town Tab uses try, if it came from Cuisine tab uses catch
        try
        {
            //Receive data from the intents
            RESTAURANTE = intentRest.getStringExtra("Restaurant");
            TownIndex = intentTab.getStringExtra("TownSent");
            //Find the town based on index
            final String[] TownsPR = getResources().getStringArray(R.array.TOWNS);
            //Assigned the town
            TOWN = TownsPR[Integer.valueOf(TownIndex)];
            //Gets Resaturant info
            restaurantTownInformation(TOWN, RESTAURANTE);
        }
        catch (Exception e)
        {
            //Receive data from the intents
            RESTAURANTE = intentRest.getStringExtra("Restaurante");
            CUISINE = intentTab.getIntExtra("Category", 0);
            Log.d(TAG, String.valueOf(CUISINE));
            Log.d(TAG, RESTAURANTE);
            //Gets Resaturant info
            restaurantCategoryInformation(RESTAURANTE);
        }
    }
}
