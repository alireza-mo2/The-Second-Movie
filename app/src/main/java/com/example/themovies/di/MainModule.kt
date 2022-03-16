package com.example.themovies.di

import com.example.themovies.network.DataService
import com.example.themovies.repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideMainRepository(dataService: DataService): MainRepository {
        return MainRepository(dataService)
    }


}