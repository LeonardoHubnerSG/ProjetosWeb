package br.com.sgsistemas.gerenciador.servlet;

import java.time.LocalDate;

public class Empresa {
	private Integer id;
	private String nome; 
	private LocalDate dataAbertura;
	
	public Empresa(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Empresa: " + this.id + " - " + this.nome;
	}
}
