package com.bimabagaskhoro.submissionjetpactpro2.di

import android.content.Context
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.repository.CatalogueRepository
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.source.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogueRepository.getInstance(remoteDataSource)
    }
}