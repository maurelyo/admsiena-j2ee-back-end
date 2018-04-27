package com.br.siena.model;

import com.br.siena.SienaApplication;
import com.br.siena.domain.PerfilEntity;
import com.br.siena.domain.PessoaEntity;
import com.br.siena.domain.UsuarioEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.postgresql.util.PGTimestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class UsuarioDTO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UsuarioDTO() {
        this.setEntityManagerFactory(SienaApplication.getSession().getEntityManagerFactory());
        this.setEntityManager(this.getEntityManagerFactory().createEntityManager());
    }

    public UsuarioEntity find(int idUsuario) {
        return this.getEntityManager().find(UsuarioEntity.class, idUsuario);
    }

    public UsuarioEntity save(PerfilEntity perfil,
                              String noSenha,
                              String noEmail,
                              PessoaEntity pessoa
    ) {

        Session session = SienaApplication.getSession();
        Transaction transaction = session.beginTransaction();



        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setDtAlteracao(new PGTimestamp(System.currentTimeMillis()));
        usuarioEntity.setInAtivo(true);
        usuarioEntity.setNoSenha(noSenha);
        usuarioEntity.setPerfil(perfil);
        usuarioEntity.setNoEmail(noEmail);
        usuarioEntity.setPessoa(pessoa);


        session.saveOrUpdate(usuarioEntity);
        transaction.commit();
        session.close();
        return usuarioEntity;

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
