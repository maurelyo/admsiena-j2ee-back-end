package com.br.siena.service;

import com.br.siena.SienaApplication;
import com.br.siena.domain.PerfilEntity;
import com.br.siena.domain.PessoaEntity;
import com.br.siena.domain.UnidadeEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SienaApplication.class)
public abstract class AbstractServiceTest {

    private PerfilService perfilService;
    private UsuarioService usuarioService;
    private UnidadeService unidadeService;
    private PessoaService pessoaService;

    @Before
    public void setUp() throws Exception {
        this.setPerfilService(new PerfilService());
        this.setUsuarioService(new UsuarioService());
        this.setPessoaService(new PessoaService());
    }

    @After
    @Rollback
    public void tearDown() throws Exception {
        System.out.println("Rollback");
    }

    public List<PerfilEntity> listarPerfil()
    {
        return this.getPerfilService().listar();
    }

    public List<UnidadeEntity> listarUnidade()
    {
        return this.getUnidadeService().listar();
    }

    public List<PessoaEntity> listarPessoa()
    {
        return this.getPessoaService().listar();
    }

    public String getSenhaBase64Test() {
        return "bm9TZW5oYQ==";
    }

    public String getNoEmailTest() {
        return "aurelyo.web@gmail.com";
    }

    public PerfilService getPerfilService() {
        return perfilService;
    }

    public void setPerfilService(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public UnidadeService getUnidadeService() {
        return unidadeService;
    }

    public void setUnidadeService(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    public PessoaService getPessoaService() {
        return pessoaService;
    }

    public void setPessoaService(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
}