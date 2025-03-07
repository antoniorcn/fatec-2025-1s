package edu.curso.agendacontato.service
import edu.curso.agendacontato.model.Pedido
import org.springframework.stereotype.Service

@Service
class PedidoService {
    val listaPedidos = mutableListOf<Pedido>()
    var contador : Long = 0

    fun cadastrar(pedido : Pedido) {
        pedido.id = contador ++
        listaPedidos.add( pedido );
    }

    fun listarTodos() : List<Pedido> {
        return listaPedidos;
    }

    fun apagar(id : Long) : Boolean {
        val novaLista = listaPedidos.filter {
                pedido : Pedido ->  pedido.id != id
        }
        val encontrado = novaLista.size != listaPedidos.size
        listaPedidos.clear()
        listaPedidos.addAll( novaLista )
        return encontrado
    }

    fun atualizar(id : Long, novoPedido : Pedido) : Boolean {
        var encontrado = false
        for (i in 0..< listaPedidos.size) {
            val pedido = listaPedidos[i]
            if (pedido.id == id) {
                encontrado = true
                listaPedidos[i] = pedido.copy(
                    id = id,
                    descricao = novoPedido.descricao,
                    data = novoPedido.data,
                    dataEntrega = novoPedido.dataEntrega,
                    status = novoPedido.status,
                    contato = novoPedido.contato
                )
            }
        }
        return encontrado;
    }
}