package edu.curso.agendacontato.utils

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtilities {

    private val secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256)
    private val expirationTime = 60 * 60 * 1000 // 1 hour

    fun generateToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expirationTime))
            .signWith(secretKey)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getUsernameFromToken(token: String): String {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).body.subject
    }
}