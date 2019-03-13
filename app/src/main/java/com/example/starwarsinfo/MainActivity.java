package com.example.starwarsinfo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nv_nav_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.hamburger);

        getSupportActionBar().setElevation(0);

        Button peopleButton = findViewById(R.id.btn_people);
        peopleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button planetButton = findViewById(R.id.btn_planet);
        planetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button speciesButton = findViewById(R.id.btn_species);
        speciesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        mDrawerLayout.closeDrawers();
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                return true;
            case R.id.nav_settings:
                //Intent settingsIntent = new Intent(this, SettingsActivity.class);
                //startActivity(settingsIntent);
                return true;
            case R.id.nav_people:
                //Intent savedReposIntent = new Intent(this, SavedReposActivity.class);
                //startActivity(savedReposIntent);
                return true;
            case R.id.nav_planets:
                //Intent savedReposIntent = new Intent(this, SavedReposActivity.class);
                //startActivity(savedReposIntent);
                return true;
            case R.id.nav_species:
                //Intent savedReposIntent = new Intent(this, SavedReposActivity.class);
                //startActivity(savedReposIntent);
                return true;
            default:
                return false;
        }
    }
}
