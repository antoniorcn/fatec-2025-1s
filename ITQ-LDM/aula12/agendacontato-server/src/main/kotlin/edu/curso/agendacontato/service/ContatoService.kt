package edu.curso.agendacontato.service

import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.repository.ContatoRepository
import org.springframework.stereotype.Service

@Service
class ContatoService( val repository : ContatoRepository ) {

    // val listaContatos = mutableListOf<Contato>()
    // var contador : Long = 0

    fun cadastrar(contato : Contato) {
        // contato.id = contador ++
        // listaContatos.add( contato );
        repository.save( contato )
    }

    fun listarTodos() : List<Contato> {
        return repository.findAll()
        // return listaContatos;
    }

    fun apagar(id : Long) : Boolean {
        /* val novaLista = listaContatos.filter {
                contato : Contato  ->  contato.id != id
        }
        val encontrado = novaLista.size != listaContatos.size
        listaContatos.clear()
        listaContatos.addAll( novaLista )
        return encontrado
         */
        val encontrado = repository.findById(id).isPresent
        repository.deleteById(id)
        return encontrado
    }

    fun atualizar(id : Long, novoContato : Contato) : Boolean {
        /* var encontrado = false
        for (i in 0..< listaContatos.size) {
            val contato = listaContatos[i]
            if (contato.id == id) {
                encontrado = true
                listaContatos[i] = contato.copy(
                    id = id,
                    nome = novoContato.nome,
                    email = novoContato.email,
                    telefone = novoContato.telefone
                )
            }
        }
        return encontrado;
         */
        val encontrado = repository.findById(id).isPresent
        if (encontrado) {
            novoContato.id = id
            repository.save(novoContato)
        }
        return encontrado
    }

    fun findById(id : Long) : Contato? {
        /*for (i in 0..< listaContatos.size) {
            val contato = listaContatos[i]
            if (contato.id == id) {
                return contato
            }
        }
        return null
         */
        return repository.findById(id).orElse(null)
    }
}