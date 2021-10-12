package com.example.kmm.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDTO (
    val name: String,
    val url: String,
)