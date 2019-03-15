package com.example.starwarsinfo;

import android.net.Uri;
import com.google.gson.Gson;


public class StarWarsUtils {
    final static String STARWARS_SEARCH_BASE_URL = "https://swapi.co/api/";
    final static String STARWARS_SEARCH_QUERY_PARAM = "q";
    final static String STARWARS_SEARCH_SORT_PARAM = "sort";
    final static String STARWARS_SEARCH_DEFAULT_SORT = "stars";

    public static class StarWarsList {
        public String full_name;
        public String planet;
        public String species;
        public String persons;
    }
    public static class StarWarsResults {
        public StarWarsList[] items;

    }

    public static String buildStarWarsSearchURL(String query){
        return Uri.parse(STARWARS_SEARCH_BASE_URL).buildUpon()
                .appendQueryParameter(STARWARS_SEARCH_QUERY_PARAM, query)
                .appendQueryParameter(STARWARS_SEARCH_SORT_PARAM, STARWARS_SEARCH_DEFAULT_SORT)
                .build()
                .toString();

    }

    public static StarWarsList[] parseStarWarsResults(String json) {
        Gson gson = new Gson();
        StarWarsResults results = gson.fromJson(json, StarWarsResults.class);
        if (results != null && results.items != null) {
            return results.items;
        } else {
            return null;
        }
    }
}
