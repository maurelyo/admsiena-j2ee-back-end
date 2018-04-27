package com.br.siena.service;

import com.br.siena.domain.PessoaEntity;
import com.br.siena.exception.PessoaException;
import com.br.siena.exception.UsuarioException;
import com.br.siena.model.PessoaDTO;
import com.br.siena.repository.PessoaRepository;

import java.util.List;

public class PessoaService {

    /**
     * Recupera um cadastro de pessoa por id
     * @param id Identificador da pessoa
     * @return PessoaEntity
     */
    public PessoaEntity recuperar(int id) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        return pessoaDTO.find(id);
    }

    /**
     * Lista as pessoas com cadastro ativo
     * @return List
     */

    public List<PessoaEntity> listar() {
        PessoaRepository repository = new PessoaRepository();
        repository.listarAtivos();
        return repository.listarAtivos();
    }

    /**
     * Cadastra uma nova pessoa
     * @param noLogin Nome de login para acesso ao sistema
     * @param idPerfil Identificador do perfil de privilegios do usuario
     * @param noSenhaBase64 Senha codificada em base64
     * @param noEmail Endereco de email do usuario
     * @param idPessoa Identificador de referencia para o cadastro de Pessoa
     * @return UsuarioEntity
     * @throws UsuarioException
     * @throws PessoaException
     */
    public PessoaEntity cadastrarPessoa(String noLogin,
                                          int idPerfil,
                                          String noSenhaBase64,
                                          String noEmail,
                                          int idPessoa
    ) throws UsuarioException, PessoaException {
//        String noSenha = this.converterBase64ParaHash(noSenhaBase64);
//
//        // Recupera a entidade Perfil por id
//        PerfilService perfilService = new PerfilService();
//        PerfilEntity perfil = perfilService.recuperar(idPerfil);
//        if (null == perfil) {
//            throw new UsuarioException("Perfil não encontrado.");
//        }
//
//        // Recupera a entidade Pessoa por id
//        PessoaService pessoaService = new PessoaService();
//        PessoaEntity pessoa = pessoaService.recuperar(idPessoa);
//        if (null == pessoa) {
//            throw new PessoaException("Cadastro de pessoa não encontrado.");
//        }
//
//        UsuarioDTO usuarioDTO = new UsuarioDTO();
//        return usuarioDTO.save(noLogin, perfil, noSenha, noEmail, pessoa);
        PessoaEntity pessoa = new PessoaEntity();
        return pessoa;
    }
}
