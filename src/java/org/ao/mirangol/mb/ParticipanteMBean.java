/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.mb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.ao.mirangol.dao.MunicipioDAO;
import org.ao.mirangol.dao.ParticipanteDAO;
import org.ao.mirangol.modelo.Municipio;
import org.ao.mirangol.modelo.Participante;
import org.ao.mirangol.modelo.Sexo;


/**
 *
 * @author informatica
 */
@Named(value = "participanteMBean")
@RequestScoped
public class ParticipanteMBean {

    private Participante participante;
    private List<Sexo> sexos;
    private MunicipioDAO municipioDAO;
    private ParticipanteDAO participanteDAO;
    private List<Municipio> municipios;
    private List<Participante> participantes;

    public ParticipanteMBean() {
    }

    @PostConstruct
    public void inicializar() {
        participante = new Participante();
        sexos = Arrays.asList(Sexo.values());
        municipioDAO = new MunicipioDAO();
        participanteDAO = new ParticipanteDAO();

    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public List<Sexo> getSexos() {
        return sexos;
    }

    public void setSexos(List<Sexo> sexos) {
        this.sexos = sexos;
    }

     public Sexo[] getGeneros()
    {
        return Sexo.values();
    }
     
    public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getAbreviatura()));
        }
        return list;
    }

    public List<Municipio> getMunicipios() {
        if (municipios == null) {
            municipios = municipioDAO.findAll();
        }
        return municipios;
    }

     public String newSave() {
        participante = new Participante();
        return "/paginas/participante_guardar";
    }

    public void save(ActionEvent event) {
       participanteDAO.save(participante);
        participante = new Participante();
          FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Dados guardados com sucesso!"));
    }
    
    public String startEdit() {
        return "/paginas/participante_editar";
    }

    public String edit() {
        participanteDAO.update(participante);
        participantes = null;
        return "participante_listar";
    }

    public String delete() {
        participanteDAO.delete(participante);
        participantes = null;
        return "participante_listar";
    }

    public List<Participante> getListaParticipantes() {
        if (participantes == null) {
            participantes = participanteDAO.findAll();
        }
        return participantes;
    }

}
