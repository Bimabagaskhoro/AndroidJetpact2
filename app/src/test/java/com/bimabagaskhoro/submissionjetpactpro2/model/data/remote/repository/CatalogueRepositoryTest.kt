package com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.source.RemoteDataSource
import com.bimabagaskhoro.submissionjetpactpro2.utils.DataDetailDummy
import com.bimabagaskhoro.submissionjetpactpro2.utils.DataDummy
import com.bimabagaskhoro.submissionjetpactpro2.utils.LiveDataTestUtils
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val responseMovie = DataDummy.getRemoteMovies()
    private val responseTVShow = DataDummy.getRemoteTVShows()

    private val idMovie = responseMovie[0].id.toString()
    private val idTVShow = responseTVShow[0].id.toString()

    private val detailMovie = DataDetailDummy.getRemoteDetailMovie()
    private val detailTVShow = DataDetailDummy.getRemoteDetailTVShow()

    @Test
    fun getListMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadPlayingMovieCallback)
                .onAllMovieReceived(responseMovie)
            null
        }.`when`(remote).getListMovies(any())

        val movieEntity = LiveDataTestUtils.getValue(catalogueRepository.loadMovies())
        verify(remote).getListMovies(any())
        assertNotNull(movieEntity)
        assertEquals(responseMovie.size.toLong(), movieEntity.size.toLong())
    }

    @Test
    fun getDetailMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailMovieCallback)
                .onAllDetailMovieReceived(detailMovie)
            null
        }.`when`(remote).getDetailMovies(any(), eq(idMovie))

        val movieDetailEntity =
            LiveDataTestUtils.getValue(catalogueRepository.loadDetailMovies(idMovie))
        verify(remote).getDetailMovies(any(), eq(idMovie))
        assertNotNull(movieDetailEntity)
        assertEquals(detailMovie.id, movieDetailEntity.id)
    }

    @Test
    fun getListTVShows() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(responseTVShow)
            null
        }.`when`(remote).getListTVShows(any())

        val tvShowEntity = LiveDataTestUtils.getValue(catalogueRepository.loadTVShows())
        verify(remote).getListTVShows(any())
        assertNotNull(tvShowEntity)
        assertEquals(responseTVShow.size.toLong(), tvShowEntity.size.toLong())
    }

    @Test
    fun getDetailTVShows() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailTvShowCallback)
                .onAllDetailTvShowReceived(detailTVShow)
            null
        }.`when`(remote).getDetailTVShows(any(), eq(idTVShow))

        val tvShowDetailEntity =
            LiveDataTestUtils.getValue(catalogueRepository.loadDetailTVShows(idTVShow))
        verify(remote).getDetailTVShows(any(), eq(idTVShow))
        assertNotNull(tvShowDetailEntity)
        assertEquals(detailTVShow.id, tvShowDetailEntity.id)
    }
}