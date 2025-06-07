package edu.curso.agendacontato.controller
import edu.curso.agendacontato.model.Usuario
import edu.curso.agendacontato.service.UsuarioService
import edu.curso.agendacontato.utils.JwtUtilities
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioController(
    private val service : UsuarioService,
    private val jwt : JwtUtilities
){

    @PostMapping("/signup")
    fun registrar(@Valid @RequestBody usuario : Usuario) : ResponseEntity<String> {
        service.cadastrar( usuario )
        return ResponseEntity("Usuario criado com sucesso", HttpStatus.CREATED)
    }

    @PostMapping("/signin")
    fun logar(@Valid @RequestBody usuario : Usuario) : ResponseEntity<String> {
        val user = service.loadUserByUsername( usuario.email )
        val resultado = service.compararSenhas(usuario.senha, user.password)
//        usuario.senha // Senha que veio do login
//        user.password // Senha que está no banco de dados
        if (resultado) {
            val token = jwt.generateToken(user.username)
            return ResponseEntity(token, HttpStatus.OK)
        }
        return ResponseEntity("Usuario ou senha invalidos", HttpStatus.FORBIDDEN)
    }

}