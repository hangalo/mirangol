/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.controlo;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import org.ao.mirangol.dao.CategoriaFuncionarioDAO;
import org.ao.mirangol.modelo.CategoriaFuncionario;

@Named(value = "categoriaFuncionarioMBean")
@SessionScoped
public class CategoriaFuncionarioMBean implements Serializable {

    private CategoriaFuncionario categoria;
    private CategoriaFuncionarioDAO categoriaDAO;
    private List<CategoriaFuncionario> categorias;

    public CategoriaFuncionarioMBean() {
    }

    @PostConstruct
    public void inicializar() {
        categoria = new CategoriaFuncionario();
        categoriaDAO = new CategoriaFuncionarioDAO();
    }

    public CategoriaFuncionario getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFuncionario categoria) {
        this.categoria = categoria;
    }

    public String newSave() {
        categoria = new CategoriaFuncionario();
        return "/paginas/novacategoria";
    }

    public void save(ActionEvent event) {
        categoriaDAO.save(categoria);
        categoria = new CategoriaFuncionario();
    }

    public List<CategoriaFuncionario> getListaCategorias() {
        if (categorias == null) {
            categorias = categoriaDAO.findAll();
        }
        return categorias;
    }

    public String startEdit() {
        return "/paginas/editarcategoria";
    }

    public String edit() {
        categoriaDAO.update(categoria);
        categorias = null;
        return "/paginas/listacategorias";
    }

    public String delete() {
        categoriaDAO.delete(categoria);
        categorias = null;
        return "/paginas/listacategorias";
    }

}
