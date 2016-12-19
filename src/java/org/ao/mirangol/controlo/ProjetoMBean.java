/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.controlo;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import org.ao.mirangol.dao.ProjetoDAO;
import org.ao.mirangol.dao.TipoProjetoDAO;
import org.ao.mirangol.modelo.Projeto;
import org.ao.mirangol.modelo.TipoProjeto;


@Named(value = "projetoMBean")
@RequestScoped
public class ProjetoMBean {

    private Projeto projeto;
    private ProjetoDAO projetoDAO;
    private TipoProjetoDAO tipoProjetoDAO;
    private List<Projeto> projetos;
    private List<TipoProjeto> tipoProjetos;

    public ProjetoMBean() {
       
    }

    @PostConstruct
    public void inicializar() {
         projeto = new Projeto();
       projetoDAO = new ProjetoDAO();
       tipoProjetoDAO = new TipoProjetoDAO();
    }
    
    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public ProjetoDAO getProjetoDAO() {
        return projetoDAO;
    }

    public void setProjetoDAO(ProjetoDAO projetoDAO) {
        this.projetoDAO = projetoDAO;
    }

    public String newSave() {
        projeto = new Projeto();
        return "paginas/novoprojeto";
    }

    public void save(ActionEvent event) {
        projetoDAO.save(projeto);
        projeto = new Projeto();
    }

    public List<Projeto> getListaProjetos() {
        if (projetos == null) {
            projetos = projetoDAO.findAll();
        }
        return projetos;
    }
    
    

    public String startEdit() {
        return "/paginas/editarprojeto";
    }

    public String edit() {
        projetoDAO.update(projeto);
        projetos = null;
        return "listaprojetos";
    }

    public String delete() {
        projetoDAO.delete(projeto);
        projetos = null;
        return "listaprojetos";
    }
    
    public List<TipoProjeto> getListaTipoProjetos() {
        if (tipoProjetos == null) {
            tipoProjetos = tipoProjetoDAO.findAll();
        }
        return tipoProjetos;
    }

}
