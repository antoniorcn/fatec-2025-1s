package edu.curso.agendacontato.model

data class DashboardDTOView(
    val temperaturaMinima : Double,
    val temperaturaMaxima : Double,
    val temperaturaMedia : Double,
    val medicoes : List<Medicao>
)