package br.com.sgsistemas.cadastroclientes.service;

import br.com.sgsistemas.cadastroclientes.model.Cliente;
import br.com.sgsistemas.cadastroclientes.model.Endereco;
import br.com.sgsistemas.cadastroclientes.repository.ClienteRepository;
import br.com.sgsistemas.cadastroclientes.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;


    public EnderecoService(EnderecoRepository enderecoRepository, ClienteRepository clienteRepository) {
        this.enderecoRepository = enderecoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void salvar(Endereco endereco, int idCliente){
        Optional<Cliente> client = clienteRepository.findById(idCliente);
        Cliente cliente = client.get();
        endereco.setCliente(cliente);

        enderecoRepository.save(endereco);
        System.out.println("Endereço Salvo!");
    }

    public void atualizar(Endereco endereco){
        enderecoRepository.save(endereco);
        System.out.println("Endereço Atualizado!");
    }

    public void deletar(Endereco endereco){
        enderecoRepository.deleteById(endereco.getId());
        System.out.println("Endereço deletado!");
    }

    public void deletaTodos(){
        enderecoRepository.deleteAll();
        System.out.println("Todos os enderecos deletados!");
    }

    public void listar(){
        Iterable<Endereco> enderecos = enderecoRepository.findAll();
        enderecos.forEach(endereco -> System.out.println(endereco));
    }
}
