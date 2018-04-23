package com.br.siena.repository;

import com.br.siena.SienaApplication;
import com.br.siena.domain.UsuarioEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UsuarioRepository {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UsuarioRepository() {
        this.setEntityManagerFactory(SienaApplication.getSession().getEntityManagerFactory());
        this.setEntityManager(this.getEntityManagerFactory().createEntityManager());
    }

    public List<UsuarioEntity> listarAtivos() {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UsuarioEntity> query = builder.createQuery(UsuarioEntity.class);
        Root<UsuarioEntity> from = query.from(UsuarioEntity.class);
        TypedQuery<UsuarioEntity> typedQuery = this.getEntityManager().createQuery(
                query.select(from)
                        .where(
                                builder.equal(from.get("inAtivo"), true)
                        )
                        .orderBy(
                                builder.asc(from.get("noPessoa"))
                        )
        );
        return typedQuery.getResultList();
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    private void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManager;
    }

    private void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
