package com.br.siena.api;

import com.br.siena.domain.UsuarioEntity;
import com.br.siena.service.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.WebApplicationException;
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
    @ResponseBody
    public UsuarioEntity cadastrar(
            @RequestParam("idPerfil") int idPerfil,
            @RequestParam("noSenha") String noSenhaBase64,
            @RequestParam("noEmail") String noEmail,
            @RequestParam("idPessoa") int idPessoa
    ) {
        UsuarioEntity usuario;
        try {
            usuario = service.cadastrarUsuario(idPerfil, noSenhaBase64, noEmail, idPessoa);
        } catch (Exception ex) {
            throw new WebApplicationException(ex.getMessage());
        }
        return usuario;
    }
}