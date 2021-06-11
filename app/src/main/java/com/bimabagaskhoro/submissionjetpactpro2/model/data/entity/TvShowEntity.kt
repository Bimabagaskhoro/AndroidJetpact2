package com.bimabagaskhoro.submissionjetpactpro2.model.data.entity

import com.google.gson.annotations.SerializedName

data class TvShowEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val title: String,
    @SerializedName("first_air_date")
    val date: String,
    @SerializedName("overview")
    val desc: String,
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("original_language")
    val original_language: String
)
