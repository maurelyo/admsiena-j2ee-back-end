package com.br.siena.model;

import com.br.siena.SienaApplication;
import com.br.siena.domain.PessoaEntity;
import com.br.siena.domain.TipoPessoaEntity;
import com.br.siena.domain.UnidadeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.postgresql.util.PGTimestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Date;


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

    public PessoaEntity save(String noPessoa,
                             UnidadeEntity unidade,
                             TipoPessoaEntity tipoPessoa,
                             String nuCpf,
                             String nuRg,
                             Date dtNascimento
    ) {

        Session session = SienaApplication.getSession();
        Transaction transaction = session.beginTransaction();

        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setDtAlteracao(new PGTimestamp(System.currentTimeMillis()));
        pessoaEntity.setInAtivo(true);
        pessoaEntity.setNoPessoa(noPessoa);
        pessoaEntity.setUnidade(unidade);
        pessoaEntity.setTipoPessoa(tipoPessoa);
        pessoaEntity.setNuCpf(nuCpf);
        pessoaEntity.setNuRg(nuRg);
        pessoaEntity.setDtNascimento(dtNascimento);

        session.saveOrUpdate(pessoaEntity);
        transaction.commit();
        session.close();
        return pessoaEntity;
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
