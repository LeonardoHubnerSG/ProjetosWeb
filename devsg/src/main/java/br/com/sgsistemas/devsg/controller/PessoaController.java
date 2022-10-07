package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.controller.dto.PessoaDto;
import br.com.sgsistemas.devsg.controller.form.PessoaAtualizaForm;
import br.com.sgsistemas.devsg.controller.form.PessoaForm;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import lombok.AllArgsConstructor;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/pessoas")
@Data
public class PessoaController {
    private final PessoaRepository pessoaRepository;
    private final EquipeRepository equipeRepository;

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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PessoaDto> atualizar(@PathVariable Integer id, @RequestBody @Valid PessoaAtualizaForm form){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isPresent()){
            Pessoa pessoa = form.atualizar(id, pessoaRepository);
            return ResponseEntity.ok(new PessoaDto(pessoa));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PessoaDto> deletar(@PathVariable Integer id){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isPresent()){
            pessoaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
