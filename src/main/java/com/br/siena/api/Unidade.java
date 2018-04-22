package com.br.siena.api;

import com.br.siena.domain.UnidadeEntity;
import com.br.siena.service.UnidadeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "unidade", produces = MediaType.APPLICATION_JSON_VALUE)
public class Unidade {

    private UnidadeService service;

    public static void main(String[] args) {
        SpringApplication.run(Unidade.class, args);
    }

    public Unidade() {
        this.service = new UnidadeService();
    }

    @GetMapping("/{id}")
    public UnidadeEntity fetch(
            @PathVariable int id
    ) {
        UnidadeEntity unidadeEntity = new UnidadeEntity();
        try {
            unidadeEntity = this.service.recuperar(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return unidadeEntity;
    }

    @GetMapping
    public List<UnidadeEntity> fetchAll() {
        List<UnidadeEntity> list = null;
        try {
            list = this.service.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @PostMapping
    public void cadastrar(
            @RequestParam("sgBloco") String sgBloco,
            @RequestParam("nuApartamento") int nuApartamento,
            @RequestParam("nuTamanho") float nuTamanho
            ) {
        // cadastra unidade
    }
}