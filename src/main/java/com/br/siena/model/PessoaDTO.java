package com.br.siena.model;

import com.br.siena.SienaApplication;
import com.br.siena.domain.PessoaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class PessoaDTO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public PessoaDTO() {
        this.setEntityManagerFactory(SienaApplication.getSession().getEntityManagerFactory());
        this.setEntityManager(this.getEntityManagerFactory().createEntityManager());
    }

    public PessoaEntity find(int idPessoa) {
        return this.getEntityManager().find(PessoaEntity.class, idPessoa);
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
