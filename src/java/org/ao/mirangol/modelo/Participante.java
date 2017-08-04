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
public class Participante {
    private Integer idParticipanete;
    private String nomeParticipante;
    private Municipio municipio;
    private Sexo sexo;

    public Participante() {
    }

    public Participante(Integer idParticipanete, String nomeParticipante, Municipio municipio, Sexo sexo) {
        this.idParticipanete = idParticipanete;
        this.nomeParticipante = nomeParticipante;
        this.municipio = municipio;
        this.sexo = sexo;
    }

    public Integer getIdParticipanete() {
        return idParticipanete;
    }

    public void setIdParticipanete(Integer idParticipanete) {
        this.idParticipanete = idParticipanete;
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public void setNomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
}
