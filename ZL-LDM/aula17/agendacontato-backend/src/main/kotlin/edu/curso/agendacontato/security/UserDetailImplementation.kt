package edu.curso.agendacontato.security

import edu.curso.agendacontato.model.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailImplementation( val user : Usuario) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        print("*** getAuthorities() - executado")
        val perfis = user.perfilAcesso.split(",")
        val perfisAuthority : MutableList<GrantedAuthority> = mutableListOf()
        for (perfil in perfis) {
            perfisAuthority.add(SimpleGrantedAuthority( perfil.trim() ))
        }
        // Nomes dos perfis separados por virgula "GERENTE, OPERADOR, ADMIN, EXTRATO_RELATORIO"
        return perfisAuthority
    }

    override fun getPassword(): String {
        return user.senha
    }

    override fun getUsername(): String {
        return user.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}