package com.br.siena.model;

import com.br.siena.domain.EspacoEntity;

import java.util.List;

public interface EspacoDTOInterface {
    List<EspacoEntity> findAll();
    EspacoEntity find(int idEspaco);
}
