package com.br.siena.api;

import com.br.siena.domain.PerfilEntity;
import com.br.siena.service.PerfilService;
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
@RequestMapping(value = "perfil", produces = MediaType.APPLICATION_JSON_VALUE)
public class Perfil {

    private PerfilService service;

    public static void main(String[] args) {
        SpringApplication.run(Perfil.class, args);
    }

    public Perfil() {
        this.service = new PerfilService();
    }

    @GetMapping("/{id}")
    public PerfilEntity fetch(
            @PathVariable int id
    ) {
        PerfilEntity PerfilEntity;
        try {
            PerfilEntity = this.service.recuperar(id);
        } catch (Exception ex) {
            throw new WebApplicationException(ex.getMessage());
        }
        return PerfilEntity;
    }

    @GetMapping
    public List<PerfilEntity> fetchAll() {
        List<PerfilEntity> list;
        try {
            list = this.service.listar();
        } catch (Exception ex) {
            throw new WebApplicationException(ex.getMessage());
        }
        return list;
    }
}