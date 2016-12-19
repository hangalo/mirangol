/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.modelo;

import java.io.Serializable;

/**
 *
 * @author informatica
 */
public class Usuario implements  Serializable{
    private String nomeUsurario;
    private String passwordUsuario;

    public Usuario() {
    }

    public String getNomeUsurario() {
        return nomeUsurario;
    }

    public void setNomeUsurario(String nomeUsurario) {
        this.nomeUsurario = nomeUsurario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }
    
    
    
}
