package com.example.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kmm.android.databinding.ActivityMainBinding
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
        viewModel.pokemons.observe(this) {
            when(it) {
                is Resource.Loading -> {binding.progress.visibility = View.VISIBLE}
                is Resource.Failure -> {binding.progress.visibility = View.INVISIBLE}
                is Resource.Success -> {
                    binding.progress.visibility = View.INVISIBLE
                    pokemonAdapter.submitList(it.data)
                }
            }
        }
    }

    private fun setupList() {
        binding.rvPokemons.adapter = pokemonAdapter
        binding.rvPokemons.layoutManager = LinearLayoutManager(this)
    }
}
