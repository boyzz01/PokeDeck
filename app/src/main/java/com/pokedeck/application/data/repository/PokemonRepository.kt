package com.pokedeck.application.data.repository

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pokedeck.application.api.ApiService
import com.pokedeck.application.data.model.Pokemon
import com.pokedeck.application.data.source.PokemonPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val apiService: ApiService) {
     fun getPokemonList() : Flow<PagingData<Pokemon>> {
         return Pager(
             config = PagingConfig(
                 pageSize = PAGE_SIZE,
                 enablePlaceholders = false
             ),
             pagingSourceFactory = {
                 PokemonPagingSource(apiService)
             }
         ).flow
    }
    companion object {
        private const val PAGE_SIZE = 10
    }

}