package edu.curso.agendacontato.model

import java.time.LocalDateTime

data class Pedido (
    var id : Long,
    val descricao : String,
    val data : LocalDateTime,
    val dataEntrega : LocalDateTime,
    val status : String,
    var contato : Contato
) {
}