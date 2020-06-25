package com.example.gallery

import com.google.gson.annotations.SerializedName
import java.util.*

data class Pixabay(
    val totalHits: Int,
    val total: Int,
    val hits: Array<PhotoItem>
)

data class PhotoItem(
    val comments: Int,
    val downloads: Int,
    val favorites: Int,
    @SerializedName("id") val photoId: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val imageWidth: Int,
    @SerializedName("largeImageURL") val fullUrl: String,
    val likes: Int,
    val pageURL: String,
    val previewURL: String,
    val previewWidth: Int,
    val tags: Array<String>,
    val type: String,
    val user: String,
    val userImageURL: String,
    val user_id: Int,
    val views: Int,
    val webformatHeight: Int,
    @SerializedName("webformatURL") val previewUrl: String,
    val webformatWidth: Int


)