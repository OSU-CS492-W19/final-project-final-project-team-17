package com.example.starwarsinfo;

import android.content.Intent;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mSearchResultsRV;
    private DrawerLayout mDrawerLayout;
    private String mSearchBoxET;
    private ProgressBar mLoadingPB;
    private TextView mLoadingErrorTV;
    private StarWarsAdapter mStarWarsAdapter;

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        mStarWarsAdapter = new StarWarsAdapter();

        NavigationView navigationView = findViewById(R.id.nv_nav_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_hamburger_stack);

        getSupportActionBar().setElevation(0);

        Button peopleButton = findViewById(R.id.btn_people);
        peopleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchBoxET = "https://swapi.co/api/person/1";
                String searchQuery = mSearchBoxET;
                if (!TextUtils.isEmpty(searchQuery)) {
                    doStarWarsSearch(searchQuery);
                }
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

    private void doStarWarsSearch(String query){
        String url = StarWarsUtils.buildStarWarsSearchURL(query);
        Log.d(TAG, "querying starwars search URL: " + url );
        new StarWarsSearchTask().execute(url);
    }

    class StarWarsSearchTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //mLoadingPB.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... urls) {
            String url = urls[0];
            String results = null;
            try {
                results = NetworkUtils.doHTTPGet(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return results;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s != null) {
                //mLoadingErrorTV.setVisibility(View.INVISIBLE);
                //mSearchResultsRV.setVisibility(View.VISIBLE);
                Log.d(TAG, s);
                ArrayList<StarWarsUtils.StarWarsPerson> items = StarWarsUtils.parseStarWarsResults(s);
                mStarWarsAdapter.updateStarWarsResults(items);
            } else {
                //mLoadingErrorTV.setVisibility(View.VISIBLE);
                //mSearchResultsRV.setVisibility(View.INVISIBLE);
            }
            //mLoadingPB.setVisibility(View.INVISIBLE);
        }

    }


}
