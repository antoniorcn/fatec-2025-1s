package edu.curso.aeroporto;

public class Piloto extends Pessoa {
    private String numeroBreve;
    private int horasVoo;
    private String companhiaAerea;

    public Piloto(String nome, String documento, 
                    int idade, String numeroBreve, 
                    int horasVoo, String companhiaAerea) {
        super(nome, documento, idade);
        this.numeroBreve = numeroBreve;
        this.horasVoo = horasVoo;
        this.companhiaAerea = companhiaAerea;
    }

    public String getNumeroBreve() {
        return numeroBreve;
    }
    public void setNumeroBreve(String numeroBreve) {
        this.numeroBreve = numeroBreve;
    }

    public int getHorasVoo() {
        return horasVoo;
    }
    public void setHorasVoo(int horasVoo) {
        this.horasVoo = horasVoo;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }
    public void setCompanhiaAerea(String companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }    
}
