package edu.curso.agendacontato.controller
import edu.curso.agendacontato.model.Usuario
import edu.curso.agendacontato.service.UsuarioService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioController(val service : UsuarioService  ){

    @PostMapping
    fun criarUsuario(@Valid @RequestBody usuario : Usuario) : ResponseEntity<String> {
        service.cadastrar( usuario )
        return ResponseEntity("Usuario criado com sucesso", HttpStatus.CREATED)
    }

}