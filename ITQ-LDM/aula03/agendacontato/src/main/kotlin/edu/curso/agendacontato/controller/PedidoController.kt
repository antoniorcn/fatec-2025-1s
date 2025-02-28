package edu.curso.agendacontato.controller

import edu.curso.agendacontato.model.Pedido
import edu.curso.agendacontato.service.PedidoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

class PedidoController(@Autowired val service : PedidoService){

    @GetMapping
    fun listarTodos() : ResponseEntity<List<Pedido>> {
        return ResponseEntity.ok(service.listarTodos())
    }

    @PostMapping
    fun criar(@RequestBody pedido : Pedido) : ResponseEntity<String> {
        service.cadastrar( pedido )
        return ResponseEntity("Pedido criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun remover(@PathVariable("id") id : Long) : ResponseEntity<String> {
        return if (!service.apagar(id)) {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity("Pedido foi removido com sucesso", HttpStatus.OK)
        }
    }

    @DeleteMapping
    fun removerParam(@RequestParam("id") id : Long) : ResponseEntity<String> {
        return if (!service.apagar(id)) {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity("Pedido foi removido com sucesso", HttpStatus.OK)
        }
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id : Long, @RequestBody novoPedido : Pedido) :
            ResponseEntity<String> {
        return if (service.atualizar(id, novoPedido))
            ResponseEntity("Pedido atualizado com sucesso", HttpStatus.OK)
        else
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
    }
}