package com.br.siena.service;

import com.br.siena.domain.PessoaEntity;
import com.br.siena.model.PessoaDTO;
import com.br.siena.repository.PessoaRepository;

import java.util.List;

public class PessoaService {

    public PessoaEntity recuperar(int id) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        return pessoaDTO.find(id);
    }

    public List<PessoaEntity> listar() {
        PessoaRepository repository = new PessoaRepository();
        repository.listarAtivos();
        return repository.listarAtivos();
    }
}
