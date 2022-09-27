package br.com.sgsistemas.gerenciador.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medico {
	private Integer id;
	private String nome;
	private LocalDate dataNascimento;
	private String crm;
	
	public Medico(String nome, LocalDate dataNascimento, String crm) {
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataNascimento = this.dataNascimento.format(formatter);
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataNascimento = LocalDate.parse(dataNascimento, fmt);
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
