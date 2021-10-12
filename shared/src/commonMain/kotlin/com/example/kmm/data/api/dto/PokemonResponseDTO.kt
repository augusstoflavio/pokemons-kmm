package com.example.kmm.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponseDTO(
    val results: List<PokemonDTO>
)