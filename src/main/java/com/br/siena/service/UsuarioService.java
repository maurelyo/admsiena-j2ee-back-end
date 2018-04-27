package com.br.siena.service;

import com.br.siena.domain.PerfilEntity;
import com.br.siena.domain.PessoaEntity;
import com.br.siena.domain.UsuarioEntity;
import com.br.siena.exception.PessoaException;
import com.br.siena.exception.UsuarioException;
import com.br.siena.model.UsuarioDTO;
import com.br.siena.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UsuarioService {

    /**
     * Recupera um cadastro de usuario por id
     * @param id Identificador do usuario
     * @return UsurioEntity
     */
    public UsuarioEntity recuperar(int id) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        return usuarioDTO.find(id);
    }

    /**
     * Lista os usuarios com cadastro ativo
     * @return List
     */
    public List<UsuarioEntity> listar() {
        UsuarioRepository repository = new UsuarioRepository();
        repository.listarAtivos();
        return repository.listarAtivos();
    }

    /**
     * Cadastra um novo usuario
     * @param idPerfil Identificador do perfil de privilegios do usuario
     * @param noSenhaBase64 Senha codificada em base64
     * @param noEmail Endereco de email do usuario
     * @param idPessoa Identificador de referencia para o cadastro de Pessoa
     * @return UsuarioEntity
     * @throws UsuarioException
     * @throws PessoaException
     */
    public UsuarioEntity cadastrarUsuario(int idPerfil,
                                          String noSenhaBase64,
                                          String noEmail,
                                          int idPessoa
    ) throws UsuarioException, PessoaException {
        String noSenha = this.converterBase64ParaHash(noSenhaBase64);

        // Recupera a entidade Perfil por id
        PerfilService perfilService = new PerfilService();
        PerfilEntity perfil = perfilService.recuperar(idPerfil);
        if (null == perfil) {
            throw new UsuarioException("Perfil não encontrado.");
        }

        // Recupera a entidade Pessoa por id
        PessoaService pessoaService = new PessoaService();
        PessoaEntity pessoa = pessoaService.recuperar(idPessoa);
        if (null == pessoa) {
            throw new PessoaException("Cadastro de pessoa não encontrado.");
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        return usuarioDTO.save(perfil, noSenha, noEmail, pessoa);
    }

    /**
     * Converte uma string em base64 para PasswordEncoder
     * @param noSenhaBase64 String em base64
     * @return noSenha
     */
    private String converterBase64ParaHash(String noSenhaBase64) {
        byte[] noSenhaBytes = Base64.getDecoder().decode(noSenhaBase64);
        String noSenha = new String(noSenhaBytes);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(noSenha);
    }
}
