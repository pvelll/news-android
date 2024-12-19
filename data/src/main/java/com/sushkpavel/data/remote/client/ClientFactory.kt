package com.sushkpavel.data.remote.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import kotlinx.serialization.json.Json
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.json

class ClientFactory {
    fun build() : HttpClient { // its familiar for me to use ktor, i love it. But i can do the same in retrofit, its not hard
        return HttpClient(CIO){
            install(Logging){
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
            install(ContentNegotiation) {
                json(Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}