package edu.curso.agendacontato.repository

import edu.curso.agendacontato.model.Pedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PedidoRepository : JpaRepository<Pedido, Long>{
}