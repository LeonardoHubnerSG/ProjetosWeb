package br.com.sgsistemas.cadastroclientes;

import br.com.sgsistemas.cadastroclientes.service.ClienteService;
import br.com.sgsistemas.cadastroclientes.service.EnderecoService;
import br.com.sgsistemas.cadastroclientes.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class CadastroDeClientesApplication implements CommandLineRunner {

	private boolean continuar = true;
	private final ClienteService clienteService;
	private final EnderecoService enderecoService;
	private final RelatorioService relatorioService;

	public CadastroDeClientesApplication(ClienteService clienteService, EnderecoService enderecoService, RelatorioService relatorioService) {
		this.clienteService = clienteService;
		this.enderecoService = enderecoService;
		this.relatorioService = relatorioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeClientesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		LocalDate localDate = LocalDate.now();
//		Cliente cliente = new Cliente("Luzia Emilly hubner",localDate,1000.0);
//		clienteService.salvar(cliente);
//
//		Endereco endereco = new Endereco("Rua Jabuticaba",
//				"4335",
//				"Okay Ratinho Rei",
//				"87.113-160",
//				"Paiçandu");
//		enderecoService.salvar(endereco,3);

		//clienteService.adicionaEndereco(1,1);


		relatorioService.listaClientes();



		/*
		Scanner scanner = new Scanner(System.in);

		while(continuar) {
			System.out.println("Cadastro de clientes");
			System.out.println("0 - Sair");
			System.out.println("1 - Gerenciar Clientes");
			System.out.println("2 - Gerenciar Endereços");
			int action = scanner.nextInt();

			switch (action) {
				case 1: {

				}
				case 2: {

				}
				default: {
					continuar = false;
				}
			}
		}
		*/
	}
}
