/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.modelo;

/**
 *
 * @author informatica
 */
public class TipoParticipacao {
    private Integer idTipoParticipacao;
    private String tipoParticipacao;

    public TipoParticipacao() {
    }

    public TipoParticipacao(Integer idTipoParticipacao, String tipoParticipacao) {
        this.idTipoParticipacao = idTipoParticipacao;
        this.tipoParticipacao = tipoParticipacao;
    }

    public Integer getIdTipoParticipacao() {
        return idTipoParticipacao;
    }

    public void setIdTipoParticipacao(Integer idTipoParticipacao) {
        this.idTipoParticipacao = idTipoParticipacao;
    }

    public String getTipoParticipacao() {
        return tipoParticipacao;
    }

    public void setTipoParticipacao(String tipoParticipacao) {
        this.tipoParticipacao = tipoParticipacao;
    }
    
    
}
