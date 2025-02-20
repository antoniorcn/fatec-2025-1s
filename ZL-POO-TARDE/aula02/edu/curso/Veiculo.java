public class Veiculo { 
    String prefixo;
    String chassi;
    int qtdGiros;
    long kilometragem;
    int ano;

    public void dirigir() { 
        System.out.println("Dirigindo o Onibus");
    }

    public void passarCatraca() { 
        System.out.println("Passando a catraca");
    }

    public void consertarOnibus() { 
        System.out.println("Onibus esta no conserto");
    }
}