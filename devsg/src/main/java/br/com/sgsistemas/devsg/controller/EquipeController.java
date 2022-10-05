package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.controller.dto.EquipeDto;
import br.com.sgsistemas.devsg.controller.dto.PessoaDto;
import br.com.sgsistemas.devsg.controller.form.EquipeAtualizaForm;
import br.com.sgsistemas.devsg.controller.form.EquipeForm;
import br.com.sgsistemas.devsg.controller.form.PessoaAtualizaForm;
import br.com.sgsistemas.devsg.controller.form.PessoaForm;
import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipes")
@Data
public class EquipeController {
    private final EquipeRepository equipeRepository;
    private final PessoaRepository pessoaRepository;
    private final LinguagemRepository linguagemRepository;

    @GetMapping
    public List<EquipeDto> listar(String nome){
        List<Equipe> equipes = new ArrayList<>();
        if (nome == null){
            equipes = equipeRepository.findAll();
        }else{
            equipes = equipeRepository.findByNome(nome);
        }
        return EquipeDto.converter(equipes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EquipeDto> cadastrar(@RequestBody @Valid EquipeForm form, UriComponentsBuilder uriBuilder) {
        Equipe equipe = form.converter(linguagemRepository);
        equipeRepository.save(equipe);

        URI uri = uriBuilder.path("/equipes/{id}").buildAndExpand(equipe.getId()).toUri();
        return ResponseEntity.created(uri).body(new EquipeDto(equipe));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EquipeDto> atualizar(@PathVariable Integer id, @RequestBody @Valid EquipeAtualizaForm form){
        Optional<Equipe> equipeOptional = equipeRepository.findById(id);
        if (equipeOptional.isPresent()){
            Equipe equipe = form.atualizar(id, equipeRepository, linguagemRepository);
            return ResponseEntity.ok(new EquipeDto(equipe));
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
