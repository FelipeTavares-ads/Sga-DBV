package br.com.sga.sga_dbv.dto;

public class UnidadeRequestDTO {

    private String nome;

    private String gritoDeGuerra;
    private String corPadrao;

    public UnidadeRequestDTO() {
    }

    public UnidadeRequestDTO(String nome, String gritoDeGuerra, String corPadrao) {
        this.nome = nome;
        this.gritoDeGuerra = gritoDeGuerra;
        this.corPadrao = corPadrao;
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
