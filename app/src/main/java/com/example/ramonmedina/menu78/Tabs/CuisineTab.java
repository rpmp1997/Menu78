package com.example.ramonmedina.menu78.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ramonmedina.menu78.List.RestaurantListActivity;
import com.example.ramonmedina.menu78.R;

/**
 * Created by Ramon Medina on 11/11/2018.
 */

public class CuisineTab extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private Button criollaButton, vegetarianoButton, otroButton, pastaButton;
    public Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cuisine_tab,container,false);


        criollaButton = (Button)view.findViewById(R.id.cuisineCriollaBtn);
        vegetarianoButton = (Button)view.findViewById(R.id.cuisineVegetarianoBtn);
        otroButton = (Button)view.findViewById(R.id.cuisineOtroBtn);
        pastaButton = (Button)view.findViewById(R.id.cuisinePastaBtn);

        criollaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToList(1, view);
            }
        });

        pastaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToList(2, view);

            }
        });

        vegetarianoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToList(3, view);

            }
        });

        otroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToList(4, view);

            }
        });

        return view;
    }

    public void goToList(int selected, View view)
    {
        intent = new Intent(view.getContext(), RestaurantListActivity.class);
        intent.putExtra("Category", selected);
        startActivity(intent);
    }

}
