package com.babic.filip.movieshack.common.utils

import java.util.HashMap

private const val API_KEY = "25937d0ea465028585770e26d6b378a2"
private const val KEY_PAGE = "page"
private const val KEY_API = "api_key"

fun getMoviesQuery(page: Int): Map<String, String> {
    val queryMap = HashMap<String, String>()

    queryMap[KEY_PAGE] = page.toString()
    queryMap[KEY_API] = API_KEY

    return queryMap
}
