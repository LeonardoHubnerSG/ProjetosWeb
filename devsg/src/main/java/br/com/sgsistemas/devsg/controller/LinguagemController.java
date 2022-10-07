package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.controller.dto.LinguagemDto;
import br.com.sgsistemas.devsg.controller.form.LinguagemAtualizaForm;
import br.com.sgsistemas.devsg.controller.form.LinguagemForm;
import br.com.sgsistemas.devsg.model.Linguagem;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
import br.com.sgsistemas.devsg.service.LinguagemService;
import com.sun.jndi.toolkit.url.Uri;
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
    private final LinguagemService linguagemService;

    private final LinguagemRepository linguagemRepository;

    @GetMapping
    public List<LinguagemDto> listar(String nome){
        return linguagemService.listar(nome);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LinguagemDto> cadastrar(@RequestBody @Valid LinguagemForm form, UriComponentsBuilder uriBuilder) {
        return linguagemService.cadastrar(form, uriBuilder);
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
