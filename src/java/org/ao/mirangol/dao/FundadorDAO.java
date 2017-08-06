import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.ao.mirangol.dao.GenericoDAO;

import org.ao.mirangol.modelo.Departamento;
import org.ao.mirangol.modelo.Fundador;
import org.ao.mirangol.modelo.Municipio;
import org.ao.mirangol.modelo.Sexo;
import org.ao.mirangol.util.Conexao;

/**
 *
 * @author informatica
 */
public class FundadorDAO implements GenericoDAO<Fundador> {

    private static final String INSERT = "INSERT INTO participante(nome_participante,sobrenome_participante,sexo_participante,id_municipio,data_nascimento_participante) VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE participante SET nome_participante = ?, sobrenome_participante = ?, sexo_participante = ?, id_municipio = ?, data_nascimento_participante = ? WHERE id_participante = ?";
    private static final String DELETE = "DELETE FROM participante WHERE id_participante = ?";
    private static final String SELECT_BY_ID = "SELECT id_participante, nome_participante, sobrenome_participante, sexo_participante, nome_municipio, data_nascimento_participante FROM participante p INNER JOIN municipio m ON (p.id_municipio = m.id_municipio) WHERE id_participante = ?;";
    private static final String SELECT_ALL = "SELECT id_participante, nome_participante, sobrenome_participante, sexo_participante, nome_municipio, data_nascimento_participante FROM participante p INNER JOIN municipio m ON (p.id_municipio = m.id_municipio);";

    public FundadorDAO() {

    }

    @Override
    public void save(Fundador fundador) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (fundador == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, fundador.getNomeFundador());
            ps.setString(2, fundador.getSobrenomeFundador());
            ps.setDate(3, new java.sql.Date(fundador.getDataNascimentoFundador().getTime()));
            ps.setString(4, fundador.getSexo().getAbreviatura());
            ps.setString(5, fundador.getCasaFundador());
            ps.setString(6, fundador.getRuaFundador());
            ps.setString(7, fundador.getBairroFundador());
            ps.setString(8, fundador.getDistritoFundador());
            ps.setString(9, fundador.getTelefoneUnitel());
            ps.setString(10, fundador.getTelefoneMovicel());
            ps.setString(11, fundador.getTelefoneFixo());
            ps.setString(12, fundador.getEmailPrincipal());
            ps.setString(13, fundador.getEmailAlternativo());
            ps.setInt(14, fundador.getDepartamento().getIdDepartamento());
             ps.setInt(15, fundador.getMunicipio().getIdMunicipio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Fundador funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (funcionario == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, funcionario.getNomeFundador());
            ps.setString(2, funcionario.getSobrenomeFundador());
            ps.setDate(3, new java.sql.Date(funcionario.getDataNascimentoFundador().getTime()));
            ps.setString(4, funcionario.getSexo().getAbreviatura());
            ps.setString(5, funcionario.getCasaFundador());
            ps.setString(6, funcionario.getRuaFundador());
            ps.setString(7, funcionario.getBairroFundador());
            ps.setString(8, funcionario.getDistritoFundador());
            ps.setString(9, funcionario.getTelefoneUnitel());
            ps.setString(10, funcionario.getTelefoneMovicel());
            ps.setString(11, funcionario.getTelefoneFixo());
            ps.setString(12, funcionario.getEmailPrincipal());
            ps.setString(13, funcionario.getEmailAlternativo());
            ps.setInt(14, funcionario.getDepartamento().getIdDepartamento());
       
            ps.setInt(16, funcionario.getMunicipio().getIdMunicipio());
            ps.setInt(17, funcionario.getIdFundador());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Fundador funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (funcionario == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, funcionario.getIdFundador());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Fundador findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Fundador funcionario = new Fundador();

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(funcionario, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return funcionario;
    }

    @Override
    public List<Fundador> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Fundador> funcionarios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Fundador funcionario = new Fundador();
                popularComDados(funcionario, rs);
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return funcionarios;
    }

    private void popularComDados(Fundador funcionario, ResultSet rs) {
        try {
            funcionario.setIdFundador(rs.getInt("f.id_funcionario"));
            funcionario.setNomeFundador(rs.getString("f.nome_funcionario"));
            funcionario.setSobrenomeFundador(rs.getString("f.sobrenome_funcionario"));
            funcionario.setDataNascimentoFundador(rs.getDate("f.data_nascimento_funcionario"));
            funcionario.setSexo(Sexo.getAbreviatura(rs.getString("f.sexo_funcionario")));
            funcionario.setCasaFundador(rs.getString("f.casa_funcionario"));
            funcionario.setRuaFundador(rs.getString("f.rua_funcionario"));
            funcionario.setBairroFundador(rs.getString("f.bairrro_funcionario"));
            funcionario.setDistritoFundador(rs.getString("f.distrito_funcionario"));
            funcionario.setTelefoneUnitel(rs.getString("f.telefone_unitel"));
            funcionario.setTelefoneMovicel(rs.getString("f.telefone_movicel"));
            funcionario.setTelefoneFixo(rs.getString("f.telefone_fixo"));
            funcionario.setEmailPrincipal(rs.getString("f.email_principal"));
            funcionario.setEmailAlternativo(rs.getString("f.email_alternativo"));
            Departamento departamento = new Departamento();
            departamento.setNomeDepartamento(rs.getString("d.nome_departamento"));
            funcionario.setDepartamento(departamento);
           
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("m.nome_municipio"));
            funcionario.setMunicipio(municipio);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
