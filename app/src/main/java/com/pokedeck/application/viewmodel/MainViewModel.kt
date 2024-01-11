package com.pokedeck.application.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.pokedeck.application.api.ApiService
import com.pokedeck.application.common.base.BaseViewModel
import com.pokedeck.application.data.model.Pokemon
import com.pokedeck.application.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PokemonRepository
):BaseViewModel() {

    private val _pokemonList = MutableLiveData<PagingData<Pokemon>>()
    val pokemonList: LiveData<PagingData<Pokemon>> = _pokemonList

     fun getPokemonList() {
         viewModelScope.launch {
             try {
                 repository.getPokemonList().collectLatest { pagingData ->
                     _pokemonList.value = pagingData
                 }
             } catch (e: Exception) {
                 // Handle error
             }
         }
     }
}