package edu.curso.agendacontato.controller
import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.service.ContatoService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contato")
class ContatoController( val service : ContatoService  ){

    @GetMapping
    fun listarTodos() : ResponseEntity<List<Contato>> {
        return ResponseEntity.ok(service.listarTodos())
    }

    @PostMapping
    fun criarContato(@Valid @RequestBody contato : Contato) : ResponseEntity<String> {
        service.cadastrar( contato )
        return ResponseEntity("Contato criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_TEACHER')")
    fun removerContato(@PathVariable("id") id : Long) : ResponseEntity<String> {
        return if (!service.apagar(id)) {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity("Contato foi removido com sucesso", HttpStatus.OK)
        }
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_TEACHER')")
    fun removerContatoParam(@RequestParam("id") id : Long) : ResponseEntity<String> {
        return if (!service.apagar(id)) {
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity("Contato foi removido com sucesso", HttpStatus.OK)
        }
    }

    @PutMapping("/{id}")
    fun atualizarContato(@PathVariable id : Long, @Valid @RequestBody novoContato : Contato) :
            ResponseEntity<String> {
        return if (service.atualizar(id, novoContato))
            ResponseEntity("Contato atualizado com sucesso", HttpStatus.OK)
        else
            ResponseEntity("ID não encontrado", HttpStatus.NOT_FOUND)
    }
}