package com.example.kmm.data.dataSource

import com.example.kmm.data.api.PokemonService
import com.example.kmm.data.mapper.PokemonMapper
import com.example.kmm.domain.entity.Pokemon

class PokemonDataSourceImpl(private val pokemonService: PokemonService): PokemonDataSource {

    override suspend fun getPokemons(): List<Pokemon> {
        return PokemonMapper.map(pokemonService.getPokemons().results)
    }
}