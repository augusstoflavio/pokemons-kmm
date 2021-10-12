package com.example.kmm.data.api

import com.example.kmm.data.api.dto.PokemonResponseDTO

class PokemonServiceImpl(private val network: Network) : PokemonService {

    override suspend fun getPokemons(): PokemonResponseDTO {
        return network.get("https://pokeapi.co/api/v2/pokemon?limit=99999")
    }
}