/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirango.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.ao.mirangol.dao.MunicipioDAO;
import org.ao.mirangol.modelo.Municipio;


/**
 *
 * @author informatica
 */
@FacesConverter(value = "municipioConverter", forClass = Municipio.class)
public class MunicipioConverter implements Converter {

    MunicipioDAO municipioDAO = new MunicipioDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return municipioDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      
      if (value != null) {
            return ((Municipio) value).getIdMunicipio().toString();
        }
        return null;
    }

}
