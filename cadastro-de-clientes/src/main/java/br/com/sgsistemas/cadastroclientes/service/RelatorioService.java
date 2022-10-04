package br.com.sgsistemas.cadastroclientes.service;

import br.com.sgsistemas.cadastroclientes.model.ClienteProjection;
import br.com.sgsistemas.cadastroclientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {
    private final ClienteRepository clienteRepository;

    public RelatorioService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void listaClientes(){
        List<ClienteProjection> relatorio = clienteRepository.findClienteProjection();
        relatorio.forEach(cliente -> System.out.println(cliente.getNome() + " " + cliente.getDatanasc()));
    }
}
