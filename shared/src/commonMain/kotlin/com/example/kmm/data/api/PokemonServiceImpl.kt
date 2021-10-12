package com.example.kmm.data.api

import io.ktor.client.request.*

class PokemonServiceImpl(): PokemonService {
    override suspend fun getPokemons(): PokemonResponse {
        return HttpClientFactory.create().get("https://pokeapi.co/api/v2/pokemon?limit=99999")
    }
}