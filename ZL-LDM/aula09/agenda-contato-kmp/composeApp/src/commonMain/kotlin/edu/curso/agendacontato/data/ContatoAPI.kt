package edu.curso.agendacontato.data

import edu.curso.agendacontato.domain.Contato
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class ContatoAPI( val httpClient : HttpClient ) {

    val URL_BASE = "http://192.168.15.3:8080"


    suspend fun gravar( contato : Contato ) {
        val clientHttp = createHttpClient()
        clientHttp.post(urlString = "$URL_BASE/contato"){
            contentType(ContentType.Application.Json)
            setBody( contato )
        }
    }

    suspend fun lerTodos() : List<Contato> {
        val clientHttp = createHttpClient()
        val listaContatos = clientHttp
            .get("$URL_BASE/contato")
            .body<List<Contato>>()
        return listaContatos
    }

}