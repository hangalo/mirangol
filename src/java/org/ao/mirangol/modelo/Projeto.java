/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author informatica
 */
public class Projeto implements Serializable{
    private Integer idProjeto;
    private String codigoProjeto;
    private String nomeProjeto;
    private String descricaoProjeto;
    private Double custoProjeto;
    private String entidadeFinanciadora;
    private byte[] imagemProjeto;
    private String ficheiroImagemProjecto;
    private TipoProjeto tipoProjeto;

    public Projeto() {
    }

    public Integer getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getCodigoProjeto() {
        return codigoProjeto;
    }

    public void setCodigoProjeto(String codigoProjeto) {
        this.codigoProjeto = codigoProjeto;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    public Double getCustoProjeto() {
        return custoProjeto;
    }

    public void setCustoProjeto(Double custoProjeto) {
        this.custoProjeto = custoProjeto;
    }

    public String getEntidadeFinanciadora() {
        return entidadeFinanciadora;
    }

    public void setEntidadeFinanciadora(String entidadeFinanciadora) {
        this.entidadeFinanciadora = entidadeFinanciadora;
    }

    public TipoProjeto getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipoProjeto tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.idProjeto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Projeto other = (Projeto) obj;
        if (!Objects.equals(this.idProjeto, other.idProjeto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeProjeto;
    }
    
    
    
}
