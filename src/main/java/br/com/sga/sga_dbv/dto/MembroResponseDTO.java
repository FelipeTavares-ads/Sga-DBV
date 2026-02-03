package br.com.sga.sga_dbv.dto;

import br.com.sga.sga_dbv.model.Membro;
import br.com.sga.sga_dbv.model.Desbravador;
import br.com.sga.sga_dbv.model.Diretoria;
import java.util.List;
import java.util.stream.Collectors;

public class MembroResponseDTO {

    private Long id;
    private String nome;
    private Integer idade;
    private String unidade;
    private String cargo;
    private Boolean ativo;
    private List<String> especialidades;

    public MembroResponseDTO() {
    }

    public MembroResponseDTO(Membro membro) {
        this.id = membro.getId();
        this.nome = membro.getNome();
        this.idade = membro.getIdade();
        this.ativo = membro.getAtivo();

        if (membro instanceof Desbravador) {
            Desbravador d = (Desbravador) membro;
            if (d.getUnidade() != null) {
                this.unidade = d.getUnidade().getNome();
            }
        } else if (membro instanceof Diretoria) {
            Diretoria d = (Diretoria) membro;
            this.cargo = d.getCargo();
        }

        if (membro.getEspecialidades() != null) {
            this.especialidades = membro.getEspecialidades().stream()
                    .map(e -> e.getNome())
                    .collect(Collectors.toList());
        }
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<String> especialidades) {
        this.especialidades = especialidades;
    }
}
