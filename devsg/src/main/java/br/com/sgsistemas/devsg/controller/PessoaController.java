package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.controller.dto.PessoaDto;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class PessoaController {
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<PessoaDto> listar(String nome){
        if (nome == null){
            List<Pessoa> pessoa = pessoaRepository.findAll();
        }else{
            List<Pessoa> pessoa = pessoaRepository.findByNome(nome);
        }

        return PessoaDto.converter(pessoa);
    }

}
