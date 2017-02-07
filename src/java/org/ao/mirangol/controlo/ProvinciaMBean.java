/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.controlo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.ao.mirangol.dao.MunicipioDAO;
import org.ao.mirangol.dao.ProvinciaDAO;
import org.ao.mirangol.modelo.Municipio;
import org.ao.mirangol.modelo.Provincia;

/**
 *
 * @author informatica
 */
@Named(value = "provinciaMBean")
@RequestScoped
public class ProvinciaMBean {

    private Provincia provincia;
    private List<Provincia> provincias;
    private ProvinciaDAO provinciaDAO;
    private List<Municipio> municipios;
    private MunicipioDAO municipioDAO;

    public ProvinciaMBean() {
        
    }

    @PostConstruct
    public void init() {

        provincia = new Provincia();
        provincias = new ArrayList<>();
        municipios = new ArrayList<>();
        provinciaDAO = new ProvinciaDAO();
        provincias = provinciaDAO.findAll();
        
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public ProvinciaDAO getProvinciaDAO() {
        return provinciaDAO;
    }

    public void setProvinciaDAO(ProvinciaDAO provinciaDAO) {
        this.provinciaDAO = provinciaDAO;
    }

    public List<Municipio> getMunicipios() {

        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    

}
