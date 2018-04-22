package com.br.siena.api;

import com.br.siena.domain.EspacoEntity;
import com.br.siena.service.EspacoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "espaco", produces = MediaType.APPLICATION_JSON_VALUE)
public class Espaco {

    private EspacoService service;

    public static void main(String[] args) {
        SpringApplication.run(Espaco.class, args);
    }

    public Espaco() {
        this.service = new EspacoService();
    }

    @GetMapping("/{id}")
    public EspacoEntity fetch(
            @PathVariable int id
    ) {
        EspacoEntity espacoEntity = new EspacoEntity();
        try {
            espacoEntity = this.service.recuperar(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return espacoEntity;
    }

    @GetMapping
    public List<EspacoEntity> fetchAll() {
        List<EspacoEntity> list = null;
        try {
            list = this.service.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
}