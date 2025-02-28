package edu.curso.agendacontato.controller
import edu.curso.agendacontato.model.Contato
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contato")
class ContatoController {
    val listaContatos = mutableListOf<Contato>()
    var contador : Long = 0

    @GetMapping
    fun listarTodos() : ResponseEntity<List<Contato>> {
        return ResponseEntity.ok(listaContatos)
    }

    @PostMapping
    fun criarContato(@RequestBody contato : Contato) : ResponseEntity<String> {
        contato.id = contador ++
        listaContatos.add( contato )
        return ResponseEntity("Contato criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun removerContato(@PathVariable("id") id : Long) : ResponseEntity<String> {
        val novaLista = listaContatos.filter {
            contato : Contato  ->  contato.id != id
        }

        return if (novaLista.size == listaContatos.size) {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        } else {
            listaContatos.clear()
            listaContatos.addAll(novaLista)
            ResponseEntity("Contato foi removido com sucesso", HttpStatus.OK)
        }
    }

    @DeleteMapping
    fun removerContatoParam(@RequestParam("id") id : Long) : ResponseEntity<String> {
        val novaLista = listaContatos.filter {
                contato : Contato  ->  contato.id != id
        }
        return if (novaLista.size == listaContatos.size) {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        } else {
            listaContatos.clear()
            listaContatos.addAll(novaLista)
            ResponseEntity("Contato foi removido com sucesso", HttpStatus.OK)
        }
    }

    @PutMapping("/{id}")
    fun atualizarContato(@PathVariable id : Long, @RequestBody novoContato : Contato) :
            ResponseEntity<String> {
        var encontrado = false
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
        return if (encontrado)
            ResponseEntity(" Contato atualizado com sucesso", HttpStatus.OK)
        else
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
    }
}