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
import javax.faces.model.SelectItem;
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

    public ParticipanteMBean() {
    }

    @PostConstruct
    public void init() {
        participante = new Participante();
        sexos = Arrays.asList(Sexo.values());

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

    public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getExtensao()));
        }
        return list;
    }

}
