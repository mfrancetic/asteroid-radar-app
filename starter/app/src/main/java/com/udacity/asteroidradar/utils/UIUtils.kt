package com.udacity.asteroidradar.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.R

fun displayPicture(picture: PictureOfDay, imageView: ImageView) {
    val context = imageView.context
    Picasso.with(context)
        .load(picture.url)
        .fit()
        .centerCrop()
        .into(imageView)

    val contentDescription =
        String.format(
            context.getString(R.string.nasa_picture_of_day_content_description_format),
            picture.title
        )
    imageView.contentDescription = contentDescription
}