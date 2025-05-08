package edu.curso.agendacontato.controller

import edu.curso.agendacontato.model.Usuario
import edu.curso.agendacontato.model.UsuarioLogin
import edu.curso.agendacontato.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuario")
class UsuarioController(
    val usuarioService: UsuarioService
) {
    @PostMapping("/registrar")
    fun registrar(@RequestBody usuario : Usuario) : ResponseEntity<String> {
        print("*** registrar() - executado")
        usuarioService.adicionar( usuario )
        return ResponseEntity("Usuario criado com sucesso", HttpStatus.CREATED)
    }

    @PostMapping("/logar")
    fun registrar(@RequestBody usuario : UsuarioLogin) : ResponseEntity<String> {
        print("*** registrar() - executado")
        val user = usuarioService.logar(usuario.email, usuario.senha)
        return if (user != null) {
            ResponseEntity("Usuario logado com sucesso", HttpStatus.OK)
        } else {
            ResponseEntity("Erro ao logar o usuario", HttpStatus.FORBIDDEN)
        }
    }
}