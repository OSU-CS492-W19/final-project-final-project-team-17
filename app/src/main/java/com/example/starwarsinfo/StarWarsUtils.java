package com.example.starwarsinfo;

import android.net.Uri;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class StarWarsUtils {
    final static String STARWARS_SEARCH_BASE_URL = "https://swapi.co/api/";
    final static String STARWARS_SEARCH_QUERY_PARAM = "q";
    final static String STARWARS_SEARCH_TYPE_PARAM = "people";
    final static String STARWARS_SEARCH_NUMBER_PARAM = "1";
    final static String STARWARS_SEARCH_STUFF = "search";

    public static class StarWarsPerson {
        public String name;
        public String height;
        public String mass;
    }
    public static class StarWarsResults {
        public StarWarsPerson[] results;

    }

    public static String buildStarWarsSearchURL(String query){
        return Uri.parse(STARWARS_SEARCH_BASE_URL).buildUpon()
                .appendPath(STARWARS_SEARCH_TYPE_PARAM)
                .appendQueryParameter(STARWARS_SEARCH_STUFF, "a")
                .build()
                .toString();

    }

    public static ArrayList<StarWarsPerson> parseStarWarsResults(String json) {
        Gson gson = new Gson();
        StarWarsResults results = gson.fromJson(json, StarWarsResults.class);
        if (results != null && results.results != null) {
            ArrayList<StarWarsPerson> newList = new ArrayList<>();
            for (StarWarsPerson swp: results.results) {
                newList.add(swp);
            }
            return newList;
        } else {
            return null;
        }
    }
}
