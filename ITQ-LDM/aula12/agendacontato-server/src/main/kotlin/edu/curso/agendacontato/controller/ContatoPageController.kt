package edu.curso.agendacontato.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller("/")
class ContatoPageController {

    @GetMapping
    fun welcomeContatos() : ResponseEntity<String> {
        return ResponseEntity.ok(
            """Bem vindo ao sistema de contato,
               Para acessar este sistema é preciso
               usar a API Rest
            """.trimMargin())
    }
}