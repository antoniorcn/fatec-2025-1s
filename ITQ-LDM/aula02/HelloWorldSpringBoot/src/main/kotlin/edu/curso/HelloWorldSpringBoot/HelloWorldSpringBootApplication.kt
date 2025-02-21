package edu.curso.HelloWorldSpringBoot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloWorldSpringBootApplication

fun main(args: Array<String>) {
	runApplication<HelloWorldSpringBootApplication>(*args)
}
