package edu.curso.agendacontato.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Past
import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime

data class PedidoDTO(
    var id : Long,
    @field:NotEmpty
    var descricao : String,
    @field:Past
    var dataPedido : LocalDateTime,
    var dataEntrega : LocalDateTime,
    @field:Length(max = 20)
    @field:NotEmpty
    var status : String,
    @field:Min(1)
    var contatoId : Long )
