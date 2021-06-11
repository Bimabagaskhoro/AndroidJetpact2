package com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.source

import android.util.Log
import com.bimabagaskhoro.submissionjetpactpro2.model.api.ApiClient
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.movie.MovieDetailResponse
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.movie.MovieRemote
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.movie.MovieResponse
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.tvshow.TvShowDetailResponse
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.tvshow.TvShowRemote
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.tvshow.TvShowResponse
import com.bimabagaskhoro.submissionjetpactpro2.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        const val TAG = "Remote Data Source"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
        }
    }

    fun getListMovies(callback: LoadPlayingMovieCallback) {
        EspressoIdlingResource.increment()
        ApiClient.getApiEndPoint().getListMovies(1)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    callback.onAllMovieReceived(response.body()?.result)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.e(TAG, "Failure ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    fun getDetailMovies(callback: LoadDetailMovieCallback, id: String) {
        EspressoIdlingResource.increment()
        ApiClient.getApiEndPoint().getDetailMovies(id)
            .enqueue(object : Callback<MovieDetailResponse> {
                override fun onResponse(
                    call: Call<MovieDetailResponse>,
                    response: Response<MovieDetailResponse>
                ) {
                    callback.onAllDetailMovieReceived(response.body())
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                    Log.e(TAG, "getDetailMovies onFailure : ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    fun getListTVShows(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiClient.getApiEndPoint().getListTVShows(1)
            .enqueue(object : Callback<TvShowResponse> {
                override fun onResponse(
                    call: Call<TvShowResponse>,
                    response: Response<TvShowResponse>
                ) {
                    callback.onAllTvShowReceived(response.body()?.result)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                    Log.e(TAG, "Failure ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    fun getDetailTVShows(callback: LoadDetailTvShowCallback, id: String) {
        EspressoIdlingResource.increment()
        ApiClient.getApiEndPoint().getDetailTVShows(id)
            .enqueue(object : Callback<TvShowDetailResponse> {
                override fun onResponse(
                    call: Call<TvShowDetailResponse>,
                    response: Response<TvShowDetailResponse>
                ) {
                    callback.onAllDetailTvShowReceived(response.body())
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                    Log.e(TAG, "getDetailsTVShows onFailure : ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    interface LoadPlayingMovieCallback {
        fun onAllMovieReceived(moviesResponse: List<MovieRemote>?)
    }

    interface LoadDetailMovieCallback {
        fun onAllDetailMovieReceived(moviesDetail: MovieDetailResponse?)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvResponse: List<TvShowRemote>?)
    }

    interface LoadDetailTvShowCallback {
        fun onAllDetailTvShowReceived(tvShowDetail: TvShowDetailResponse?)
    }
}