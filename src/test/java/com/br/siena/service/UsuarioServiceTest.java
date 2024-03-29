package com.br.siena.service;

import com.br.siena.domain.PerfilEntity;
import com.br.siena.domain.PessoaEntity;
import com.br.siena.domain.UsuarioEntity;
import com.br.siena.exception.PessoaException;
import com.br.siena.exception.UsuarioException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UsuarioServiceTest extends AbstractServiceTest {


    @Test
    public void listar() {
        List<UsuarioEntity> list = this.getUsuarioService().listar();
        assertNotNull(list);
    }

    @Test
    public void cadastrarUsuario() throws PessoaException, UsuarioException {
        List<PerfilEntity> perfilEntityList = this.listarPerfil();
        PerfilEntity perfilEntity = perfilEntityList.get(1);

        List<PessoaEntity> pessoaEntityList = this.listarPessoa();
        PessoaEntity pessoaEntity = pessoaEntityList.get(1);

        UsuarioEntity usuarioEntity = this.getUsuarioService().cadastrarUsuario(
                perfilEntity.getIdPerfil(),
                getSenhaBase64Test(),
                getNoEmailTest(),
                pessoaEntity.getIdPessoa()
        );

        assertEquals(pessoaEntity, usuarioEntity.getPessoa());
        assertEquals(perfilEntity, usuarioEntity.getPerfil());
    }
}