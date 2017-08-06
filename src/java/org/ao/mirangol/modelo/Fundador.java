/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author informatica
 */



public class Fundador implements Serializable{
    private Integer idFundador;
    private String nomeFundador;
    private String sobrenomeFundador;
    private Date dataNascimentoFundador;
    private Sexo sexo;
    private String casaFundador;
    private String ruaFundador;
    private String bairroFundador;
    private String distritoFundador;
    private String telefoneUnitel;
    private String telefoneMovicel;
    private String telefoneFixo;
    private String emailPrincipal;
    private String emailAlternativo;
    private Departamento departamento;
    
    private Municipio municipio;

    public Fundador() {
    }

   /* Metodos setters e gettes omitidos*/

    public Fundador(Integer idFundador, String nomeFundador, String sobrenomeFundador, Date dataNascimentoFundador, Sexo sexo, String casaFundador, String ruaFundador, String bairroFundador, String distritoFundador, String telefoneUnitel, String telefoneMovicel, String telefoneFixo, String emailPrincipal, String emailAlternativo, Departamento departamento, Municipio municipio) {
        this.idFundador = idFundador;
        this.nomeFundador = nomeFundador;
        this.sobrenomeFundador = sobrenomeFundador;
        this.dataNascimentoFundador = dataNascimentoFundador;
        this.sexo = sexo;
        this.casaFundador = casaFundador;
        this.ruaFundador = ruaFundador;
        this.bairroFundador = bairroFundador;
        this.distritoFundador = distritoFundador;
        this.telefoneUnitel = telefoneUnitel;
        this.telefoneMovicel = telefoneMovicel;
        this.telefoneFixo = telefoneFixo;
        this.emailPrincipal = emailPrincipal;
        this.emailAlternativo = emailAlternativo;
        this.departamento = departamento;
        this.municipio = municipio;
    }

    public Integer getIdFundador() {
        return idFundador;
    }

    public void setIdFundador(Integer idFundador) {
        this.idFundador = idFundador;
    }

    public String getNomeFundador() {
        return nomeFundador;
    }

    public void setNomeFundador(String nomeFundador) {
        this.nomeFundador = nomeFundador;
    }

    public String getSobrenomeFundador() {
        return sobrenomeFundador;
    }

    public void setSobrenomeFundador(String sobrenomeFundador) {
        this.sobrenomeFundador = sobrenomeFundador;
    }

    public Date getDataNascimentoFundador() {
        return dataNascimentoFundador;
    }

    public void setDataNascimentoFundador(Date dataNascimentoFundador) {
        this.dataNascimentoFundador = dataNascimentoFundador;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCasaFundador() {
        return casaFundador;
    }

    public void setCasaFundador(String casaFundador) {
        this.casaFundador = casaFundador;
    }

    public String getRuaFundador() {
        return ruaFundador;
    }

    public void setRuaFundador(String ruaFundador) {
        this.ruaFundador = ruaFundador;
    }

    public String getBairroFundador() {
        return bairroFundador;
    }

    public void setBairroFundador(String bairroFundador) {
        this.bairroFundador = bairroFundador;
    }

    public String getDistritoFundador() {
        return distritoFundador;
    }

    public void setDistritoFundador(String distritoFundador) {
        this.distritoFundador = distritoFundador;
    }

    public String getTelefoneUnitel() {
        return telefoneUnitel;
    }

    public void setTelefoneUnitel(String telefoneUnitel) {
        this.telefoneUnitel = telefoneUnitel;
    }

    public String getTelefoneMovicel() {
        return telefoneMovicel;
    }

    public void setTelefoneMovicel(String telefoneMovicel) {
        this.telefoneMovicel = telefoneMovicel;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
   

    @Override
    public String toString() {
        return this.nomeFundador + " " + this.sobrenomeFundador;
    }

  
    
    
   
}
