package br.com.sga.sga_dbv.dto;

import java.util.List;

public class MembroRequestDTO {

    private String nome;

    private Integer idade;

    private Long unidadeId;

    private String cargo;

    private String tipo; // "DESBRAVADOR" ou "DIRETORIA"

    private Boolean ativo;

    private List<Long> especialidadesIds;

    public MembroRequestDTO() {
    }

    public MembroRequestDTO(String nome, Integer idade, Long unidadeId, String cargo, String tipo, Boolean ativo,
            List<Long> especialidadesIds) {
        this.nome = nome;
        this.idade = idade;
        this.unidadeId = unidadeId;
        this.cargo = cargo;
        this.tipo = tipo;
        this.ativo = ativo;
        this.especialidadesIds = especialidadesIds;
    }

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

    public Long getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(Long unidadeId) {
        this.unidadeId = unidadeId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Long> getEspecialidadesIds() {
        return especialidadesIds;
    }

    public void setEspecialidadesIds(List<Long> especialidadesIds) {
        this.especialidadesIds = especialidadesIds;
    }
}
