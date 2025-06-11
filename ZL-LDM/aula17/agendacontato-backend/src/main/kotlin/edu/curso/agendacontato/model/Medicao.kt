package edu.curso.agendacontato.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Medicao(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "contato-generator")
    @TableGenerator(name = "medicao-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val temperatura : Double,
    val umidade : Double,
    val timestamp : LocalDateTime = LocalDateTime.now()
)
