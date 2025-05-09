package edu.curso.agendacontato.service

import edu.curso.agendacontato.model.Usuario
import edu.curso.agendacontato.repository.UsuarioRepository
import edu.curso.agendacontato.security.UserDetailsImplementation
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    val usuarioRepository: UsuarioRepository,
    val passwordEncoder : PasswordEncoder
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        println("loadUserByUsername() - acionado")
        if (username != null) {
            println("loadUserByUsername() - Localizando usuario: ($username)")
            println("loadUserByUsername() - usuarioRepository : $usuarioRepository")
            val optUsuario = usuarioRepository.findByEmail( username )
            println("loadUserByUsername() - findByEmail executado")
            if (! optUsuario.isEmpty) {
                println("Lendo dados do usuario")
                val usuario = optUsuario.get()
                println("loadUserByUsername(): Usuario encontrado com a senha: ${usuario.senha}")
                return UserDetailsImplementation( usuario )
            }
        }
        throw UsernameNotFoundException("Usuario não encontrado")
    }

    fun cadastrar( usuario : Usuario) {
        val senhaCrypto = passwordEncoder.encode( usuario.senha )
        val novoUsuario = usuario.copy( senha = senhaCrypto )
        usuarioRepository.save( novoUsuario )
    }
}