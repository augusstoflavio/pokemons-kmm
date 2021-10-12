package com.example.kmm.data.dataSource

import com.example.kmm.domain.entity.Pokemon

interface PokemonDataSource {

    suspend fun getPokemons(): List<Pokemon>
}