package edu.curso.agendacontato.controller

import edu.curso.agendacontato.mapper.PedidoMapper
import edu.curso.agendacontato.model.PedidoDTO
import edu.curso.agendacontato.model.PedidoDTOView
import edu.curso.agendacontato.service.PedidoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/pedido")
class PedidoController(val pedidoService : PedidoService,
    val pedidoMapper : PedidoMapper
) {

    @GetMapping
    fun pedidos() : ResponseEntity<List<PedidoDTOView>> {
        val pedidos = pedidoService.listarTodos()
        val pedidosDTO = pedidos.map{ pedidoMapper.toDTO(it) }
        return ResponseEntity.ok(pedidosDTO)
    }

    @PostMapping
    fun criarPedido( @RequestBody pedidoDTO : PedidoDTO) : ResponseEntity<String> {
        val pedido = pedidoMapper.fromDTO(pedidoDTO)
        if (pedido != null) {
            pedidoService.adicionar(pedido)
            return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
        } else {
            return ResponseEntity("Falhar ao gerar o pedido", HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun apagarPedido (@PathVariable id : Long ) : ResponseEntity<String> {
        val apagado = pedidoService.apagar( id )
        if (apagado) {
            return ResponseEntity( "Pedido com id $id apagado com sucesso",
                HttpStatus.ACCEPTED )
        } else { 
            return ResponseEntity( "Id $id não foi encontrado", 
                HttpStatus.NOT_FOUND )
        }
    }
}