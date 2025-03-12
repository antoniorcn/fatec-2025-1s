package edu.curso.agendacontato.service

import org.springframework.stereotype.Service
import edu.curso.agendacontato.model.Contato

@Service
class ContatoService { 
    val lista = mutableListOf<Contato> ()

    var contador : Long = 0

    fun adicionar( contato : Contato ) { 
        contador++  // contador = contador + 1        contador += 1
        contato.id = contador
        lista.add( contato )
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

    fun listarTodos() : List<Contato> { 
        return lista
    }

}