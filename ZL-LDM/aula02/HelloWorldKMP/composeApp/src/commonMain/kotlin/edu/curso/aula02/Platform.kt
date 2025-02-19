package edu.curso.aula02

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform