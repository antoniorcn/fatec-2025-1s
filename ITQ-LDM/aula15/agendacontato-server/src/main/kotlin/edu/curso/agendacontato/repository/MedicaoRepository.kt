package edu.curso.agendacontato.repository

import edu.curso.agendacontato.model.Medicao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface MedicaoRepository : JpaRepository<Medicao, Long> {
    @Query("Select m From Medicao m Where m.timestamp >= :inicio and m.timestamp <= :termino ")
    fun findAllByMomento(@Param("inicio") inicio : LocalDateTime,
                         @Param("termino") termino : LocalDateTime) : List<Medicao>
}