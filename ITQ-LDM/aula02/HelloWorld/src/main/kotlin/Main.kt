package org.example

import kotlin.math.roundToInt

fun somar( numero1 : Int, numero2 : Int ) : Int {
    return numero1 + numero2
}

fun testeVariaveis() {
    val resultado = somar(10, 20)
    // resultado = 10
    println("Hello World Kotlin")
    println("O resultado deu $resultado")
    System.out.println("Teste Java")

    var b : String?
    b = "Texto em Koltin"
    b = null
    // if (b != null) {
    println("Tamanho do texto: ${b?.length}")
    // }
}

fun testeSmartCast() {
    var x : Any

    x = 10
    // x = 45.5
    // x = "Texto"

    if (x is String) {
       print("X maiusculo: ${x.uppercase()}")
    }

    if (x is Double) {
        print("X arredondado: ${x.roundToInt()}")
    }
}

// class Pessoa() {
//     var nome : String = ""
//         get() { return field }
//         set( value ) { field = value }
// }

data class Pessoa(var nome : String = "John Hancock",
                  var telefone : String,
                  var email : String){}

operator fun Pessoa.plus( p : Pessoa ) : Pessoa {
    val novoNome = this.nome + " - " + p.nome
    val novoEmail = this.email + " - " + p.email
    val novoTel = this.telefone + " - " + p.telefone
    return Pessoa(novoNome, novoTel, novoEmail)
}

fun testeIgualdade() {
    val p1 = Pessoa(email="joao@teste.com",
        telefone="(11) 1111")
    val p2 = Pessoa(email="joao@teste.com",
        nome="Joao Silva",
        telefone="(11) 1111")
    val p3 = p1
    if (p1 === p2) {
        println("P1 é igual a P2")
    } else {
        println("P1 é diferente de P2")
    }
    if (p1 === p3) {
        println("P1 é a mesma instância de P3")
    } else {
        println("P1 não é a mesma instância que P3")
    }

    println("Pessoa 1: $p1")
    println("Pessoa 2: $p2")
}

fun sobrescritaOperadores() {
    val p1 = Pessoa(nome="Joao Silva",
        telefone="(11) 1111-1111",
        email="joao@teste.com")

    val p2 = Pessoa(nome="Maria Silva",
        telefone="(11) 2222-2222",
        email="maria@teste.com")

    var p3 : Pessoa? = p1 + p2

    println("Pessoa 1: $p1")
    println("Pessoa 2: $p2")
    println("A soma das duas pessoas da: $p3")

    // p3 = null

    println("Valor de P3: ${p3 ?: " <<nulo>> " }")
}

fun Pessoa.ligar() {
    println("Ligando para ${this.nome} no telefone ${this.telefone}")
}

fun testeFuncoesExtensao() {
    val p1 = Pessoa(nome="Joao Silva",
        telefone="(11) 1111-1111",
        email="joao@teste.com")

    val p2 = Pessoa(nome="Maria Silva",
        telefone="(11) 2222-2222",
        email="maria@teste.com")

    p1.ligar()
    p2.ligar()
}

fun main() {
    // testeVariaveis()
    // testeSmartCast()
    // testeIgualdade()
    // sobrescritaOperadores()
    testeFuncoesExtensao()
}