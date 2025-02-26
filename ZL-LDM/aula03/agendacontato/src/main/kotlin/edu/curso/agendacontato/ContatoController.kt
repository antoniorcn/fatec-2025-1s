package edu.curso.agendacontato

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/contato")
class ContatoController {
    val lista = mutableListOf<Contato> (
//        Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111" ),
//        Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222" )
    )

    var contador : Long = 0

    @GetMapping
    fun contatos() : ResponseEntity<List<Contato>> {
        if ( lista.size > 0) {
            return ResponseEntity.ok(lista)
        } else {
            return ResponseEntity(lista, HttpStatus.NO_CONTENT)
//             throw Exception("Lista Vazia")
        }
    }

//    @ExceptionHandler(Exception::class)
//    fun handleNoContent(e: Exception?): ResponseEntity<*> {
//        print("Erro acionado")
//        return ResponseEntity.ok(e?.message ?: "erro")
//    }

    @PostMapping
    fun criarContato( @RequestBody contato : Contato ) : ResponseEntity<String> {
        contador++  // contador = contador + 1        contador += 1
        contato.id = contador
        lista.add( contato )
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagarContato (@PathVariable id : Long ) : ResponseEntity<String> {
        println("Lista size: ${lista.size}")
//        var i = 0
//        for (i in 0..< lista.size) {
//            println("i: $i ")
//            println("contato.id: ${lista[i].id}")
//            if (lista[i].id != null && lista[i].id == id) {
//                lista.removeAt(i)
//                i += 1
//            }
//        }
        val novaLista = lista.filter { it -> return@filter it.id != id }
        lista.clear()
        lista.addAll( novaLista )
        return ResponseEntity( "Contato com id $id apagado com sucesso", HttpStatus.ACCEPTED )
    }
}