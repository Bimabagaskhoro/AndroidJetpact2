package com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    @SerializedName("results")
    val result: List<TvShowRemote>
)
