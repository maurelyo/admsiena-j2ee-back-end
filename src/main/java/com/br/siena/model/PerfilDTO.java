package com.br.siena.model;

import com.br.siena.SienaApplication;
import com.br.siena.domain.PerfilEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class PerfilDTO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public PerfilDTO() {
        this.setEntityManagerFactory(SienaApplication.getSession().getEntityManagerFactory());
        this.setEntityManager(this.getEntityManagerFactory().createEntityManager());
    }

    public PerfilEntity find(int idPerfil) {
        return this.getEntityManager().find(PerfilEntity.class, idPerfil);
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
