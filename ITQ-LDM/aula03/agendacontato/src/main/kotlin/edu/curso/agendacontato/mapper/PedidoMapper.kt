package edu.curso.agendacontato.mapper

import edu.curso.agendacontato.model.Pedido
import edu.curso.agendacontato.model.PedidoDTO
import edu.curso.agendacontato.service.ContatoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PedidoMapper (@Autowired val contatoService : ContatoService) {
    fun toDTO(pedido : Pedido) : PedidoDTO {
        return PedidoDTO(
            id = pedido.id,
            descricao = pedido.descricao,
            data = pedido.data,
            dataEntrega = pedido.dataEntrega,
            status = pedido.status,
            contatoId = pedido.contato.id
        )
    }

    fun fromDTO(pedidoDTO : PedidoDTO) : Pedido? {
        val contato = contatoService.findById( pedidoDTO.contatoId )
        return if (contato != null) {
             Pedido(
                id = pedidoDTO.id,
                descricao = pedidoDTO.descricao,
                data = pedidoDTO.data,
                dataEntrega = pedidoDTO.dataEntrega,
                status = pedidoDTO.status,
                contato = contato
            )
        } else null
    }
}