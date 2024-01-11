package com.pokedeck.application.view

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.pokedeck.application.common.base.BaseActivity
import com.pokedeck.application.databinding.ActivityMainBinding
import com.pokedeck.application.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel by viewModels<MainViewModel>()
    private lateinit var pokemonAdapter: PokemonAdapter


    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


    override fun setupViews() {
        viewModel.getPokemonList()
        with(binding){
            pokemonAdapter = PokemonAdapter()
            rvPokemonList.apply {
                adapter = pokemonAdapter
                layoutManager = GridLayoutManager(this@MainActivity,2)
            }
        }
        mCustomProgressBar.showProgressBar()
    }

    override fun observeViewModel() {
        viewModel.pokemonList.observe(this) { pagingData ->
            mCustomProgressBar.hideProgressBar()
            pokemonAdapter.submitData(lifecycle, pagingData)
        }
    }
}