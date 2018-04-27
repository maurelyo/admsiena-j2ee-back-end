package com.br.siena.model;

import com.br.siena.SienaApplication;
import com.br.siena.domain.TipoPessoaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class TipoPessoaDTO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public TipoPessoaDTO() {
        this.setEntityManagerFactory(SienaApplication.getSession().getEntityManagerFactory());
        this.setEntityManager(this.getEntityManagerFactory().createEntityManager());
    }

    public TipoPessoaEntity find(int idTipoPessoa) {
        return this.getEntityManager().find(TipoPessoaEntity.class, idTipoPessoa);
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
