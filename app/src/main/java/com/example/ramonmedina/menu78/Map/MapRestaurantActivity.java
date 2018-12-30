package com.example.ramonmedina.menu78.Map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ramonmedina.menu78.R;
import com.google.android.gms.maps.model.Marker;

public class MapRestaurantActivity extends AppCompatActivity {

    private ImageView imagenRest;
    private TextView textMapaNombre, textMapaDescripcion, textMapaLoca, textMapaCate;
    public Intent recieveMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_restaurant);

        imagenRest = (ImageView)findViewById(R.id.imgMapRestaurant);
        textMapaNombre = (TextView)findViewById(R.id.nombreMapa);
        textMapaDescripcion = (TextView)findViewById(R.id.descParraMapa);
        textMapaLoca = (TextView)findViewById(R.id.locaMapa);
        textMapaCate = (TextView)findViewById(R.id.cateMapa);

        recieveMap = getIntent();

        rendInforWindow(recieveMap.getStringExtra("Res"));

    }

    private void rendInforWindow(String name)
    {


        if (name.equals(String.valueOf("Boca Loca"))) {
            imagenRest.setImageResource(R.mipmap.criolla);
            textMapaNombre.setText("Boca Loca");
            textMapaDescripcion.setText("Boca Loca se especializa en comida latina de diversos paises");
            textMapaLoca.setText("Calle Stahl #57, 00603");
            textMapaCate.setText("Latina");
        } else if (name.equals(String.valueOf("Desecheo"))) {
            imagenRest.setImageResource(R.mipmap.criolla);
            textMapaNombre.setText("Desecheo");
            textMapaDescripcion.setText("Resaurante reconocido por comida  criolla");
            textMapaLoca.setText(" 2052 Pedro Albizu Campos, Aguadilla Pueblo, PR 00603");
            textMapaCate.setText("Criollo");
        } else if (name.equals(String.valueOf("Cinco"))) {
            imagenRest.setImageResource(R.mipmap.criolla);
            textMapaNombre.setText("Cinco");
            textMapaDescripcion.setText("Restaurante de comida latina y criolla");
            textMapaLoca.setText("KM. 9.2 PR-110, Aguadilla Pueblo");
            textMapaCate.setText("Criollo, Latina");
        }
    }
}
