package com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.source

import androidx.lifecycle.LiveData
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.DetailEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.TvShowEntity

interface DataSource {
    fun loadMovies(): LiveData<List<MovieEntity>>

    fun loadDetailMovies(movieID: String): LiveData<DetailEntity>

    fun loadTVShows(): LiveData<List<TvShowEntity>>

    fun loadDetailTVShows(tvShowID: String): LiveData<DetailEntity>
}