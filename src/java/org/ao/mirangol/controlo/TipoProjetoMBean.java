/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.controlo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;
import org.ao.mirangol.dao.TipoProjetoDAO;
import org.ao.mirangol.modelo.TipoProjeto;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author informatica
 */
@Named(value = "tipoProjetoMBean")
@RequestScoped
public class TipoProjetoMBean {

    private TipoProjeto tipoProjeto;
    private TipoProjetoDAO tipoProjetoDAO;
    private List<TipoProjeto> tipoProjetos;

    private Part imagemTipoProjeto;
    private boolean uploaded;

    public TipoProjetoMBean() {
    }

    @PostConstruct
    public void inicializar() {
        tipoProjeto = new TipoProjeto();
        tipoProjetos = new ArrayList<>();
        tipoProjetoDAO = new TipoProjetoDAO();
    }

    public TipoProjeto getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipoProjeto tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    public List<TipoProjeto> getTipoProjetos() {
        return tipoProjetos;
    }

    public void setTipoProjetos(List<TipoProjeto> tipoProjetos) {
        this.tipoProjetos = tipoProjetos;
    }

    public Part getImagemTipoProjeto() {
        return imagemTipoProjeto;
    }

    public void setImagemTipoProjeto(Part imagemTipoProjeto) {
        this.imagemTipoProjeto = imagemTipoProjeto;
    }

    public void doUpload() {
        try {

            InputStream in = imagemTipoProjeto.getInputStream();

            File f = new File("D:\\mirangol\\imagens\\" + imagemTipoProjeto.getSubmittedFileName());

            // Guardar num disco de rede com IP
            // File f = new File("\\\\192.168.0.4\\mirangol\\imagens\\" + imagemTipoProjeto.getSubmittedFileName());

            /*
            PARA GUARDAR NUMA PASTA DENTRO DO PROJECTO BASTA FAZER
            String path ="/imagens";
            File f = new File(path);
            if(!f.exists()){
              f.mkdir();
            }
             */
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            byte[] buffer = new byte[1024 * 1024 * 100];

            int length;

            // Escreve no stream de saida
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();

            //Conteudo para a o campo foto da tabela tipo_projeto. Carrega uma string com o nome e extensao do ficheiro
            tipoProjeto.setFicheiroImagemProjeto(imagemTipoProjeto.getSubmittedFileName());

            //Conteudo em byte do ficheiro. Guarda o conteudo em bytes num campo da tabela.            
            byte[] conteudoEmBytes = IOUtils.toByteArray(imagemTipoProjeto.getInputStream());
            tipoProjeto.setImagemTipoProjeto(conteudoEmBytes);

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());
            uploaded = true;

            FacesMessage msg = new FacesMessage("Ficheito", "\t\t" + f.getName() + "\t" + "\t" + "carregado com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public String newSave() {
        tipoProjeto = new TipoProjeto();
        return "/paginas/novotipoprojeto";
    }

    public void save(ActionEvent event) {
        tipoProjetoDAO.save(tipoProjeto);
        tipoProjeto = new TipoProjeto();
    }

    public List<TipoProjeto> getListaTiposProjetos() {
        tipoProjetos = tipoProjetoDAO.findAll();
        return tipoProjetos;
    }

    public String startEdit() {
        return "/paginas/editartipoprojeto";
    }

    public String edit() {
        tipoProjetoDAO.update(tipoProjeto);
        tipoProjetos = null;
        return "/paginas/listartipoprojetos";
    }

    public String delete() {
        tipoProjetoDAO.delete(tipoProjeto);
        tipoProjetos = null;
        return "/paginas/listartipoprojetos";
    }

}
