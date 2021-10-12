package com.example.kmm.data.api

import com.example.kmm.data.api.dto.PokemonDTO
import com.example.kmm.data.api.dto.PokemonResponseDTO

class PokemonServiceMock: PokemonService {

    override suspend fun getPokemons(): PokemonResponseDTO {
        return PokemonResponseDTO(
            results = listOf(
                PokemonDTO("Bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                PokemonDTO("Ivysaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                PokemonDTO("Venesaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                PokemonDTO("Charmander", "https://pokeapi.co/api/v2/pokemon/1/"),
            )
        )
    }
}