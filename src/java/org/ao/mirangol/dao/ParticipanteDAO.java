package org.ao.mirangol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.ao.mirangol.modelo.Municipio;
import org.ao.mirangol.modelo.Participante;
import org.ao.mirangol.modelo.Sexo;
import org.ao.mirangol.util.Conexao;

/**
 *
 * @author informatica
 */
public class ParticipanteDAO implements GenericoDAO<Participante> {

    private static final String INSERT = "INSERT INTO participante(nome_participante,sobrenome_participante,sexo_participante,data_nascimento_participante,id_municipio) VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE participante SET nome_participante = ?, sobrenome_participante = ?, sexo_participante = ?, data_nascimento_participante = ? , id_municipio = ? WHERE id_participante = ?";
    private static final String DELETE = "DELETE FROM participante WHERE id_participante = ?";
    private static final String SELECT_BY_ID = "SELECT id_participante, nome_participante, sobrenome_participante, sexo_participante, nome_municipio, data_nascimento_participante FROM participante p INNER JOIN municipio m ON (p.id_municipio = m.id_municipio) WHERE id_participante = ?;";
    private static final String SELECT_ALL = "SELECT id_participante, nome_participante, sobrenome_participante, sexo_participante, nome_municipio, data_nascimento_participante FROM participante p INNER JOIN municipio m ON (p.id_municipio = m.id_municipio);";

    public ParticipanteDAO() {

    }

    @Override
    public void save(Participante participante) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (participante == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, participante.getNomeParticipante());
            ps.setString(2, participante.getSobrenomeParticipante());
            ps.setString(3, participante.getSexo().getAbreviatura());
            ps.setDate(4, new java.sql.Date(participante.getDataNascimento().getTime()));
            ps.setInt(5, participante.getMunicipio().getIdMunicipio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Participante participante) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (participante == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, participante.getNomeParticipante());
            ps.setString(2, participante.getSobrenomeParticipante());
            ps.setString(3, participante.getSexo().getAbreviatura());
            ps.setDate(4, new java.sql.Date(participante.getDataNascimento().getTime()));
            ps.setInt(5, participante.getMunicipio().getIdMunicipio());
            ps.setInt(6, participante.getIdParticipanete());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Participante participante) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (participante == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, participante.getIdParticipanete());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Participante findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Participante participante = new Participante();

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(participante, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return participante;
    }

    @Override
    public List<Participante> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Participante> participantes = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Participante participante = new Participante();
                popularComDados(participante, rs);
                participantes.add(participante);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return participantes;
    }

    private void popularComDados(Participante participante, ResultSet rs) {
        try {
            participante.setIdParticipanete(rs.getInt("id_participante"));
            participante.setNomeParticipante(rs.getString("nome_participante"));
            participante.setSobrenomeParticipante(rs.getString("sobrenome_participante"));
            participante.setDataNascimento(rs.getDate("data_nascimento_participante"));
            participante.setSexo(Sexo.getAbreviatura(rs.getString("sexo_participante")));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            participante.setMunicipio(municipio);
        

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
