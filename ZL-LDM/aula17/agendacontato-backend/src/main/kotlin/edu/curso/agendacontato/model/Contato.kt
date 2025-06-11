package edu.curso.agendacontato.model

import jakarta.persistence.*

@Entity
data class Contato(
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "contato-generator")
    @TableGenerator(name = "contato-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    var id : Long?,
    val nome : String,
    val email : String,
    val telefone : String
)
