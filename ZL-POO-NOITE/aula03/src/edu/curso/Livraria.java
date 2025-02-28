package src.edu.curso;

import java.time.LocalDate;

public class Livraria {

    public static void main(String[] args) {
        Autor a1 = new Autor("Robert Cecil Martin", 
        "Ciencia da Computacao", 
        LocalDate.of(1952, 12, 5));

        Autor a2 = new Autor("George R. R. Martin", "Literatura",
        LocalDate.of(1948, 9, 20) );

        Autor a3 = new Autor("Frank Herbert", "Literatura",
        LocalDate.of(1920, 10, 8));

        Autor a4 = new Autor("Uncle Bob", "Ciencia da Computacao", 
        LocalDate.of(1952, 12, 5));

        Livro l1 = new Livro("As cronicas de gelo e fogo", 
        1996, "Bantam", a2);

        Livro l2 = new Livro("Duna", 1965, "Chilton Books", a3);

        Livro l3 = new Livro("Clean Code", 1999, "Alta Books", a1);

        l1.vitrine();
        l2.vitrine();
        l3.vitrine();

        l3.autor = a4;

        l3.vitrine();
    }
    
}
