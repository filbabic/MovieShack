package com.babic.filip.movieshack.common.utils;

import java.util.HashMap;
import java.util.Map;

public class QueryUtils {

    private static final String API_KEY = "25937d0ea465028585770e26d6b378a2";
    private static final String KEY_PAGE = "page";
    private static final String KEY_API = "api_key";

    private QueryUtils() {
    }

    public static Map<String, String> getMoviesQuery(int page) {
        final Map<String, String> queryMap = new HashMap<>();

        queryMap.put(KEY_PAGE, String.valueOf(page));
        queryMap.put(KEY_API, API_KEY);

        return queryMap;
    }
}
