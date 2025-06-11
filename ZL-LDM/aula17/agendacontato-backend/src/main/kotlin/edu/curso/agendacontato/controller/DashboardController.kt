package edu.curso.agendacontato.controller

import edu.curso.agendacontato.model.DashboardDTOView
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
    private val repository : MedicaoRepository
){

    @GetMapping
    fun lerDados(
        @RequestParam("inicio") inicio : LocalDateTime = LocalDateTime.now(),
        @RequestParam("termino") termino : LocalDateTime = LocalDateTime.now()
    ) : ResponseEntity<DashboardDTOView> {
        val lista : MutableList<Medicao> = mutableListOf()

        lista.addAll( repository.findAllByTime( inicio, termino ) )

        var temperaturaSoma = 0.0
        var temperaturaMaxima = Double.MIN_VALUE
        var temperaturaMinima = Double.MAX_VALUE

        for (medicao in lista) {
            temperaturaSoma += medicao.temperatura
            if (medicao.temperatura > temperaturaMaxima) {
                temperaturaMaxima = medicao.temperatura
            }
            if (medicao.temperatura < temperaturaMinima) {
                temperaturaMinima = medicao.temperatura
            }
        }

        val temperaturaMedia = temperaturaSoma / lista.size

        val dashboardDTO = DashboardDTOView(
            temperaturaMinima, temperaturaMaxima, temperaturaMedia,
            lista    )

        return ResponseEntity.ok(dashboardDTO)
    }
}