package br.com.sga.sga_dbv.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "membros")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_membro")
public abstract class Membro extends Pessoa implements AtividadeClube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public abstract String exibirFicha();

    private Boolean ativo;

    @ManyToMany
    @JoinTable(name = "membro_especialidade", joinColumns = @JoinColumn(name = "membro_id"), inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
    private List<Especialidade> especialidades;

    public static String NOME_DO_CLUBE = "Clube de Desbravadores Águias";

    public Membro() {
        super();
    }

    @Override
    public void apresentar() {
        System.out.println("Olá, eu sou " + this.getNome() + ". " + this.exibirFicha());
    }

    @Override
    public String getFuncaoNoClube() {
        return this.exibirFicha();
    }

    public static boolean verificarMaioridade(int idade) {
        return idade >= 18;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }
}
