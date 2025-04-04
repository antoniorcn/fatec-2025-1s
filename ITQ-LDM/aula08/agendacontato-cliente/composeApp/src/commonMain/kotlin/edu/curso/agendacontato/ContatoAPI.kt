package edu.curso.agendacontato

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ContatoAPI( val httpClient : HttpClient ) {
    private val URL_BASE = "http://localhost:8090"
    suspend fun cadastrar( contato : Contato ) {
        httpClient.post("$URL_BASE/contato") {
            contentType(ContentType.Application.Json)
            setBody(contato)
        }
    }

    suspend fun lerTodos() : List<Contato> {
        return httpClient.get("$URL_BASE/contato").body<List<Contato>>()
    }

    suspend fun apagar(contato : Contato) {
        httpClient.delete("$URL_BASE/contato/${contato.id}")
    }

}