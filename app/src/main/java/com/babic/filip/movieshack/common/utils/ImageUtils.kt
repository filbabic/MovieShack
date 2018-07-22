package com.babic.filip.movieshack.common.utils

import android.widget.ImageView

import com.bumptech.glide.Glide

private const val IMAGE_BASE_URL = "http://image.tmdb.org/t/p/original"

fun loadImage(imageView: ImageView, imagePath: String) {
    Glide.with(imageView).load(IMAGE_BASE_URL + imagePath).into(imageView)
}
