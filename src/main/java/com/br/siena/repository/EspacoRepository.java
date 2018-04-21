package com.br.siena.repository;

import com.br.siena.SienaApplication;
import com.br.siena.domain.EspacoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class EspacoRepository {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EspacoRepository() {
        this.setEntityManagerFactory(SienaApplication.getSession().getEntityManagerFactory());
        this.setEntityManager(this.getEntityManagerFactory().createEntityManager());
    }

    public List<EspacoEntity> listarAtivos() {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EspacoEntity> query = builder.createQuery(EspacoEntity.class);
        Root<EspacoEntity> from = query.from(EspacoEntity.class);
        TypedQuery<EspacoEntity> typedQuery = this.getEntityManager().createQuery(
                query.select(from)
                        .where(
                                builder.equal(from.get("inAtivo"), true)
                        )
                        .orderBy(
                                builder.asc(from.get("noEspaco"))
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
