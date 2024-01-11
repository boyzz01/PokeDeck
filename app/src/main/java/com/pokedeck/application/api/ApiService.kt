package com.pokedeck.application.api


import com.pokedeck.application.data.model.PokemonResponse
import retrofit2.http.*

interface ApiService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): PokemonResponse


}