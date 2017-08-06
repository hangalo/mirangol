/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.modelo;

import java.util.Date;

/**
 *
 * @author informatica
 */
public class Participante {

    private Integer idParticipanete;
    private String nomeParticipante;
    private String sobrenomeParticipante;
    private Sexo sexo;
    private Date dataNascimento;
    private Municipio municipio;

    public Participante() {
    }

    public Participante(Integer idParticipanete, String nomeParticipante, String sobrenomeParticipante, Sexo sexo, Date dataNascimento, Municipio municipio) {
        this.idParticipanete = idParticipanete;
        this.nomeParticipante = nomeParticipante;
        this.sobrenomeParticipante = sobrenomeParticipante;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.municipio = municipio;
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

    public String getSobrenomeParticipante() {
        return sobrenomeParticipante;
    }

    public void setSobrenomeParticipante(String sobrenomeParticipante) {
        this.sobrenomeParticipante = sobrenomeParticipante;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Participante{" + "nomeParticipante=" + nomeParticipante + ", sobrenomeParticipante=" + sobrenomeParticipante + '}';
    }

   
    
}
