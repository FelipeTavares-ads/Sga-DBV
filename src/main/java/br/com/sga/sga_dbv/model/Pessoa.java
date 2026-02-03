package br.com.sga.sga_dbv.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {

    protected String nome;
    protected Integer idade;

    public Pessoa() {
    }

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public abstract void apresentar();
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
