package edu.curso.agendacontato.model

import java.time.LocalDateTime

data class DashboardDTO (
    val momentoInicio : LocalDateTime,
    val momentoFinal : LocalDateTime,
    val temperaturaMinima : Double,
    val temperaturaMaxima : Double,
    val temperaturaMedia : Double,
    val temperaturas : List<Pair<LocalDateTime, Double>>,
    val umidadeMinima : Double,
    val umidadeMaxima : Double,
    val umidadeMedia : Double,
    val umidades : List<Pair<LocalDateTime,Double>>,
    val currentTimeStamp : LocalDateTime = LocalDateTime.now()
) {
}