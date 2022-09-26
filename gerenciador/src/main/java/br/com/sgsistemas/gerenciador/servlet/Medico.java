package br.com.sgsistemas.gerenciador.servlet;

import java.time.LocalDate;

public class Medico {
	private Integer id;
	private String nome;
	private String dataNascimento;
	private String crm;
	
	public Medico(String nome, String dataNascimento, String crm) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.crm = crm;
	}

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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", crm=" + crm + "]";
	}
	
		
	
}
