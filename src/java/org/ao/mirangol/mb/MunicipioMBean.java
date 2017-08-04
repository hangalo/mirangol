/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.mb;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.ao.mirangol.dao.MunicipioDAO;
import org.ao.mirangol.modelo.Municipio;
import org.ao.mirangol.modelo.Provincia;

/**
 *
 * @author informatica
 */
@Named(value = "municipioMBean")
@RequestScoped
public class MunicipioMBean {

    private Municipio municipio;
    private List<Municipio> municipios;
    private MunicipioDAO municipioDAO;

    public MunicipioMBean() {
        municipio = new Municipio();
        municipios = new ArrayList<>();
        municipioDAO = new MunicipioDAO();
        municipios = municipioDAO.findAll();
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public List<Municipio> buscaMunicipiosPorProvincia(String provincia) {
        municipios = municipioDAO.buscaMunicipiosPorProvincia(provincia);
        return municipios;
    }

}
