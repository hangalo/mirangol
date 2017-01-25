/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author informatica
 */
public class Participacao implements Serializable{

    private static final long serialVersionUID = -1865595223809117627L;
    private Date dataInscricao;
    private Participante participante;
    private Projeto projeto;
    private TipoParticipacao tipoParticipacao;

    public Participacao() {
    }

    public Participacao(Date dataInscricao, Participante participante, Projeto projeto, TipoParticipacao tipoParticipacao) {
        this.dataInscricao = dataInscricao;
        this.participante = participante;
        this.projeto = projeto;
        this.tipoParticipacao = tipoParticipacao;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public TipoParticipacao getTipoParticipacao() {
        return tipoParticipacao;
    }

    public void setTipoParticipacao(TipoParticipacao tipoParticipacao) {
        this.tipoParticipacao = tipoParticipacao;
    }

    @Override
    public String toString() {
        return "Participacao{" + "dataInscricao=" + dataInscricao + ", participante=" + participante + ", projeto=" + projeto + ", tipoParticipacao=" + tipoParticipacao + '}';
    }
    
    
}
