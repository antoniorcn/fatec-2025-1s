package edu.curso.noticiario;

public class Estudante implements Assinante {
    private String nome;

    public Estudante(String nome) {
        this.nome = nome;
    }

    @Override
    public void receberNoticia(String noticia) {
        System.out.printf("%s está lendo sobre %s no sofa da Fatec ZL%n",
        this.nome, noticia);
    }
    public String getNome() {
        return nome;
    }
}
 