package edu.curso.agendacontato.controller

import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.service.ContatoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/contato")
class ContatoController( val contatoService : ContatoService ) {

    @GetMapping
    fun contatos() : ResponseEntity<List<Contato>> {
        return ResponseEntity.ok(contatoService.listarTodos())
    }

//    @ExceptionHandler(Exception::class)
//    fun handleNoContent(e: Exception?): ResponseEntity<*> {
//        print("Erro acionado")
//        return ResponseEntity.ok(e?.message ?: "erro")
//    }

    @PostMapping
    fun criarContato( @RequestBody contato : Contato) : ResponseEntity<String> {
        contatoService.adicionar( contato )
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarContato (@PathVariable id : Long ) : ResponseEntity<String> {
        val apagado = contatoService.apagar( id )
        if (apagado) {
            return ResponseEntity( "Contato com id $id apagado com sucesso", 
                HttpStatus.ACCEPTED )
        } else { 
            return ResponseEntity( "Id $id não foi encontrado", 
                HttpStatus.NOT_FOUND )
        }
    }
}