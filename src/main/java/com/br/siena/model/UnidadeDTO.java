package com.br.siena.model;

import com.br.siena.SienaApplication;
import com.br.siena.domain.UnidadeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class UnidadeDTO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UnidadeDTO() {
        this.setEntityManagerFactory(SienaApplication.getSession().getEntityManagerFactory());
        this.setEntityManager(this.getEntityManagerFactory().createEntityManager());
    }

    public UnidadeEntity find(int idUnidade) {
        return this.getEntityManager().find(UnidadeEntity.class, idUnidade);
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
