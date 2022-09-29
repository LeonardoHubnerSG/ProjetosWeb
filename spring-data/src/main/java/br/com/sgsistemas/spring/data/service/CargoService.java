package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Cargo;
import br.com.sgsistemas.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CargoService {
    private final CargoRepository cargoRepository;
    private Boolean system = true;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner) {

        int action;

        while (system) {

            System.out.println("Qual ação deseja realizar com os cargos?");
            System.out.println("0 - Sair ");
            System.out.println("1 - Inserir ");
            System.out.println("2 - Atualizar ");
            System.out.println("3 - Visualizar ");
            System.out.println("4 - Deletar por id ");
            System.out.println("5 - Deletar todos os cargos ");

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
        cargoRepository.deleteAll();
        System.out.println("Todos os cargos deletados!");
    }

    private void deletarPorId(Scanner scanner) {
        System.out.println("Id do cargo a ser deletado:");
        int id = scanner.nextInt();
        cargoRepository.deleteById(id);
        System.out.println("Cargo de id " + id + " deletado!");
    }

    private void visualizar() {
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo));
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Id do cargo a ser alterado:");
        int id = scanner.nextInt();
        System.out.println("Descricao do cargo:");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
//      cargoRepository.findById(id).get();
        cargo.setId(id);
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);

        System.out.println("Alterado!");
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descricao do cargo:");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);

        System.out.println("Salvo!");
    }
}
