package com.example.starwarsinfo;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class PeopleActivity extends AppCompatActivity implements PeopleAdapter.OnPersonItemClickListener {

    private RecyclerView mSearchResultsRV;
    private PeopleAdapter mPeopleAdapter;
    private ProgressBar mLoadingPB;


    private final String TAG = PeopleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        mLoadingPB = findViewById(R.id.pb_loading_indicator);

        mSearchResultsRV = findViewById(R.id.rv_starwars_list);

        mPeopleAdapter = new PeopleAdapter(this);

        mSearchResultsRV.setAdapter(mPeopleAdapter);
        mSearchResultsRV.setLayoutManager(new LinearLayoutManager(this));
        mSearchResultsRV.setHasFixedSize(true);

        doStarWarsPeople("https://swapi.co/api/");
    }
    private void doStarWarsPeople(String query){
        String url = PeopleUtils.buildStarWarsSearchURL(query);
        Log.d(TAG, "querying starwars search URL: " + url );
        new StarWarsSearchTask().execute(url);
    }

    @Override
    public void onPersonItemClick(PeopleUtils.StarWarsPerson swp) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, swp.name);
        startActivity(intent);
    }

    class StarWarsSearchTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingPB.setVisibility(View.VISIBLE);
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
                ArrayList<PeopleUtils.StarWarsPerson> items = PeopleUtils.parseStarWarsResults(s); // SET UP FOR PEOPLE
                mPeopleAdapter.updatePeopleResults(items);
            } else {
                //mLoadingErrorTV.setVisibility(View.VISIBLE);
                //mSearchResultsRV.setVisibility(View.INVISIBLE);
            }
            mLoadingPB.setVisibility(View.INVISIBLE);
        }
    }
}
