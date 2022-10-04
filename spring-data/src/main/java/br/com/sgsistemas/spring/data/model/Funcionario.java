package br.com.sgsistemas.spring.data.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private Double salario;
    private LocalDate dataContratacao;

    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "funcionarios_unidades",
            joinColumns = {@JoinColumn(name = "fk_funcionario")},
            inverseJoinColumns = {@JoinColumn(name = "fk_unidade")})
    private List<UnidadeTrabalho> unidadeTrabalhos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setDataContratacao(String dataContratacao) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataContratacao = LocalDate.parse(dataContratacao, fmt);
    }

    public String getDataContratacao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataContratacao = this.dataContratacao.format(formatter);
        return dataContratacao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", cargo=" + cargo +
                ", unidadeTrabalhos=" + unidadeTrabalhos +
                '}';
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<UnidadeTrabalho> getUnidadeTrabalhos() {
        return unidadeTrabalhos;
    }

    public void setUnidadeTrabalhos(List<UnidadeTrabalho> unidadeTrabalhos) {
        this.unidadeTrabalhos = unidadeTrabalhos;
    }

    public void setUnidadeTrabalhos() {
    }
}
