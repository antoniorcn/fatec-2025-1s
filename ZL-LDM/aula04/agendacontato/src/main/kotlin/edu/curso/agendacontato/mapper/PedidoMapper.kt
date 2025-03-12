package edu.curso.agendacontato.mapper

import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.model.Pedido
import edu.curso.agendacontato.model.PedidoDTO
import edu.curso.agendacontato.model.PedidoDTOView
import edu.curso.agendacontato.service.ContatoService
import org.springframework.stereotype.Component

@Component
class PedidoMapper(
    val contatoService : ContatoService
) {
    fun toDTO( pedido : Pedido) : PedidoDTOView {
        return PedidoDTOView (
            id = pedido.id,
            descricao = pedido.descricao,
            dataPedido = pedido.dataPedido,
            dataEntrega = pedido.dataEntrega,
            status = pedido.status,
            contato = pedido.contato
        )
    }

    fun fromDTO( pedidoDTO : PedidoDTO) : Pedido? {
        val contato = contatoService.procurarPorId( pedidoDTO.contatoId )
        if (contato != null) {
            return Pedido(
                id = pedidoDTO.id,
                descricao = pedidoDTO.descricao,
                dataPedido = pedidoDTO.dataPedido,
                dataEntrega = pedidoDTO.dataEntrega,
                status = pedidoDTO.status,
                contato = contato
            )
        } else {
            return null
        }
    }
}