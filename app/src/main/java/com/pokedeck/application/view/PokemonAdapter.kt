package com.pokedeck.application.view

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pokedeck.application.data.model.Pokemon
import com.pokedeck.application.databinding.ItemPokemonBinding
import com.squareup.picasso.Picasso

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    private var pokemonList: List<Pokemon> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setPokemonList(list: List<Pokemon>) {
        pokemonList = list
        notifyDataSetChanged()
        Log.d("listpokemon",pokemonList.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    class PokemonViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon) {
            binding.textViewPokemonName.text = pokemon.name
            var imageUrl = "https://img.pokemondb.net/artwork/large/{$pokemon.name}.jpg"
            Picasso.get()
                .load(imageUrl)
                .fit()
                .centerInside()
                .into(binding.imageViewPokemon)
        }
    }
}
