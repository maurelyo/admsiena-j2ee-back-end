package com.br.siena.service;

import com.br.siena.domain.UnidadeEntity;
import com.br.siena.model.UnidadeDTO;
import com.br.siena.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    public UnidadeEntity recuperar(int id) {
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        return unidadeDTO.find(id);
    }

    public List<UnidadeEntity> listar() {
        UnidadeRepository repository = new UnidadeRepository();
        repository.listarAtivos();
        return repository.listarAtivos();
    }
}
