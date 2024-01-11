package com.pokedeck.application.data.repository

import com.pokedeck.application.api.ApiService
import com.pokedeck.application.data.model.Pokemon
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPokemonList(offset: Int, limit: Int): List<Pokemon> {
        return apiService.getPokemonList(offset, limit).results
    }
}