package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Funcionario;
import br.com.sgsistemas.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private final FuncionarioRepository funcionarioRepository;
    boolean system = true;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){

        while(system) {
            System.out.println("Relatorios:");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionario por nome");
            int action = scanner.nextInt();

            switch (action){
                case 1:{
                    buscaFuncionarioNome(scanner);
                    break;
                }
                default:{
                    system = false;
                }
            }

        }
    }

    private void buscaFuncionarioNome(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Qual nome deseja pesquisar?");
        String nome = scanner.next();
        List<Funcionario> funcionarios = funcionarioRepository.findByNomeLike(nome);
        funcionarios.forEach(funcionario -> System.out.println(funcionario));
    }
}
