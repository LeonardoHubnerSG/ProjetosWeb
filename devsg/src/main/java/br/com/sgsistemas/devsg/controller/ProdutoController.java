package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.controller.dto.ProdutoDto;
import br.com.sgsistemas.devsg.controller.form.ProdutoAtualizaForm;
import br.com.sgsistemas.devsg.controller.form.ProdutoForm;
import br.com.sgsistemas.devsg.model.Produto;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.ProdutoRepository;
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
@RequestMapping("/produtos")
@Data
public class ProdutoController {
    private final EquipeRepository equipeRepository;
    private final ProdutoRepository produtoRepository;

    @GetMapping
    public List<ProdutoDto> listar(String nome){
        List<Produto> produtos = new ArrayList<>();
        if (nome == null){
            produtos = produtoRepository.findAll();
        }else{
            produtos = produtoRepository.findByNome(nome);
        }
        return ProdutoDto.converter(produtos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
        Produto produto = form.converter(equipeRepository);
        produtoRepository.save(produto);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDto(produto));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDto> atualizar(@PathVariable Integer id, @RequestBody @Valid ProdutoAtualizaForm form){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()){
            Produto produto = form.atualizar(id, produtoRepository, equipeRepository);
            return ResponseEntity.ok(new ProdutoDto(produto));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDto> deletar(@PathVariable Integer id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()){
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}