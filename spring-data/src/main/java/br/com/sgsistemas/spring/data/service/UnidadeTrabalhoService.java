package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.UnidadeTrabalho;
import br.com.sgsistemas.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UnidadeTrabalhoService {
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private Boolean system = true;

    public UnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public void inicial(Scanner scanner) {

        int action;

        while (system) {

            System.out.println("Qual ação deseja realizar com as unidades de trabalho?");
            System.out.println("0 - Sair ");
            System.out.println("1 - Inserir ");
            System.out.println("2 - Atualizar ");
            System.out.println("3 - Visualizar ");
            System.out.println("4 - Deletar por id ");
            System.out.println("5 - Deletar todas");

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
        unidadeTrabalhoRepository.deleteAll();
        System.out.println("Todos as unidades foram deletadas!");
    }

    private void deletarPorId(Scanner scanner) {
        System.out.println("Id da unidade a ser deletada:");
        int id = scanner.nextInt();
        unidadeTrabalhoRepository.deleteById(id);
        System.out.println("Unidade de trabalho de id " + id + " deletada!");
    }

    private void visualizar() {
        Iterable<UnidadeTrabalho> unidadeTrabalhos = unidadeTrabalhoRepository.findAll();
        unidadeTrabalhos.forEach(unidade -> System.out.println(unidade));
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Id da unidade de trabalho a ser alterada:");
        int id = scanner.nextInt();
        System.out.println("Descricao da unidade de trabalho:");
        String descricao = scanner.next();
        System.out.println("Endereco da unidade de trabalho:");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
//      unidadeTrabalhoRepository.findById(id).get();
        unidadeTrabalho.setId(id);
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);

        System.out.println("Alterado!");
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descricao da unidade de trabalho:");
        String descricao = scanner.next();
        System.out.println("Endereco da unidade de trabalho:");
        String endereco = scanner.next();


        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);

        System.out.println("Salvo!");
    }
}
