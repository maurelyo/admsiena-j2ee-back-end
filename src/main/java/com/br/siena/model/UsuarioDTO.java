package com.br.siena.model;

import com.br.siena.SienaApplication;
import com.br.siena.domain.UsuarioEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.postgresql.util.PGTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Date;
import java.util.Base64;


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

    public UsuarioEntity save(String noLogin,
                              String noPessoa,
                              int idPerfil,
                              int idUnidade,
                              String nuCpf,
                              String noSenhaBase64,
                              Date dtNascimento
    ) {

        Session session = SienaApplication.getSession();
        Transaction transaction = session.beginTransaction();

        byte[] noSenhaBytes = Base64.getDecoder().decode(noSenhaBase64);
        String noSenha = new String(noSenhaBytes);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNoLogin(noLogin);
        usuarioEntity.setNoPessoa(noPessoa);
        usuarioEntity.setDtAlteracao(new PGTimestamp(System.currentTimeMillis()));
        usuarioEntity.setInAtivo(true);
        usuarioEntity.setIdPerfil(idPerfil);
        usuarioEntity.setIdUnidade(idUnidade);
        usuarioEntity.setNuCpf(nuCpf);
        usuarioEntity.setNoSenha(passwordEncoder.encode(noSenha));
        usuarioEntity.setDtNascimento(dtNascimento);
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
