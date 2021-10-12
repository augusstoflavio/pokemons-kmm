package com.example.kmm.android

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kmm.android.databinding.AdapterPokemonBinding
import com.example.kmm.domain.entity.Pokemon

class PokemonAdapter(private val context: Context): ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(PokemonAdapter) {

    class PokemonViewHolder(private val binding: AdapterPokemonBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: Pokemon) {
            binding.tvName.text = pokemon.name

            Glide
                .with(context)
                .load(pokemon.image)
                .centerCrop()
                .into(binding.imPokemon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = AdapterPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private companion object : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}