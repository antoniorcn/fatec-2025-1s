package edu.curso.agendacontato.service

import edu.curso.agendacontato.model.Usuario
import edu.curso.agendacontato.repository.UsuarioRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService( val usuarioRepository: UsuarioRepository,
    val passwordEncoder: PasswordEncoder) {

    fun adicionar( usuario : Usuario) {
        print("*** adicionar() - executado")
        val senhaCodificada = BCryptPasswordEncoder().encode( usuario.senha )
        val usuarioCodificado = usuario.copy(senha=senhaCodificada)
        usuarioRepository.save( usuarioCodificado )
    }

    fun logar(email: String, senha: String) : Usuario? {
        println("*** logar() - executado")
        val user = usuarioRepository.findByEmail(email)
        if (user.isPresent) {
            val usuario = user.get()
            println("*** Usuairo localizado: (${usuario.id}) ${usuario.nome}")
            if (passwordEncoder.matches(senha, usuario.senha)) {
                println("***Autenticado ***")
                return usuario
            }
        }
        return null
    }

}