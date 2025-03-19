package edu.curso.agendacontato.service

import edu.curso.agendacontato.model.Pedido
import org.springframework.stereotype.Service

@Service
class PedidoService {
    val lista = mutableListOf<Pedido> ()

    var contador : Long = 0

    fun adicionar( pedido : Pedido ) {
        contador++  // contador = contador + 1        contador += 1
        pedido.id = contador
        lista.add( pedido )
    }

    fun apagar( id : Long ) : Boolean { 
        println("Lista size: ${lista.size}")
        val novaLista = lista.filter { it -> return@filter it.id != id }
        val encontrado = novaLista.size != lista.size
        if (encontrado){ 
            lista.clear()
            lista.addAll( novaLista )
        }
        return encontrado
    }

    fun listarTodos() : List<Pedido> {
        return lista
    }

}