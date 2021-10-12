package com.example.kmm.domain.useCase

import com.example.kmm.domain.entity.Pokemon
import com.example.kmm.domain.repository.PokemonRepository

class GetPokemons(private val pokemonRepository: PokemonRepository) {

    suspend operator fun invoke(): List<Pokemon> {
        return pokemonRepository.getPokemons()
    }
}