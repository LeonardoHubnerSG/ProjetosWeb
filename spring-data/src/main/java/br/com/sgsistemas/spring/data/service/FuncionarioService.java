package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Funcionario;
import br.com.sgsistemas.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private Boolean system = true;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {

        int action;

        while (system) {
            scanner = new Scanner(System.in);

            System.out.println("Qual ação deseja realizar com os funcionarios?");
            System.out.println("0 - Sair ");
            System.out.println("1 - Inserir ");
            System.out.println("2 - Atualizar ");
            System.out.println("3 - Visualizar ");
            System.out.println("4 - Deletar por id ");
            System.out.println("5 - Deletar todos ");

            //scanner = new Scanner(System.in);
            action = scanner.nextInt();
            switch (action) {
                case 0:{
                    system = false;
                    break;
                }
                case 1: {
                    salvar(scanner);
                    break;
                }
                case 2: {
                    atualizar(scanner);
                    break;
                }case 3: {
                    visualizar();
                    break;
                }
                case 4: {
                    deletarPorId(scanner);
                    break;
                }case 5: {
                    deletarTodos();
                    break;
                }
                default:{

                }
            }
        }

    }

    private void deletarTodos() {
        funcionarioRepository.deleteAll();
        System.out.println("Todos os funcionarios deletados!");
    }

    private void deletarPorId(Scanner scanner) {
        System.out.println("Id do funcionario a ser deletado:");
        int id = scanner.nextInt();
        funcionarioRepository.deleteById(id);
        System.out.println("Funcionario de id " + id + " deletado!");
    }

    private void visualizar() {
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(funcionario -> System.out.println(funcionario));
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Id do funcionario a ser alterado:");
        int id = scanner.nextInt();

        System.out.println("Nome:");
        String nome = scanner.next();
        System.out.println("CPF:");
        String cpf = scanner.next();
        System.out.println("Data de contratacao:");
        String dataContratacao = scanner.next();
        System.out.println("Salario:");
        Double salario = scanner.nextDouble();

        System.out.println("alo");

        Funcionario funcionario = new Funcionario();
//      cargoRepository.findById(id).get();
        funcionario.setId(id);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(dataContratacao);

        funcionarioRepository.save(funcionario);

        System.out.println("Alterado!");
    }

    private void salvar(Scanner scanner) {
        System.out.println("Informe os dados do novo funcionario:");
        System.out.println("Nome:");
        String nome = scanner.next();
        System.out.println("CPF:");
        String cpf = scanner.next();
        System.out.println("Salario:");
        Double salario = scanner.nextDouble();
        System.out.println("Data de contratacao:");
        String dataContratacao = scanner.next();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(dataContratacao);

        funcionarioRepository.save(funcionario);

        System.out.println("Salvo!");
    }
}
