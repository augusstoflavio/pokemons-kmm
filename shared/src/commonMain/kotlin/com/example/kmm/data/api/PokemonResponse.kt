package com.example.kmm.data.api

import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(
    val results: List<PokemonDTO>
)