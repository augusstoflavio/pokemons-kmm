package com.example.kmm.data.mapper

import com.example.kmm.data.api.dto.PokemonDTO
import com.example.kmm.domain.entity.Pokemon

object PokemonMapper {

    fun map(pokemonDTO: PokemonDTO): Pokemon {
        val urlValues = pokemonDTO.url.split("/").filter { it.isNotEmpty() }
        val id = urlValues.last().toInt()

        return Pokemon(
            id = id,
            name = pokemonDTO.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
        )
    }

    fun map(pokemonDTO: List<PokemonDTO>): List<Pokemon> {
        return pokemonDTO.map { map(it) }
    }
}