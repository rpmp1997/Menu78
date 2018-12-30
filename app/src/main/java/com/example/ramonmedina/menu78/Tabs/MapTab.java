package com.example.ramonmedina.menu78.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ramonmedina.menu78.MainActivity;
import com.example.ramonmedina.menu78.Map.MapRestaurantActivity;
import com.example.ramonmedina.menu78.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Ramon Medina on 11/11/2018.
 */

public class MapTab extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private static final String TAG = "Tab1Fragment";

    private LatLng locationRest = null;
    private float DEFAULT_ZOOM = 15f;
    private float PUERTORICO_ZOOM = 8f;
    private String LAT = null;
    private String LNG = null;
    private String LOCATION = null;
    private String [] Lat;
    private String [] Lng;
    private LatLng PUERTORICO_LOCATION =  new LatLng( 18.288532, -66.517392 );

    GoogleMap googleMap;
    MapView mapView;

    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        try {

            MainActivity myactivity = (MainActivity) getActivity();

            LAT = myactivity.setLAT();
            LNG = myactivity.setLNG();

            Lat  = LAT.toString().split("\\(");
            Lng  = LNG.toString().split("\\)");

            LAT = Lat[1];
            LNG = Lng[0];

            double latitude = Double.parseDouble(LAT);
            double longitude = Double.parseDouble(LNG);

            locationRest = new LatLng(latitude, longitude);

            LOCATION = myactivity.setName();

        } catch (Exception e)
        {
            Log.d(TAG, "Unable to get location");
        }

        View view = inflater.inflate(R.layout.map_tab,container,false);
        return view;
    }

    @Override
    public  void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView)view.findViewById(R.id.map);

        if(mapView != null)
        {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googlemap) {

        MapsInitializer.initialize(getContext());

        googleMap = googlemap;
        googlemap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (locationRest != null)
        {
            moveCamera(locationRest, DEFAULT_ZOOM);
        }
        else
        {
            moveCamera(PUERTORICO_LOCATION, PUERTORICO_ZOOM);
        }

        placeLocations(googlemap);

        googlemap.setOnInfoWindowClickListener(this);
    }

    //Method zooms on specified locations
    private void moveCamera(LatLng latLng, float zoom){
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));


    }


    //Method which puts marker on desired locations
    public void placeLocations(GoogleMap googleMap)
    {
        LatLng desecheo = new LatLng(18.4671791, -67.15581691);
        googleMap.addMarker(new MarkerOptions().position(desecheo).title("Desecheo"));

        LatLng cinco = new LatLng(18.5037576, -67.1191542);
        googleMap.addMarker(new MarkerOptions().position(cinco).title("Cinco"));

        LatLng boca_loca = new LatLng(18.4343864, -67.1571215);
        googleMap.addMarker(new MarkerOptions().position(boca_loca).title("Boca Loca"));
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(getContext(), MapRestaurantActivity.class);

        if (marker.getTitle().toString().equals("Desecheo"))
        {
            intent.putExtra("Res", marker.getTitle().toString());
            startActivity(intent);
        } else if (marker.getTitle().toString().equals("Cinco")) {
            intent.putExtra("Res", marker.getTitle().toString());
            startActivity(intent);
        } else if (marker.getTitle().toString().equals("Boca Loca")) {
            intent.putExtra("Res", marker.getTitle().toString());
            startActivity(intent);
        }
    }
}