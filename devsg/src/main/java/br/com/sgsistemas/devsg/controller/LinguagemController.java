package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.controller.dto.LinguagemDto;
import br.com.sgsistemas.devsg.controller.form.LinguagemAtualizaForm;
import br.com.sgsistemas.devsg.controller.form.LinguagemForm;
import br.com.sgsistemas.devsg.model.Linguagem;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
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
@RequestMapping("/linguagens")
@Data
public class LinguagemController {
    private final LinguagemRepository linguagemRepository;

    @GetMapping
    public List<LinguagemDto> listar(String nome){
        List<Linguagem> linguagens = new ArrayList<>();
        if (nome == null){
            linguagens = linguagemRepository.findAll();
        }else{
            linguagens = linguagemRepository.findByNome(nome);
        }
        return LinguagemDto.converter(linguagens);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LinguagemDto> cadastrar(@RequestBody @Valid LinguagemForm form, UriComponentsBuilder uriBuilder) {
        Linguagem linguagem = form.converter();
        linguagemRepository.save(linguagem);

        URI uri = uriBuilder.path("/linguagens/{id}").buildAndExpand(linguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(new LinguagemDto(linguagem));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<LinguagemDto> atualizar(@PathVariable Integer id, @RequestBody @Valid LinguagemAtualizaForm form){
        Optional<Linguagem> linguagemOptional = linguagemRepository.findById(id);
        if (linguagemOptional.isPresent()){
            Linguagem linguagem = form.atualizar(id, linguagemRepository);
            return ResponseEntity.ok(new LinguagemDto(linguagem));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<LinguagemDto> deletar(@PathVariable Integer id){
        Optional<Linguagem> linguagemOptional = linguagemRepository.findById(id);
        if (linguagemOptional.isPresent()){
            linguagemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
