package edu.curso.agendacontato.service

import org.springframework.stereotype.Service
import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.repository.ContatoRepository

@Service
class ContatoService( val contatoRepository: ContatoRepository  ) {

    fun adicionar( contato : Contato ) { 
        contatoRepository.save( contato )
    }

    fun procurarPorId( id : Long ) : Contato? {
        val contatoOptional = contatoRepository.findById( id )
        return contatoOptional.orElse( null )
    }

    fun apagar( id : Long ) : Boolean {
        val contato = procurarPorId( id )
        return if (contato != null) {
            contatoRepository.delete(contato)
            true
        } else {
            false
        }
    }

    fun listarTodos() : List<Contato> { 
        return contatoRepository.findAll()
    }
}