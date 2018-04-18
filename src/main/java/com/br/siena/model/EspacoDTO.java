package com.br.siena.model;

import com.br.siena.domain.EspacoEntity;

import javax.persistence.EntityManager;


public class EspacoDTO {
    private static EspacoEntity espacoEntity;
    protected EntityManager entityManager;

    public static EspacoEntity getEspacoEntity() {
        return espacoEntity;
    }

    public static void setEspacoEntity(EspacoEntity espacoEntity) {
        EspacoDTO.espacoEntity = espacoEntity;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EspacoEntity getPorId(final int id) {
        return entityManager.find(EspacoEntity.class, id);
    }
}
