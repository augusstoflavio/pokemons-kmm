package com.example.kmm.data.api

import com.example.kmm.data.api.dto.PokemonResponseDTO

interface PokemonService {

    suspend fun getPokemons(): PokemonResponseDTO
}