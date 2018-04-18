package com.br.siena.api;

import com.br.siena.domain.EspacoEntity;
import com.br.siena.model.EspacoDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Espaco {
    @RequestMapping("/espaco")
    EspacoEntity listarEspaco () {

        EspacoDTO espaco = new EspacoDTO();
        EspacoEntity esp = espaco.getPorId(2);
        return esp;
    }

    public static void main(String[] args) {
        SpringApplication.run(Espaco.class, args);
    }
}