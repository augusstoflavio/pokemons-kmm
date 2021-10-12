package com.example.kmm

import io.ktor.client.engine.*
import io.ktor.client.engine.android.*

actual class ApiEngine actual constructor() {
    actual val engine: HttpClientEngineFactory<HttpClientEngineConfig> = Android
}