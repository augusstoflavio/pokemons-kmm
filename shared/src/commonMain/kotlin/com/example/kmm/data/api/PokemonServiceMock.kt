package com.example.kmm.data.api

class PokemonServiceMock: PokemonService {

    override suspend fun getPokemons(): PokemonResponse {
        return PokemonResponse(
            results = listOf(
                PokemonDTO("Bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                PokemonDTO("Ivysaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                PokemonDTO("Venesaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                PokemonDTO("Charmander", "https://pokeapi.co/api/v2/pokemon/1/"),
            )
        )
    }
}