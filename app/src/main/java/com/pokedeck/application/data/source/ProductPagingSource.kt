package com.pokedeck.application.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pokedeck.application.api.ApiService
import com.pokedeck.application.data.model.Pokemon

class PokemonPagingSource(private val apiService: ApiService) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val page = params.key ?: 1 // Starting page index is 1
            val pageSize = 10
            val response = apiService.getPokemonList(page, pageSize)
            val products = response.body()!!.results
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (products.isNotEmpty()) page + 1 else null

            LoadResult.Page(products, prevKey, nextKey)
        } catch (e: Exception) {
            // Handle error
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        // We don't need to implement this function for now, so we return null
        return null
    }

}
