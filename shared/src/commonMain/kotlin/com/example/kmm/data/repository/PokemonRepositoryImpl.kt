package com.example.kmm.data.repository

import com.example.kmm.data.dataSource.PokemonDataSource
import com.example.kmm.domain.entity.Pokemon
import com.example.kmm.domain.repository.PokemonRepository

class PokemonRepositoryImpl(private val pokemonDataSource: PokemonDataSource): PokemonRepository {

    override suspend fun getPokemons(): List<Pokemon> {
        return pokemonDataSource.getPokemons()
    }
}