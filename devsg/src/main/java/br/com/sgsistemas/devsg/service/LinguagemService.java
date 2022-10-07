package br.com.sgsistemas.devsg.service;

import br.com.sgsistemas.devsg.controller.dto.LinguagemDto;
import br.com.sgsistemas.devsg.controller.form.LinguagemForm;
import br.com.sgsistemas.devsg.model.Linguagem;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class LinguagemService {
    private final LinguagemRepository linguagemRepository;
    public List<LinguagemDto> listar(String nome) {
        List<Linguagem> linguagens = new ArrayList<>();
        if (nome == null){
            linguagens = linguagemRepository.findAll();
        }else{
            linguagens = linguagemRepository.findByNome(nome);
        }
        return LinguagemDto.converter(linguagens);
    }

    public ResponseEntity<LinguagemDto> cadastrar(LinguagemForm form, UriComponentsBuilder uriBuilder) {
        Linguagem linguagem = form.converter();
        linguagemRepository.save(linguagem);

        URI uri = uriBuilder.path("/linguagens/{id}").buildAndExpand(linguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(new LinguagemDto(linguagem));
    }
}
