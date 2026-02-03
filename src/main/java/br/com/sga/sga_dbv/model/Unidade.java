package br.com.sga.sga_dbv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidades")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String gritoDeGuerra;
    private String corPadrao;

    public Unidade() {
    }

    public Unidade(Long id, String nome, String gritoDeGuerra, String corPadrao) {
        this.id = id;
        this.nome = nome;
        this.gritoDeGuerra = gritoDeGuerra;
        this.corPadrao = corPadrao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGritoDeGuerra() {
        return gritoDeGuerra;
    }

    public void setGritoDeGuerra(String gritoDeGuerra) {
        this.gritoDeGuerra = gritoDeGuerra;
    }

    public String getCorPadrao() {
        return corPadrao;
    }

    public void setCorPadrao(String corPadrao) {
        this.corPadrao = corPadrao;
    }
}
