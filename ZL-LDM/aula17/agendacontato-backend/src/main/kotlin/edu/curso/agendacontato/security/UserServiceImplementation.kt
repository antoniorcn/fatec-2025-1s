package edu.curso.agendacontato.security

import edu.curso.agendacontato.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserServiceImplementation(
    val usuarioRepository: UsuarioRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        print("*** loadUserByUsername() - executado")
        if (username != null) {
            val usuarioOpt = usuarioRepository.findByEmail(username)
            if (usuarioOpt.isPresent) {
                return UserDetailImplementation( usuarioOpt.get() )
            }
        }
        throw UsernameNotFoundException("Usuario não encontrado")
    }

}