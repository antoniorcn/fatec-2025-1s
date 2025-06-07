package edu.curso.agendacontato.repository

import edu.curso.agendacontato.model.Contato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContatoRepository : JpaRepository<Contato, Long> {
}