package edu.curso.agendacontato.model

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Past
import java.time.LocalDateTime

data class PedidoDTO (
    var id : Long,
    @field:NotEmpty()
    val descricao : String,
    @field:Past()
    val data : LocalDateTime,
    val dataEntrega : LocalDateTime,
    @field:NotEmpty()
    val status : String,
    var contatoId : Long
)