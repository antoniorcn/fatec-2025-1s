package edu.curso.agendacontato.model

import java.time.LocalDateTime

data class PedidoDTO (
    var id : Long,
    val descricao : String,
    val data : LocalDateTime,
    val dataEntrega : LocalDateTime,
    val status : String,
    var contatoId : Long
)