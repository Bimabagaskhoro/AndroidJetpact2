package com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.DetailEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.movie.MovieDetailResponse
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.movie.MovieRemote
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.tvshow.TvShowDetailResponse
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.tvshow.TvShowRemote
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.source.DataSource
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.source.RemoteDataSource

class FakeCatalogueRepository (private val remoteDataSource: RemoteDataSource) :
    DataSource {
    override fun loadMovies(): LiveData<List<MovieEntity>> {
        val getMovie = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getListMovies(object : RemoteDataSource.LoadPlayingMovieCallback {
            override fun onAllMovieReceived(moviesResponse: List<MovieRemote>?) {
                val listMovie = ArrayList<MovieEntity>()
                if (moviesResponse != null) {
                    for (movies in moviesResponse) {
                        movies.apply {
                            val movie = MovieEntity(id, title, date, image, desc, original_language)
                            listMovie.add(movie)
                        }
                    }
                    getMovie.postValue(listMovie)
                }
            }
        })
        return getMovie
    }

    override fun loadDetailMovies(movieID: String): LiveData<DetailEntity> {
        val getDetailMovie = MutableLiveData<DetailEntity>()

        remoteDataSource.getDetailMovies(object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onAllDetailMovieReceived(moviesDetail: MovieDetailResponse?) {
                lateinit var detailMovie: DetailEntity
                moviesDetail?.apply {

                    val listGenre = ArrayList<String>()
                    for (genre in genres) {
                        listGenre.add(genre.name)
                    }

                    detailMovie = DetailEntity(
                        id, title, date, listGenre, imageDetail, desc, imageBackdrop, original_language
                    )
                    getDetailMovie.postValue(detailMovie)
                }
            }
        }, movieID)
        return getDetailMovie
    }

    override fun loadTVShows(): LiveData<List<TvShowEntity>> {
        val getTVShow = MutableLiveData<List<TvShowEntity>>()

        remoteDataSource.getListTVShows(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvResponse: List<TvShowRemote>?) {
                val listTVShow = ArrayList<TvShowEntity>()
                if (tvResponse != null) {
                    for (tvShows in tvResponse) {
                        tvShows.apply {
                            val tvShow = TvShowEntity(id, title, date, desc, image, original_language)
                            listTVShow.add(tvShow)
                        }
                    }
                    getTVShow.postValue(listTVShow)
                }
            }
        })
        return getTVShow
    }

    override fun loadDetailTVShows(tvShowID: String): LiveData<DetailEntity> {
        val getDetailTVShow = MutableLiveData<DetailEntity>()

        remoteDataSource.getDetailTVShows(object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onAllDetailTvShowReceived(tvShowDetail: TvShowDetailResponse?) {
                lateinit var detailTVShow: DetailEntity
                tvShowDetail?.apply {

                    val listGenre = ArrayList<String>()
                    for (genre in genres) {
                        listGenre.add(genre.name)
                    }

                    detailTVShow = DetailEntity(
                        id, title, date, listGenre, imageDetail, desc, imageBackdrop, original_language
                    )
                    getDetailTVShow.postValue(detailTVShow)
                }
            }
        }, tvShowID)
        return getDetailTVShow
    }
}