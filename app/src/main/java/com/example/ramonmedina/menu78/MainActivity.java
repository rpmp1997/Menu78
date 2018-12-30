package com.example.ramonmedina.menu78;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ramonmedina.menu78.Tabs.CuisineTab;
import com.example.ramonmedina.menu78.Tabs.MapTab;
import com.example.ramonmedina.menu78.Tabs.TownTab;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    private boolean placeSelected = false;
    private String LAT = null;
    private String LNG = null;
    private String nameRecieved;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSectionsPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        Intent intent = getIntent();
        placeSelected =intent.getBooleanExtra("Pressed", false);

        isPlaceSelected();
    }


    //Sets up pager with tabs
    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new CuisineTab(), "Estilo");
        adapter.addFragment(new TownTab(), "Pueblo");
        adapter.addFragment(new MapTab(), "Mapa");
        viewPager.setAdapter(adapter);
    }

    private void isPlaceSelected()
    {
        if(placeSelected == true) {
            Bundle bundle = getIntent().getExtras();
            LAT = bundle.getString("LAT");
            LNG = bundle.getString("LONG");
            nameRecieved = getIntent().getStringExtra("Name");


            setLAT();
            setLNG();
            setName();

            setContentView(R.layout.activity_main);
            mViewPager = (ViewPager) findViewById(R.id.container);
            setupViewPager(mViewPager);
            mViewPager.setCurrentItem(2);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);
        }
        else {
            mSectionsPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            setupViewPager(mViewPager);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);
        }
    }


    public String setLAT()
    {
        return LAT;
    }

    public String setLNG()
    {
        return LNG;
    }

    public String setName() { return nameRecieved; }
}
