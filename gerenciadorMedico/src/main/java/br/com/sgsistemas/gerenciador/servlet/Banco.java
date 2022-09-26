package br.com.sgsistemas.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private static int contador = 0;
	private static List<Medico> medicos = new ArrayList<>();
	
	static {
		Medico medico1 = new Medico("Leonardo Hubner", "22/04/1995", "123456");
		Medico medico2 = new Medico("Luzia Rodrigues Hubner", "11/12/1969", "6543210789");
		Banco.adicionaMedico(medico1);
		Banco.adicionaMedico(medico2);
	}
	
	public static void adicionaMedico(Medico medico) {
		Banco.contador++;
		Banco.medicos.add(medico);
		medico.setId(Banco.contador);
	}
	
	public static List<Medico> getMedicos(){
		return Banco.medicos;	
	}
	
	public static Medico buscaMedicoPeloId(Integer id) {
		for (Medico medico : Banco.getMedicos()) {
			if(medico.getId() == id) {
				return medico;
			}
		}
		return null;
	}

	public static void removeMedicoPeloId(Integer id) {
		Medico medico = Banco.buscaMedicoPeloId(id);
		Banco.getMedicos().remove(medico);
	}

	public static List<Medico> getMedicosPorNome(String nome) {
		if(nome.isEmpty()) {
			return Banco.getMedicos();
		}
		
		String nomeFiltro = nome.toLowerCase();
		List<Medico> lista = new ArrayList<>();
		
		for (Medico medico : Banco.getMedicos()) {
			
			String nomeMedico = medico.getNome().toLowerCase();
			
			if(nomeMedico.indexOf(nomeFiltro)>=0) {
				lista.add(medico);
			}
		}
		return lista;
	}
}
