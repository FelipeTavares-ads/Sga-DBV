package br.com.sga.sga_dbv.dto;

import br.com.sga.sga_dbv.model.Unidade;

public class UnidadeResponseDTO {

    private Long id;
    private String nome;
    private String gritoDeGuerra;
    private String corPadrao;

    public UnidadeResponseDTO() {
    }

    public UnidadeResponseDTO(Unidade unidade) {
        this.id = unidade.getId();
        this.nome = unidade.getNome();
        this.gritoDeGuerra = unidade.getGritoDeGuerra();
        this.corPadrao = unidade.getCorPadrao();
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
