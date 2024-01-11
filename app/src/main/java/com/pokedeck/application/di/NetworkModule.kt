package com.pokedeck.application.di

import com.pokedeck.application.api.ApiClient
import com.pokedeck.application.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return ApiClient.create()
    }
}