package com.bimabagaskhoro.submissionjetpactpro2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.repository.CatalogueRepository

class ShowViewModel (private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getListMovie(): LiveData<List<MovieEntity>> = catalogueRepository.loadMovies()

    fun getListTvShow(): LiveData<List<TvShowEntity>> = catalogueRepository.loadTVShows()
}