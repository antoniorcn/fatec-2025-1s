package org.example;

import java.time.LocalDate;

public record Contato (
    String nome, 
    String telefone, 
    String email,
    LocalDate nascimento ) {
}
