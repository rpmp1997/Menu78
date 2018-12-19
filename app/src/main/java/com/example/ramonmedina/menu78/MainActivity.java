package com.example.ramonmedina.menu78;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;

import com.example.ramonmedina.menu78.Tabs.CuisineTab;
import com.example.ramonmedina.menu78.Tabs.MapTab;
import com.example.ramonmedina.menu78.Tabs.TownTab;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSectionsPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    //Sets up pager with tabs
    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new CuisineTab(), "Estilo");
        adapter.addFragment(new TownTab(), "Pueblo");
        adapter.addFragment(new MapTab(), "Mapa");
        viewPager.setAdapter(adapter);
    }
}
