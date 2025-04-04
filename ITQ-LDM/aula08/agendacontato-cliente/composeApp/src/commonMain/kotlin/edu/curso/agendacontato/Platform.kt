package edu.curso.agendacontato

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform