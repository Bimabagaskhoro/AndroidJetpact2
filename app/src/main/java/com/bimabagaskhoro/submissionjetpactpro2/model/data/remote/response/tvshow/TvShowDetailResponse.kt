package com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.tvshow

import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.GenreResponse
import com.google.gson.annotations.SerializedName

data class TvShowDetailResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_name")
    val title: String,
    @SerializedName("first_air_date")
    val date: String,
    @SerializedName("genres")
    val genres: List<GenreResponse>,
    @SerializedName("poster_path")
    val imageDetail: String,
    @SerializedName("overview")
    val desc: String,
    @SerializedName("backdrop_path")
    val imageBackdrop: String,
    @SerializedName("original_language")
    val original_language: String
)
