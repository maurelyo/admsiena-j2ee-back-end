package com.br.siena.service;

import com.br.siena.domain.UsuarioEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UsuarioServiceTest {

    private UsuarioService service;

    @Before
    public void setUp() throws Exception {

        this.service = new UsuarioService();
    }

    @Test
    public void recuperar() {
    }

    @Test
    public void listar() {
        List<UsuarioEntity> list = null;
        list = service.listar();
        assertNotNull(list);
    }

    @Test
    public void cadastrarUsuario() {
    }
}