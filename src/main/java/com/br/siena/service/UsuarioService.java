package com.br.siena.service;

import com.br.siena.domain.UsuarioEntity;
import com.br.siena.model.UsuarioDTO;
import com.br.siena.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    public UsuarioEntity recuperar(int id) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        return usuarioDTO.find(id);
    }

    public List<UsuarioEntity> listar() {
        UsuarioRepository repository = new UsuarioRepository();
        repository.listarAtivos();
        return repository.listarAtivos();
    }

    public UsuarioEntity cadastrarUsuario(String noLogin,
                                          String noPessoa,
                                          int idPerfil,
                                          int idUnidade,
                                          String nuCpf,
                                          String noSenhaBase64
    ) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        return usuarioDTO.save(noLogin, noPessoa, idPerfil, idUnidade, nuCpf, noSenhaBase64);
    }
}
