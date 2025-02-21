package edu.curso.HelloWorldSpringBoot.controller

import edu.curso.HelloWorldSpringBoot.model.Contato
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/contato")
class ContatoController {

    val listaContatos = mutableListOf<Contato>()

    @GetMapping("/")
    fun listarTodos() : ResponseEntity<List<Contato>> {
        return ResponseEntity.ok(listaContatos)
    }

    @PostMapping("/")
    fun criarContato(@RequestBody contato : Contato) {
        listaContatos.add( contato );
    }

}