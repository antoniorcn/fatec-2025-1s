package edu.curso.springaula2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Springaula2Application


data class Pessoa(val nome: String = "John Hancock", val documento: String = "00.000-0")

data class Aluno(val nome : String = "John Hancock", 
				val ra : String, 
				val pp : Double = 6.0, val pi : Double = 5.0) { 
	operator fun plus(a : Aluno) : Aluno {
		return Aluno(nome = this.nome + " - " + a.nome,
		ra = this.ra + " - " + a.ra,
		pp = (this.pp + a.pp)/2.0,
		pi = (this.pi + a.pi)/2.0,
		)
	}
}

fun Aluno.media() : Double {
	return (this.pp + this.pi) / 2.0
}


fun main(args: Array<String>) {
	// runApplication<Springaula2Application>(*args)

	var textoOuNulo : String? = null

	var texto : String = "Texto"

	// textoOuNulo = "Outro texto"
	// 	textoOuNulo = null

	println("Texto: " + texto.lowercase())
	// if (textoOuNulo != null) {
	// 	print("TextoOuNulo: " + textoOuNulo.lowercase())
	// }

	println("TextoOuNulo: " + textoOuNulo?.lowercase()?:"nulo")

	val a = 10
	println("A: $a")

	val p1 = Pessoa( documento="111.111-1", nome="João Silva")
	val a1 = Aluno(nome="Joao Silva", pp=9.0, ra="1111", pi=8.0)
	val a2 = Aluno(nome="Maria Silva", pp=7.0, ra="1111", pi=6.5)

	print( "Media do aluno 1: ", a1.media())

	val a3 = a1 + a2

	println("Aluno 1: $a1")
	println("Aluno 2: $a2")
	println("Aluno 2: $a3")

}
