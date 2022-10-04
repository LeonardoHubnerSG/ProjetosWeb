package br.com.sgsistemas.spring.data;

import br.com.sgsistemas.spring.data.service.CargoService;
import br.com.sgsistemas.spring.data.service.FuncionarioService;
import br.com.sgsistemas.spring.data.service.RelatoriosService;
import br.com.sgsistemas.spring.data.service.UnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private CargoService cargoService;
	private FuncionarioService funcionarioService;
	private UnidadeTrabalhoService unidadeTrabalhoService;
	private RelatoriosService relatoriosService;

	private Boolean system = true;

	public SpringDataApplication(CargoService cargoService,
								 FuncionarioService funcionarioService,
								 UnidadeTrabalhoService unidadeTrabalhoService, RelatoriosService relatoriosService){
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		int action;

		while(system){
			System.out.println("Qual acao voce quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Gerenciar Cargos");
			System.out.println("2 - Gerenciar Funcionarios");
			System.out.println("3 - Gerenciar Unidades de Trabalho");
			System.out.println("4 - Relatórios");

			action = scanner.nextInt();

			switch(action){
				case 1:
					cargoService.inicial(scanner);
					break;
				case 2:
					funcionarioService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatoriosService.inicial(scanner);
					break;
				default:
					system = false;
			}
		}
	}
}
