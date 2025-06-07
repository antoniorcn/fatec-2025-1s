package edu.curso.agendacontato.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Medicao(
    @Id @GeneratedValue
    val id : Long? = null,
    val temperatura : Double,
    val umidade : Double,
    val timestamp : LocalDateTime = LocalDateTime.now()
){
    constructor() : this(0, 0.0, 0.0, LocalDateTime.now())
}