package com.br.siena.api;

import com.br.siena.domain.UsuarioEntity;
import com.br.siena.service.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class Usuario {

    private UsuarioService service;

    public static void main(String[] args) {
        SpringApplication.run(Usuario.class, args);
    }

    public Usuario() {
        this.service = new UsuarioService();
    }

    @GetMapping("/{id}")
    public UsuarioEntity fetch(
            @PathVariable int id
    ) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        try {
            usuarioEntity = service.recuperar(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return usuarioEntity;
    }

    @GetMapping
    public List<UsuarioEntity> fetchAll() {
        List<UsuarioEntity> list = null;
        try {
            list = service.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @PostMapping
    public UsuarioEntity cadastrar(
            @RequestParam("noLogin") String noLogin,
            @RequestParam("noPessoa") String noPessoa,
            @RequestParam("idPerfil") int idPerfil,
            @RequestParam("idUnidade") int idUnidade,
            @RequestParam("nuCpf") String nuCpf,
            @RequestParam("noSenha") String noSenhaBase64
    ) {
        UsuarioEntity usuario = null;
        try {
            usuario = service.cadastrarUsuario(noLogin, noPessoa, idPerfil, idUnidade, nuCpf, noSenhaBase64);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return usuario;
    }
}