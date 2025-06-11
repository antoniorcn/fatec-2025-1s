package edu.curso.agendacontato.model

import jakarta.persistence.*

@Entity
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "usuario-generator")
    @TableGenerator(name = "usuario-generator",
        table = "id_sequences",
        pkColumnName = "seq_id",
        valueColumnName = "seq_value")
    val id : Long,
    // val contato : Contato,
    val nome : String,
    val email : String,
    val senha : String,
    val perfilAcesso : String
)