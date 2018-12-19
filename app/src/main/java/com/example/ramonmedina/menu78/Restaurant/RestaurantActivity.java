package com.example.ramonmedina.menu78.Restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ramonmedina.menu78.R;

public class RestaurantActivity extends AppCompatActivity {

    private String RESTAURANTE;
    private String TOWN;
    private String TAG = "Check: ";
    private ImageView fotoRestaurante;
    private TextView nombreRestaurante;
    private TextView descRestaurante;
    private TextView locaRestaurante;
    private TextView cateRestaurante;
    private Button puebloMapa;

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


        Intent receiveExtra = getIntent();
        Intent receiveExtra2 = getIntent();
        RESTAURANTE = receiveExtra.getStringExtra("Restaurante");
        TOWN = receiveExtra2.getStringExtra("Pueblo");
    }

    public void restaurantInformation()
    {

    }
}
