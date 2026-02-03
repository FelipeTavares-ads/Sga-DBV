package br.com.sga.sga_dbv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("DIRETORIA")
public class Diretoria extends Membro {

    private String cargo;

    public Diretoria() {
        super();
    }

    @Override
    public String exibirFicha() {
        return "Cargo na Diretoria: " + this.cargo;
    }

    // Getters e Setters
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
