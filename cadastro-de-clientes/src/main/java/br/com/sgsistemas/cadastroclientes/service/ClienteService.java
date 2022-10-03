package br.com.sgsistemas.cadastroclientes.service;

import br.com.sgsistemas.cadastroclientes.model.Cliente;
import br.com.sgsistemas.cadastroclientes.model.Endereco;
import br.com.sgsistemas.cadastroclientes.repository.ClienteRepository;
import br.com.sgsistemas.cadastroclientes.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    public ClienteService(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public void salvar(Cliente cliente){
        clienteRepository.save(cliente);
        System.out.println("Cliente Salvo!");
    }

    public void adicionaEndereco(int idCliente, int idEndereco){
        Optional<Cliente> client = clienteRepository.findById(idCliente);
        Cliente cliente = client.get();

        Optional<Endereco> address = enderecoRepository.findById(idEndereco);
        Endereco endereco = address.get();

        Optional<Endereco> address2 = enderecoRepository.findById(2);
        Endereco endereco2 = address2.get();

        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(address.get());
        enderecos.add(address2.get());



        cliente.setEnderecos(enderecos);

        clienteRepository.save(cliente);

        endereco.setCliente(cliente);
        enderecoRepository.save(endereco);

        System.out.println("Endereço adicionado!");
    }

    public void atualizar(Cliente cliente){
        clienteRepository.save(cliente);
        System.out.println("Cliente Atualizado!");
    }

    public void deletar(Cliente cliente){
        clienteRepository.deleteById(cliente.getId());
        System.out.println("Cliente deletado!");
    }

    public void deletaTodos(){
        clienteRepository.deleteAll();
        System.out.println("Todos os clientes deletados!");
    }

    public void listar(){
        Iterable<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(cliente -> System.out.println(cliente));
    }
}
