package edu.curso.aeroporto;

import java.util.ArrayList;
import java.util.List;

public class Aeroporto {

    private List<Passageiro> passageiros = new ArrayList<>();
    private List<Aeronave> aeronaves = new ArrayList<>();
    private List<Piloto> pilotos = new ArrayList<>();
    private String nome;

    public Aeroporto( String nome ) { 
        this.nome = nome;
    }
 
    public static void main(String[] args) { 
        Aeroporto aeroporto = new Aeroporto("Congonhas");
        System.out.println("Aeroporto criado: " + aeroporto.getNome());

        Piloto p1 = new Piloto("Joao da Silva", "111111", 38,
             "BRV1111", 1800, "Gol" );
        Piloto p2 = new Piloto("Maria Silva", "22222", 
                37, "BRV2222", 
                1900, "Azul" );

        aeroporto.getPilotos().add( p1 );
        aeroporto.getPilotos().add( p2 );

        Aeronave a1 = new Aeronave("Boeing", "737", 
                    180, p1);
        Aeronave a2 = new Aeronave("Airbus", "AS320", 
                    150, p2);
        aeroporto.getAeronaves().add( a1 );
        aeroporto.getAeronaves().add( a2 ); 
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }
    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public List<Aeronave> getAeronaves() {
        return aeronaves;
    }
    public void setAeronaves(List<Aeronave> aeronaves) {
        this.aeronaves = aeronaves;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }
    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
