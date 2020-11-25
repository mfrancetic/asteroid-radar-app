package com.udacity.asteroidradar.utils

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.udacity.asteroidradar.PictureOfDay

fun displayPicture(picture: PictureOfDay, imageView: ImageView, context: Context) {
    Picasso.with(context)
        .load(picture.url)
        .fit()
        .centerCrop()
        .into(imageView)
}