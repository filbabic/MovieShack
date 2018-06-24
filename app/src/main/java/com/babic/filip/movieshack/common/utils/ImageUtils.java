package com.babic.filip.movieshack.common.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageUtils {

    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/original";

    private ImageUtils() {}

    public static void loadImage(ImageView imageView, String imagePath) {
        Glide.with(imageView).load(IMAGE_BASE_URL + imagePath).into(imageView);
    }
}
