package br.com.sga.sga_dbv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@DiscriminatorValue("DESBRAVADOR")
public class Desbravador extends Membro {

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    public Desbravador() {
        super();
    }

    @Override
    public String exibirFicha() {
        String nomeUnidade = (unidade != null) ? unidade.getNome() : "Sem Unidade";
        return "Desbravador da Unidade: " + nomeUnidade;
    }

    // Getters e Setters
    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}
