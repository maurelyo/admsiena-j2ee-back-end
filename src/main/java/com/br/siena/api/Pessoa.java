package com.br.siena.api;

import com.br.siena.domain.PessoaEntity;
import com.br.siena.service.PessoaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.WebApplicationException;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
public class Pessoa {

    private PessoaService service;

    public static void main(String[] args) {
        SpringApplication.run(Pessoa.class, args);
    }

    public Pessoa() {
        this.service = new PessoaService();
    }

    @GetMapping("/{id}")
    public PessoaEntity fetch(
            @PathVariable int id
    ) {
        PessoaEntity PessoaEntity = new PessoaEntity();
        try {
            PessoaEntity = service.recuperar(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return PessoaEntity;
    }

    @GetMapping
    public List<PessoaEntity> fetchAll() {
        List<PessoaEntity> list = null;
        try {
            list = service.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @PostMapping
    @ResponseBody
    public PessoaEntity cadastrar(
            @RequestParam("noPessoa") String noPessoa,
            @RequestParam("idUnidade") int idUnidade,
            @RequestParam("idTipoPessoa") int idTipoPessoa,
            @RequestParam("nuCpf") String nuCpf,
            @RequestParam("nuRg") String nuRg,
            @RequestParam("dtNascimento") String dtNascimento
    ) {
        PessoaEntity Pessoa;
        try {
            Pessoa = service.cadastrarPessoa(noPessoa, idUnidade, idTipoPessoa, nuCpf, nuRg, dtNascimento);
        } catch (Exception ex) {
            throw new WebApplicationException(ex.getMessage());
        }
        return Pessoa;
    }
}