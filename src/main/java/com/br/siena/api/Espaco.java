package com.br.siena.api;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class Espaco {
    @RequestMapping("/espaco")
    Collection<String> listarEspaco () {
        Collection<String> lista = new ArrayList<>();
        lista.add("Teste");
        return lista;
    }

    public static void main(String[] args) {
        SpringApplication.run(Espaco.class, args);
    }
}