package com.br.siena.model;

import com.br.siena.SienaApplication;
import com.br.siena.domain.EspacoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class EspacoDTO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EspacoDTO() {
        this.setEntityManagerFactory(SienaApplication.getSession().getEntityManagerFactory());
        this.setEntityManager(this.getEntityManagerFactory().createEntityManager());
    }

    public EspacoEntity find(int idEspaco) {
        return this.getEntityManager().find(EspacoEntity.class, idEspaco);
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
