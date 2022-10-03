package br.com.sgsistemas.forum.controller;

import br.com.sgsistemas.forum.dto.TopicoDto;
import br.com.sgsistemas.forum.modelo.Curso;
import br.com.sgsistemas.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(){
        Topico topico = new Topico("Duvida","Duvida com Spring", new Curso("Spring","Programação"));

        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }
}