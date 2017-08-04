/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.mb;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.ao.mirangol.modelo.Usuario;

/**
 *
 * @author informatica
 */
@Named(value = "usuarioMBean")
@RequestScoped
public class UsuarioMBean {

    
    private Usuario usuario;
    public UsuarioMBean() {
    }
    
    
     @PostConstruct
    public void inicializar() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public String login(){
    
    return "";
    }
    
    
}
