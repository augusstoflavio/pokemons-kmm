package com.example.kmm.data.api

import io.ktor.client.engine.*

expect class ApiEngine() {
    val engine: HttpClientEngineFactory<HttpClientEngineConfig>
}