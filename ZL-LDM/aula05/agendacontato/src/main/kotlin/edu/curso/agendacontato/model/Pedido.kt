package edu.curso.agendacontato.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Pedido(
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "table-pedidos")
    @TableGenerator(name="table-pedidos",
        table = "id_sequences",
        pkColumnName = "seq_id", valueColumnName = "seq_value",
        allocationSize = 1)
    @Id
    var id : Long,
    var descricao : String,
    var dataPedido : LocalDateTime,
    var dataEntrega : LocalDateTime,
    @Column(name="status", length = 20)
    var status : String,
    @ManyToOne
    var contato : Contato
)
