package edu.curso.agendacontato.controller

import edu.curso.agendacontato.mapper.PedidoMapper
import edu.curso.agendacontato.model.Pedido
import edu.curso.agendacontato.model.PedidoDTO
import edu.curso.agendacontato.service.PedidoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pedido")
class PedidoController(val service : PedidoService,
    val mapper : PedidoMapper){

    @GetMapping
    fun listarTodos() : ResponseEntity<List<Pedido>> {
        return ResponseEntity.ok(service.listarTodos())
    }

    @PostMapping
    fun criar(@RequestBody pedidoDTO : PedidoDTO) : ResponseEntity<String> {
        val pedido = mapper.fromDTO( pedidoDTO )
        return if (pedido != null) {
            service.cadastrar( pedido )
            ResponseEntity("Pedido criado com sucesso", HttpStatus.CREATED)
        } else {
            ResponseEntity("Erro ao criar o pedido", HttpStatus.NOT_FOUND)
        }
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
    fun atualizar(@PathVariable id : Long, @RequestBody novoPedidoDTO : PedidoDTO) :
            ResponseEntity<String> {
        val novoPedido = mapper.fromDTO( novoPedidoDTO )
        return if (novoPedido != null) {
            if (service.atualizar(id, novoPedido)) {
                ResponseEntity("Pedido atualizado com sucesso", HttpStatus.CREATED)
            } else {
                ResponseEntity("ID do pedido não encontrado", HttpStatus.NOT_FOUND)
            }
        } else {
            ResponseEntity("Erro ao atualizar o pedido", HttpStatus.NOT_FOUND)
        }
    }
}