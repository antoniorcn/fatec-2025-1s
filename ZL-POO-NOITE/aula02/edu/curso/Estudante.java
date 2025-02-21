public class Estudante { 

    int idade;
    boolean extrovertido;
    String nome;
    boolean conhece;
    boolean turista;
    boolean inteligente;

    public String conhecer() { 
        if (! conhece) { 
            return "Meu nome é " + nome + " e tenho " + idade; 
        } else { 
            return "Você ja conhece " + nome;
        }
    }

    public boolean conseguePuxarAssunto(Estudante usuario) { 
        int afinidade = 0;
        if ((Math.abs(usuario.idade - idade)) < 20 ) { 
            afinidade++;
        }
        if (conhece) { 
            afinidade++;
        }
        if (turista) { 
            afinidade--;
        }
        if (nome.equals(usuario.nome)) { 
            afinidade += 2;
        }
        if (extrovertido) { 
            afinidade--;
        }
        return afinidade > 3;
    }
}