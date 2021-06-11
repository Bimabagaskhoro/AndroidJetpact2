package com.bimabagaskhoro.submissionjetpactpro2.model.data.entity

import com.google.gson.annotations.SerializedName

data class DetailEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("poster_path")
    val imageDetail: String,
    @SerializedName("overview")
    val desc: String,
    @SerializedName("backdrop_path")
    val imageBackdrop: String,
    @SerializedName("original_language")
    val original_language: String
)
