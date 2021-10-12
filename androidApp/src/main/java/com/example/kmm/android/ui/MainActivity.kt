package com.example.kmm.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kmm.android.databinding.ActivityMainBinding
import com.example.kmm.android.extensions.observerResource
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemonAdapter = PokemonAdapter(this)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupList()
        setupObserver()
    }

    private fun setupObserver() {
        observerResource(viewModel.pokemons, binding.progress) {
            pokemonAdapter.submitList(it)
        }
    }

    private fun setupList() {
        binding.rvPokemons.adapter = pokemonAdapter
        binding.rvPokemons.layoutManager = LinearLayoutManager(this)
    }
}
