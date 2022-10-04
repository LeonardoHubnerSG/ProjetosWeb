package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Cargo;
import br.com.sgsistemas.spring.data.model.Funcionario;
import br.com.sgsistemas.spring.data.model.UnidadeTrabalho;
import br.com.sgsistemas.spring.data.repository.CargoRepository;
import br.com.sgsistemas.spring.data.repository.FuncionarioRepository;
import br.com.sgsistemas.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final CargoRepository cargoRepository;
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private Boolean system = true;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository, UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = cargoRepository;
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
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
        scanner = new Scanner(System.in);
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

        scanner = new Scanner(System.in);
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
        scanner = new Scanner(System.in);
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

        //Adicionando cargo
        Cargo cargo = cargo(scanner);
        funcionario.setCargo(cargo);

        //Adicionando uma lista com unidades de trabalho
        List<UnidadeTrabalho> unidades = unidade(scanner);
        funcionario.setUnidadeTrabalhos(unidades);

        funcionarioRepository.save(funcionario);

        System.out.println("Salvo!");
    }

    private List<UnidadeTrabalho> unidade(Scanner scanner){
        scanner = new Scanner(System.in);
        Boolean isTrue = true;
        List<UnidadeTrabalho> unidades = new ArrayList<>();

        while(isTrue){
            System.out.println("Digite o unidadeId (Para sair digite 0)");
            Integer unidadeId = scanner.nextInt();

            if(unidadeId != 0){
                Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(unidadeId);
                unidades.add(unidade.get());
            }else{
                isTrue = false;
            }
        }
        return unidades;
    }

    private Cargo cargo(Scanner scanner){
        scanner = new Scanner(System.in);
        System.out.println("Digite o cargoId");
        int idCargo = scanner.nextInt();
        Optional<Cargo> cargo = cargoRepository.findById(idCargo);
        if(cargo.isPresent()) {
            return cargo.get();
        }
        return null;
    }
}
