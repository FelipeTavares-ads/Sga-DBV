package br.com.sga.sga_dbv.dto;

import br.com.sga.sga_dbv.model.Especialidade;

public class EspecialidadeResponseDTO {

    private Long id;
    private String nome;
    private String area;
    private String nivel;

    public EspecialidadeResponseDTO() {
    }

    public EspecialidadeResponseDTO(Especialidade especialidade) {
        this.id = especialidade.getId();
        this.nome = especialidade.getNome();
        this.area = especialidade.getArea();
        this.nivel = especialidade.getNivel();
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
