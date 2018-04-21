package com.br.siena.api;

import com.br.siena.domain.EspacoEntity;
import com.br.siena.model.EspacoDTO;
import com.br.siena.repository.EspacoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "espaco", produces = MediaType.APPLICATION_JSON_VALUE)
public class Espaco {

    public static void main(String[] args) {
        SpringApplication.run(Espaco.class, args);
    }

    @GetMapping("/{id}")
    public EspacoEntity fetch(
            @PathVariable int id
    ) {
        EspacoDTO espacoDTO = new EspacoDTO();
        return espacoDTO.find(id);
    }

    @PostMapping
    public void cadastrar(
            @RequestParam("nome") String nome,
            @RequestParam("valor") String valor
    ) {
        // cadastra espaco
    }

    @GetMapping
    public List<EspacoEntity> fetchAll() {
        EspacoRepository repository = new EspacoRepository();
        repository.listarAtivos();
        return repository.listarAtivos();
    }
}