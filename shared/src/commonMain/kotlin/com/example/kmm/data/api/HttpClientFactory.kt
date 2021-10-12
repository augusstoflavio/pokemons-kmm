package com.example.kmm.data.api

import com.example.kmm.ApiEngine
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

object HttpClientFactory {

    fun create(): HttpClient {
        return HttpClient(ApiEngine().engine) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}