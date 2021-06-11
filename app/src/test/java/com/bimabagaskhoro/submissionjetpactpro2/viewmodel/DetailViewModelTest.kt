package com.bimabagaskhoro.submissionjetpactpro2.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.DetailEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.repository.CatalogueRepository
import com.bimabagaskhoro.submissionjetpactpro2.utils.DataDetailDummy
import com.bimabagaskhoro.submissionjetpactpro2.viewmodel.DetailViewModel.Companion.MOVIE
import com.bimabagaskhoro.submissionjetpactpro2.viewmodel.DetailViewModel.Companion.TV_SHOW
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private val dummyDetailMovie = DataDetailDummy.getDetailMovie()
    private val movieID = dummyDetailMovie.id.toString()

    private val dummyDetailTvShow = DataDetailDummy.getDetailTVShow()
    private val tvShowID = dummyDetailTvShow.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<DetailEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<DetailEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<DetailEntity>()
        movie.value = dummyDetailMovie

        Mockito.`when`(catalogueRepository.loadDetailMovies(movieID)).thenReturn(movie)
        viewModel.setDetail(movieID, MOVIE)
        val detailMovie = viewModel.getDetail().value
        verify(catalogueRepository).loadDetailMovies(movieID)
        assertNotNull(detailMovie)

        dummyDetailMovie.apply {
            assertEquals(id, detailMovie?.id)
            assertEquals(title, detailMovie?.title)
            assertEquals(date, detailMovie?.date)
            assertEquals(genres, detailMovie?.genres)
            assertEquals(imageDetail, detailMovie?.imageDetail)
            assertEquals(desc, detailMovie?.desc)
            assertEquals(imageBackdrop, detailMovie?.imageBackdrop)
            assertEquals(original_language, detailMovie?.original_language)
        }

        viewModel.getDetail().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyDetailMovie)
    }

    @Test
    fun getTVShow() {
        val tvShow = MutableLiveData<DetailEntity>()
        tvShow.value = dummyDetailTvShow

        Mockito.`when`(catalogueRepository.loadDetailTVShows(tvShowID)).thenReturn(tvShow)
        viewModel.setDetail(tvShowID, TV_SHOW)
        val detailTvShow = viewModel.getDetail().value
        verify(catalogueRepository).loadDetailTVShows(tvShowID)
        assertNotNull(detailTvShow)

        dummyDetailTvShow.apply {
            assertEquals(id, detailTvShow?.id)
            assertEquals(title, detailTvShow?.title)
            assertEquals(date, detailTvShow?.date)
            assertEquals(genres, detailTvShow?.genres)
            assertEquals(imageDetail, detailTvShow?.imageDetail)
            assertEquals(desc, detailTvShow?.desc)
            assertEquals(imageBackdrop, detailTvShow?.imageBackdrop)
            assertEquals(original_language, detailTvShow?.original_language)
        }

        viewModel.getDetail().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyDetailTvShow)
    }
}