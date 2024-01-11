package com.pokedeck.application.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pokedeck.application.data.model.Pokemon
import com.pokedeck.application.databinding.ItemPokemonBinding


class PokemonAdapter :
    PagingDataAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(ProductDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    inner class PokemonViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: Pokemon?) {
            pokemon?.let {
                binding.textViewPokemonName.text = pokemon.name
                var url = "https://img.pokemondb.net/artwork/large/" + pokemon.name + ".jpg"
                Glide.with(binding.root)
                    .load(url)
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.imageViewPokemon)
            }
        }
    }

    object ProductDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }

}

