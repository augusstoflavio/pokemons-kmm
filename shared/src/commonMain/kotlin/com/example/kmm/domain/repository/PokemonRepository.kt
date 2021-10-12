package com.example.kmm.domain.repository

import com.example.kmm.domain.entity.Pokemon

interface PokemonRepository {

    suspend fun getPokemons(): List<Pokemon>
}