package com.example.starwarsinfo;

import android.net.Uri;

import com.google.gson.Gson;

import java.util.ArrayList;

public class SpeciesUtils {
    final static String STARWARS_SEARCH_BASE_URL = "https://swapi.co/api/";
    final static String STARWARS_SEARCH_QUERY_PARAM = "q";
    final static String STARWARS_SEARCH_TYPE_PARAM = "species";
    final static String STARWARS_SEARCH_NUMBER_PARAM = "1";
    final static String STARWARS_SEARCH_STUFF = "search";

    public static class StarWarsSpecies {
        public String name;
        public String classification;
        public String mass;
    }
    public static class StarWarsResults {
        public StarWarsSpecies[] results;

    }

    public static String buildStarWarsSearchURL(String query){
        return Uri.parse(STARWARS_SEARCH_BASE_URL).buildUpon()
                .appendPath(STARWARS_SEARCH_TYPE_PARAM)
                .appendQueryParameter(STARWARS_SEARCH_STUFF, "a")
                .build()
                .toString();

    }

    public static ArrayList<StarWarsSpecies> parseStarWarsResults(String json) {
        Gson gson = new Gson();
        StarWarsResults results = gson.fromJson(json, StarWarsResults.class);
        if (results != null && results.results != null) {
            ArrayList<StarWarsSpecies> newList = new ArrayList<>();
            for (StarWarsSpecies swp: results.results) {
                newList.add(swp);
            }
            return newList;
        } else {
            return null;
        }
    }
}
