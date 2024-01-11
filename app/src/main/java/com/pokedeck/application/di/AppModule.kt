package com.pokedeck.application.di

import android.content.Context
import com.pokedeck.application.AppController
import com.pokedeck.application.api.ApiService
import com.pokedeck.application.data.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): AppController {
        return app as AppController
    }

    @Provides
    @Singleton
    fun providePokemonRepository(apiService: ApiService): PokemonRepository {
        return PokemonRepository(apiService)
    }

}