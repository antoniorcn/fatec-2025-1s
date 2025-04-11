package edu.curso.noticiario;

public class Mundo {
    public static void main(String[] args) {
        
        Jornal folha = new Jornal("Folha de São Paulo");
        Jornal choquei = new Jornal("Choquei");

        Estudante e1 = new Estudante("João");
        Estudante e2 = new Estudante("Maria");

        Aposentado a1 = new Aposentado("Gilberto");
        Aposentado a2 = new Aposentado("Camila");

        folha.adicionar( a1 );
        folha.adicionar( e2 );

        choquei.adicionar( e1 );
        choquei.adicionar( a2 );
        folha.adicionar( a2 );

        folha.darNoticia("Baleia Baleia Baleia");
        choquei.darNoticia("Siga atualizado");
    }
    
}
