package com.example.kmm.data.api

interface PokemonService {

    suspend fun getPokemons(): PokemonResponse
}