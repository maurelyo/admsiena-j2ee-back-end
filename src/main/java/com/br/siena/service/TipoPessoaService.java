package com.br.siena.service;

import com.br.siena.domain.TipoPessoaEntity;
import com.br.siena.model.TipoPessoaDTO;
import com.br.siena.repository.TipoPessoaRepository;

import java.util.List;

public class TipoPessoaService {

    public TipoPessoaEntity recuperar(int id) {
        TipoPessoaDTO TipoPessoaDTO = new TipoPessoaDTO();
        return TipoPessoaDTO.find(id);
    }

    public List<TipoPessoaEntity> listar() {
        TipoPessoaRepository repository = new TipoPessoaRepository();
        repository.listarAtivos();
        return repository.listarAtivos();
    }
}
