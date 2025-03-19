package edu.curso.agendacontato.model

import java.time.LocalDateTime

data class PedidoDTO(
    var id : Long,
    var descricao : String,
    var dataPedido : LocalDateTime,
    var dataEntrega : LocalDateTime,
    var status : String,
    var contatoId : Long )
