package com.bimabagaskhoro.submissionjetpactpro2.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.repository.CatalogueRepository
import com.bimabagaskhoro.submissionjetpactpro2.utils.DataDummy
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
class ShowViewModelTest {
    private lateinit var viewModel: ShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<List<MovieEntity>>

    @Mock
    private lateinit var tvObserver: Observer<List<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = ShowViewModel(catalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovie = DataDummy.generateDummyMovie()
        val listMovie = MutableLiveData<List<MovieEntity>>()
        listMovie.value = dummyMovie

        Mockito.`when`(catalogueRepository.loadMovies()).thenReturn(listMovie)
        val movieEntity = viewModel.getListMovie().value
        verify(catalogueRepository).loadMovies()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)

        viewModel.getListMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTVShows() {
        val dummyTVShow = DataDummy.generateDummyTvShow()
        val listTVShow = MutableLiveData<List<TvShowEntity>>()
        listTVShow.value = dummyTVShow

        Mockito.`when`(catalogueRepository.loadTVShows()).thenReturn(listTVShow)
        val tvShowEntity = viewModel.getListTvShow().value
        verify(catalogueRepository).loadTVShows()
        assertNotNull(tvShowEntity)
        assertEquals(5, tvShowEntity?.size)

        viewModel.getListTvShow().observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTVShow)
    }
}