package com.bimabagaskhoro.submissionjetpactpro2.model.data.entity

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("overview")
    val desc: String,
    @SerializedName("original_language")
    val original_language: String
)
