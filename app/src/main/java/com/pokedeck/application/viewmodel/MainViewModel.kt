package com.pokedeck.application.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.pokedeck.application.api.ApiService
import com.pokedeck.application.common.base.BaseViewModel
import com.pokedeck.application.data.model.Pokemon
import com.pokedeck.application.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PokemonRepository
):BaseViewModel() {

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList: StateFlow<List<Pokemon>> get() = _pokemonList

     fun getPokemonList() {
        viewModelScope.launch {
            _pokemonList.value = repository.getPokemonList(0, 10)
        }
    }
}