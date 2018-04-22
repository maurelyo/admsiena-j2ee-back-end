package com.br.siena.service;

import com.br.siena.domain.EspacoEntity;
import com.br.siena.model.EspacoDTO;
import com.br.siena.repository.EspacoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacoService {

    public EspacoEntity recuperar(int id) {
        EspacoDTO espacoDTO = new EspacoDTO();
        return espacoDTO.find(id);
    }

    public List<EspacoEntity> listar() {
        EspacoRepository repository = new EspacoRepository();
        repository.listarAtivos();
        return repository.listarAtivos();
    }
}
