package com.example.kmm.data.api

import com.example.kmm.data.api.client.HttpClientFactory
import com.example.kmm.data.api.exception.NoConnectionException
import com.example.kmm.data.api.exception.ServerErrorException
import io.ktor.client.request.*

class Network {

    suspend inline fun <reified T> get(url: String): T {
        if (!CheckConnection.hasConnection()) {
            throw NoConnectionException()
        }

        val httpClient = HttpClientFactory.create()
        return try {
            httpClient.get(url)
        } catch (e: Exception) {
            throw ServerErrorException()
        } finally {
            httpClient.close()
        }
    }
}