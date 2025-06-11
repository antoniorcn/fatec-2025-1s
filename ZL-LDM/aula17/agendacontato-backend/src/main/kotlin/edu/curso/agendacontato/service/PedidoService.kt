package edu.curso.agendacontato.service

import edu.curso.agendacontato.model.Pedido
import edu.curso.agendacontato.repository.PedidoRepository
import org.springframework.stereotype.Service

@Service
class PedidoService( val pedidoRepository: PedidoRepository ) {

    fun adicionar( pedido : Pedido ) {
        pedidoRepository.save( pedido )
    }

    fun procurarPorId( id : Long ) : Pedido? {
        val pedidoOptional = pedidoRepository.findById( id )
        return pedidoOptional.orElse( null )
    }

    fun apagar( id : Long ) : Boolean {
        val pedido = procurarPorId( id )
        return if (pedido != null) {
            pedidoRepository.delete(pedido)
            true
        } else {
            false
        }
    }

    fun listarTodos() : List<Pedido> {
        return pedidoRepository.findAll()
    }

}