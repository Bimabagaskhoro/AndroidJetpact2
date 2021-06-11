package com.bimabagaskhoro.submissionjetpactpro2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.DetailEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.repository.CatalogueRepository

class DetailViewModel (private val catalogueRepository: CatalogueRepository) : ViewModel(){

    private lateinit var dataDetail: LiveData<DetailEntity>

    companion object {
        const val MOVIE = "detail_movie"
        const val TV_SHOW = "detail_tv"
    }

    fun setDetail(id: String, choose: String) {
        when(choose) {
            MOVIE -> {
                dataDetail = catalogueRepository.loadDetailMovies(id)
            }
            TV_SHOW -> {
                dataDetail = catalogueRepository.loadDetailTVShows(id)
            }
        }
    }

    fun getDetail() = dataDetail
}