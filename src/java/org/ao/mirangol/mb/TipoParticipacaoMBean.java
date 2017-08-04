/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.mb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.ao.mirangol.dao.TipoParticipacaoDAO;
import org.ao.mirangol.modelo.TipoParticipacao;

/**
 *
 * @author informatica
 */
@Named(value = "tipoParticipacaoMBean")
@RequestScoped
public class TipoParticipacaoMBean {

    /**
     * Creates a new instance of TipoParticipacaoMBean
     */
    private TipoParticipacao tipoParticipacao;
    private List<TipoParticipacao> tipoParticipacoes;
    private TipoParticipacaoDAO tipoParticipacaoDAO;

    public TipoParticipacaoMBean() {
    }

    @PostConstruct
    public void initi() {
        tipoParticipacao = new TipoParticipacao();
        tipoParticipacoes = new ArrayList<>();
        tipoParticipacaoDAO = new TipoParticipacaoDAO();
    }

    public TipoParticipacao getTipoParticipacao() {
        return tipoParticipacao;
    }

    public void setTipoParticipacao(TipoParticipacao tipoParticipacao) {
        this.tipoParticipacao = tipoParticipacao;
    }

    public List<TipoParticipacao> getTipoParticipacoes() {
        tipoParticipacoes = tipoParticipacaoDAO.findAll();
        return tipoParticipacoes;
    }

    public void setTipoParticipacoes(List<TipoParticipacao> tipoParticipacoes) {
        this.tipoParticipacoes = tipoParticipacoes;
    }

}
