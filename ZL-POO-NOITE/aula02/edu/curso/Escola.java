public class Escola { 

    public static void main(String[] args) {
        Estudante e1 = new Estudante();
        Estudante e2 = new Estudante();

        e1.nome = "Pedrinho";
        e1.conhece= false;
        e1.extrovertido = true;
        e1.idade = 12;
        e1.inteligente = false;
        e1.turista = true;

        e2.nome = "Zezinho";
        e2.conhece = false;
        e2.extrovertido = true;
        e2.idade = 15;
        e2.inteligente = true;
        e2.turista = false;

        boolean r = e1.conseguePuxarAssunto(e2);
        if (r) { 
            System.out.println("Pedrinho consegue puxar assunto com Zezinho");
        }

    }
}