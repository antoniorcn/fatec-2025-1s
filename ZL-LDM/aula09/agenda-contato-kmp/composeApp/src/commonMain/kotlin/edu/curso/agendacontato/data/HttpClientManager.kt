package edu.curso.agendacontato.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MeuLogger : Logger {
    override fun log(message: String) {
        println(message)
    }
}

fun createHttpClient() =
    HttpClient {
        install(ContentNegotiation) {
            json( Json {
                coerceInputValues = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            level = LogLevel.ALL
            logger = MeuLogger()
        }
    }
