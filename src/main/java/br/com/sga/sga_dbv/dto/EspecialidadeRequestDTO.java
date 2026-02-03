package br.com.sga.sga_dbv.dto;

public class EspecialidadeRequestDTO {

    private String nome;

    private String area;

    private String nivel;

    public EspecialidadeRequestDTO() {
    }

    public EspecialidadeRequestDTO(String nome, String area, String nivel) {
        this.nome = nome;
        this.area = area;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
