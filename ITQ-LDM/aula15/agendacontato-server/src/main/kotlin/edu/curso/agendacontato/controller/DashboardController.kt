package edu.curso.agendacontato.controller

import edu.curso.agendacontato.model.DashboardDTO
import edu.curso.agendacontato.model.Medicao
import edu.curso.agendacontato.repository.MedicaoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/dashboard")
class DashboardController (
    private val repositoryMedicao : MedicaoRepository
) {

    @GetMapping
    fun lerFaixaDados(@RequestParam("momentoInicio") momentoInicio : LocalDateTime = LocalDateTime.now(),
                      @RequestParam("momentoFinal") momentoFinal : LocalDateTime = LocalDateTime.now()
        ) : ResponseEntity<DashboardDTO>{

        val medicoes : List<Medicao> = repositoryMedicao
                                        .findAllByMomento( momentoInicio, momentoFinal )

        var temperaturaSoma = 0.0
        var temperaturaMinimo = 0.0
        var temperaturaMaximo = 0.0
        var umidadeSoma = 0.0
        var umidadeMinimo = 0.0
        var umidadeMaximo = 0.0
        var listaTemperaturas : MutableList<Pair<LocalDateTime, Double>> = mutableListOf()
        var listaUmidades : MutableList<Pair<LocalDateTime, Double>> = mutableListOf()
        for (medicao in medicoes) {
            temperaturaSoma += medicao.temperatura
            if (medicao.temperatura > temperaturaMaximo) {
                temperaturaMaximo = medicao.temperatura
            }
            if (medicao.temperatura < temperaturaMinimo) {
                temperaturaMinimo = medicao.temperatura
            }
            val pairTemp : Pair<LocalDateTime, Double> = Pair( medicao.timestamp, medicao.temperatura )
            listaTemperaturas.add( pairTemp )

            umidadeSoma += medicao.umidade
            if (medicao.umidade > umidadeMaximo) {
                umidadeMaximo = medicao.umidade
            }
            if (medicao.umidade < umidadeMinimo) {
                umidadeMinimo = medicao.umidade
            }
            val pairUmd : Pair<LocalDateTime, Double> = Pair( medicao.timestamp, medicao.umidade )
            listaUmidades.add( pairUmd )
        }

        val dashboardDTO = DashboardDTO(
            momentoInicio, momentoFinal, temperaturaMinimo, temperaturaMaximo,
            temperaturaMedia = temperaturaSoma / medicoes.size, listaTemperaturas,
            umidadeMinimo, umidadeMaximo,
            umidadeSoma / medicoes.size, listaUmidades
        )
        return ResponseEntity.ok( dashboardDTO )
    }
}