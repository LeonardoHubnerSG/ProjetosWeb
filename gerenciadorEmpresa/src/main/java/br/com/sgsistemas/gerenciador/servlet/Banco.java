package br.com.sgsistemas.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	public static int contador = 0;
	private static List<Empresa> lista = new ArrayList<>();

	static {
		// Banco banco = new Banco();
		Empresa empresa1 = new Empresa(1, "Google");
		Empresa empresa2 = new Empresa(2, "Amazon");
		Banco.adiciona(empresa1);
		Banco.adiciona(empresa2);
	}

	public static void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
		Banco.contador++;
		empresa.setId(Banco.contador);
	}

	public static List<Empresa> getEmpresas() {
		return Banco.lista;
	}
}
