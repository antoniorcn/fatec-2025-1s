package edu.curso.agendacontato.mapper

import edu.curso.agendacontato.model.Pedido
import edu.curso.agendacontato.model.PedidoDTO
import edu.curso.agendacontato.service.ContatoService
import jakarta.validation.Validation
import org.springframework.stereotype.Component
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor

@Component
class PedidoMapper (val contatoService : ContatoService) {
    private val validator = Validation.buildDefaultValidatorFactory().validator;
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
             val pedido = Pedido(
                id = pedidoDTO.id,
                descricao = pedidoDTO.descricao,
                data = pedidoDTO.data,
                dataEntrega = pedidoDTO.dataEntrega,
                status = pedidoDTO.status,
                contato = contato
            )
            val erros = validator.validate(pedido)
            if (erros.size > 0) null else pedido
        } else null
    }
}