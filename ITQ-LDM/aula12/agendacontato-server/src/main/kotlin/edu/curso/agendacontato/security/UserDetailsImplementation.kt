package edu.curso.agendacontato.security

import edu.curso.agendacontato.model.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImplementation(private val usuario : Usuario) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val autoridades : List<String> = this.usuario.profile.split(",") // "OWNER, ADMIN, OPERATOR, MANAGER"
        val roles : MutableList<GrantedAuthority> = mutableListOf()
        for (autoridade in autoridades){
            val ga : GrantedAuthority = SimpleGrantedAuthority(autoridade.trim())
            roles.add(ga)
        }
        return roles
    }

    override fun getPassword(): String {
        return this.usuario.senha
    }

    override fun getUsername(): String {
        return this.usuario.email
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}