/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.ao.mirangol.modelo.Municipio;
import org.ao.mirangol.modelo.Provincia;
import org.ao.mirangol.modelo.TipoParticipacao;
import org.ao.mirangol.util.Conexao;

/**
 *
 * @author informatica
 */
public class TipoParticipacaoDAO implements GenericoDAO<TipoParticipacao>{
    private static final String INSERIR = "INSERT INTO tipo_participacao(tipo_participacao) VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE tipo_participacao SET tipo_participacao=?, id_tipo_participacao=? WHERE id_tipo_participacao=?";
    private static final String ELIMINAR = "DELETE FROM tipo_participacao WHERE id_tipo_participacao = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT tp.id_tipo_participacao, tp.tipo_participacao FROM tipo_participacao tp WHERE id_tipo_participacao =?";
    private static final String LISTAR_TUDO = "SELECT tp.id_tipo_participacao, tp.tipo_participacao FROM tipo_participacao tp";


    public TipoParticipacaoDAO() {
          
    }
 
    @Override
    public void save(TipoParticipacao tipoParticipacao) {
       PreparedStatement ps = null;
        Connection conn = null;

        if (tipoParticipacao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, tipoParticipacao.getTipoParticipacao());
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(TipoParticipacao tipoParticipacao) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (tipoParticipacao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, tipoParticipacao.getTipoParticipacao());           
            ps.setInt(2, tipoParticipacao.getIdTipoParticipacao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(TipoParticipacao tipoParticipacao) {
         PreparedStatement ps = null;
        Connection conn = null;

        if (tipoParticipacao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, tipoParticipacao.getIdTipoParticipacao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public TipoParticipacao findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        TipoParticipacao tipoParticipacao = new TipoParticipacao();

        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(tipoParticipacao, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return tipoParticipacao;
    }

    @Override
    public List<TipoParticipacao> findAll() {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<TipoParticipacao> tipoParticipacoes = new ArrayList<>();
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoParticipacao tipoParticipacao = new TipoParticipacao();
                popularComDados(tipoParticipacao, rs);
                tipoParticipacoes.add(tipoParticipacao);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return tipoParticipacoes;
    }
    
    
     private void popularComDados(TipoParticipacao tipoParticipacao, ResultSet rs) {
        try {
            tipoParticipacao.setIdTipoParticipacao(rs.getInt("tp.id_tipo_participacao"));
            tipoParticipacao.setTipoParticipacao(rs.getString("tp.tipo_participacao"));
          

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
