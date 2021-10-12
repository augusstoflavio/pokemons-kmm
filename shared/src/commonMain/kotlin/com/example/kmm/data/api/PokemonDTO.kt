package com.example.kmm.data.api

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDTO (
    val name: String,
    val url: String,
)