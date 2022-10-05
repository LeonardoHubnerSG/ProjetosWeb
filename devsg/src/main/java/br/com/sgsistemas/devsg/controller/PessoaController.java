package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.controller.dto.PessoaDto;
import br.com.sgsistemas.devsg.controller.form.PessoaForm;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/pessoas")
@AllArgsConstructor
public class PessoaController {
    private final PessoaRepository pessoaRepository;
    private final EquipeRepository equipeRepository;

    public PessoaController(PessoaRepository pessoaRepository, EquipeRepository equipeRepository) {
		this.pessoaRepository = pessoaRepository;
		this.equipeRepository = equipeRepository;
	}

	@GetMapping
    public List<PessoaDto> listar(String nome){
    	List<Pessoa> pessoas = new ArrayList<>();
        if (nome == null){
            pessoas = pessoaRepository.findAll();
        }else{
            pessoas = pessoaRepository.findByNome(nome);
        }

        return PessoaDto.converter(pessoas);
    }
	
	@PostMapping
	@Transactional
	public ResponseEntity<PessoaDto> cadastrar(@RequestBody @Valid PessoaForm form, UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = form.converter(equipeRepository);
        pessoaRepository.save(pessoa);

        URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
    }
	

}
