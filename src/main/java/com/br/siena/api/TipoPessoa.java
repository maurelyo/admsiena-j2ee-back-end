package com.br.siena.api;

import com.br.siena.domain.TipoPessoaEntity;
import com.br.siena.service.TipoPessoaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.WebApplicationException;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "tipo-pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoPessoa {

    private TipoPessoaService service;

    public static void main(String[] args) {
        SpringApplication.run(TipoPessoa.class, args);
    }

    public TipoPessoa() {
        this.service = new TipoPessoaService();
    }

    @GetMapping("/{id}")
    public TipoPessoaEntity fetch(
            @PathVariable int id
    ) {
        TipoPessoaEntity TipoPessoaEntity;
        try {
            TipoPessoaEntity = this.service.recuperar(id);
        } catch (Exception ex) {
            throw new WebApplicationException(ex.getMessage());
        }
        return TipoPessoaEntity;
    }

    @GetMapping
    public List<TipoPessoaEntity> fetchAll() {
        List<TipoPessoaEntity> list;
        try {
            list = this.service.listar();
        } catch (Exception ex) {
            throw new WebApplicationException(ex.getMessage());
        }
        return list;
    }
}