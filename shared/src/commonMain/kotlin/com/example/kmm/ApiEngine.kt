package com.example.kmm

import io.ktor.client.engine.*

expect class ApiEngine() {
    val engine: HttpClientEngineFactory<HttpClientEngineConfig>
}