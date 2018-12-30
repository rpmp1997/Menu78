package com.example.ramonmedina.menu78.Tabs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ramonmedina.menu78.List.RestaurantListActivity;
import com.example.ramonmedina.menu78.MainActivity;
import com.example.ramonmedina.menu78.R;


/**
 * Created by Ramon Medina on 11/11/2018.
 */

public class TownTab extends Fragment {

    private static final String TAG = "Tab1Fragment";
    private Spinner spinner;
    private Button townTabButton;
    public Intent intent;
    public boolean intentHasValue = false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.town_tab,container,false);

        //Gets string array from String xml
        final String[] TownsPR = view.getResources().getStringArray(R.array.TOWNS);

        spinner = (Spinner)view.findViewById(R.id.TownList);
        townTabButton = (Button)view.findViewById(R.id.TownTabButton);
        //Attaches spinner to TownsPR
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, TownsPR);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Toast.makeText(getContext(), "Not Available", Toast.LENGTH_SHORT);
                        break;
                    case 1:
                        Toast.makeText(getContext(), "Not Available", Toast.LENGTH_SHORT);
                        break;
                    case 2:
                        intent = new Intent(view.getContext(), RestaurantListActivity.class);
                        intent.putExtra("TownSent", String.valueOf(i));
                        intentHasValue = true;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        townTabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intentHasValue == false)
                    Toast.makeText(view.getContext(), "Seleccione un pueblo", Toast.LENGTH_SHORT).show();
                else
                    startActivity(intent);
            }
        });

        return view;
    }


}