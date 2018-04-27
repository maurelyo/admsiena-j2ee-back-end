package com.br.siena.service;

import com.br.siena.domain.PessoaEntity;
import com.br.siena.domain.TipoPessoaEntity;
import com.br.siena.domain.UnidadeEntity;
import com.br.siena.exception.TipoPessoaException;
import com.br.siena.exception.UnidadeException;
import com.br.siena.model.PessoaDTO;
import com.br.siena.repository.PessoaRepository;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public class PessoaService {

    /**
     * Recupera um cadastro de pessoa por id
     * @param id Identificador da pessoa
     * @return PessoaEntity
     */
    public PessoaEntity recuperar(int id) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        return pessoaDTO.find(id);
    }

    /**
     * Lista as pessoas com cadastro ativo
     * @return List
     */

    public List<PessoaEntity> listar() {
        PessoaRepository repository = new PessoaRepository();
        repository.listarAtivos();
        return repository.listarAtivos();
    }

    /**
     * Cadastra uma nova pessoa
     * @param noPessoa Nome completo da pessoa
     * @param idUnidade Identificador da unidade relacionada
     * @param idTipoPessoa Identificador do tipo de pessoa
     * @param nuCpf Numero do CPF da pessoa
     * @param nuRg Numero do RG da pessoa
     * @param dtNascimento Data de nascimento da pessoa
     * @return PessoaEntity
     * @throws UnidadeException
     * @throws TipoPessoaException
     * @throws ParseException
     */
    public PessoaEntity cadastrarPessoa(String noPessoa,
                                        int idUnidade,
                                        int idTipoPessoa,
                                        String nuCpf,
                                        String nuRg,
                                        String dtNascimento
    ) throws UnidadeException, TipoPessoaException, ParseException {
        // Recupera a entidade Unidade por id
        UnidadeService unidadeService = new UnidadeService();
        UnidadeEntity unidade = unidadeService.recuperar(idUnidade);
        if (null == unidade) {
            throw new UnidadeException("Unidade não encontrada.");
        }

        // Recupera a entidade Tipo Pessoa por id
        TipoPessoaService tipoPessoaService = new TipoPessoaService();
        TipoPessoaEntity tipoPessoa = tipoPessoaService.recuperar(idTipoPessoa);
        if (null == tipoPessoa) {
            throw new TipoPessoaException("Perfil (tipo) de Pessoa não encontrada.");
        }

        PessoaDTO pessoaDTO = new PessoaDTO();
        return pessoaDTO.save(noPessoa, unidade, tipoPessoa, nuCpf, nuRg, Date.valueOf(dtNascimento));
    }
}
