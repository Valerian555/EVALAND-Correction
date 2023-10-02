package com.technipixl.exo1

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun setupImage(url: String, imageView: ImageView) {
    Picasso.get()
        .load(url)
        .fit()  //redimensione l'image par rapport à son conteneur
        .centerCrop()  //option permettant de choisir le type d'affichage de l'image (il y a différents types)
        .into(imageView)
}