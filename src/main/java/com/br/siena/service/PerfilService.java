package com.br.siena.service;

import com.br.siena.domain.PerfilEntity;
import com.br.siena.model.PerfilDTO;
import com.br.siena.repository.PerfilRepository;

import java.util.List;

public class PerfilService {

    public PerfilEntity recuperar(int id) {
        PerfilDTO perfilDTO = new PerfilDTO();
        return perfilDTO.find(id);
    }

    public List<PerfilEntity> listar() {
        PerfilRepository repository = new PerfilRepository();
        repository.listarAtivos();
        return repository.listarAtivos();
    }
}
