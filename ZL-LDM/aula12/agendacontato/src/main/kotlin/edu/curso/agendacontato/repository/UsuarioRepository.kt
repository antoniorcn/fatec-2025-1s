package edu.curso.agendacontato.repository

import edu.curso.agendacontato.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {

    @Query("Select u From Usuario u Where u.email = :email ")
    fun findByEmail(@Param("email") email: String): Optional<Usuario>

}