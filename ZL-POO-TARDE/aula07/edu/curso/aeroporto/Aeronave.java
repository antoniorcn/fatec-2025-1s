package edu.curso.aeroporto;

import java.util.ArrayList;
import java.util.List;

public class Aeronave {
    private String fabricante;
    private String modelo;
    private int numeroAssentos;
    private Piloto piloto;
    private List<Passageiro> passageiros = new ArrayList<>();

    public Aeronave(String fabricante, String modelo, 
                    int numeroAssentos, Piloto piloto) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.numeroAssentos = numeroAssentos;
        this.piloto = piloto;
    }

    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }
    public void setNumeroAssentos(int numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }

    public Piloto getPiloto() {
        return piloto;
    }
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }
    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }   

}
