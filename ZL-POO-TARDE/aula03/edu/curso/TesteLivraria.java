package edu.curso;

import java.time.LocalDate;

public class TesteLivraria {

    public static void main(String[] args) {
        Autor a1 = new Autor( "Martin Fowler", 
            LocalDate.of(1963, 12, 18), 
            "Engenharia de Software");

        Autor a2 = new Autor( "Barbara Liskov", 
            LocalDate.of(1939, 11, 7), 
            "Engenharia de Software");

        
        Livro l1 = new Livro("Program Development in Java: Abstraction, Specification, and Object-Oriented Design",
        2000, a2, "Addison Wesley");

        Livro l2 = new Livro ("Patterns of Enterprise Application Architecture",
        2012, a1, "Addison Wesley");

        
        Autor b1 = l1.autor;


    }
    
}
