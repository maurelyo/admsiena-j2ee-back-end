package com.br.siena.model;

import com.br.siena.SienaApplication;
import com.br.siena.domain.EspacoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class EspacoDTO implements EspacoDTOInterface {
    private static EspacoEntity espacoEntity;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EspacoDTO() {
        this.setEntityManagerFactory(SienaApplication.getSession().getEntityManagerFactory());
        this.setEntityManager(this.getEntityManagerFactory().createEntityManager());
    }

    @Override
    public List<EspacoEntity> findAll() {
        return null;
    }

    @Override
    public EspacoEntity find(int idEspaco) {
        return this.getEntityManager().find(EspacoEntity.class, idEspaco);
    }

    public static EspacoEntity getEspacoEntity() {
        return espacoEntity;
    }

    public static void setEspacoEntity(EspacoEntity espacoEntity) {
        EspacoDTO.espacoEntity = espacoEntity;
    }

    private EntityManager getEntityManager() {
        return entityManager;
    }

    private void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    private void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
