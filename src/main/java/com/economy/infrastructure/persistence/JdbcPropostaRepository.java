package com.economy.infrastructure.persistence;

import com.economy.domain.model.Proposta;
import com.economy.domain.repository.PropostaRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPropostaRepository implements PropostaRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcPropostaRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Proposta criarProposta(Proposta proposta) {
        String sql = """
            INSERT INTO proposta (empresa_id, empregado_id, descricao, valor, is_longo_prazo, status)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"id"})) {

            setStmtValores(proposta, stmt);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                proposta.setId(rs.getInt(1));
            }

            return proposta;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar proposta", e);
        }
    }

    @Override
    public Proposta editarProposta(Proposta proposta, int idProposta) {
        String sql = """
            UPDATE proposta
               SET empresa_id = ?, empregado_id = ?, descricao = ?, valor = ?, is_longo_prazo = ?, status = ?
             WHERE id = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            setStmtValores(proposta, stmt);
            stmt.setInt(7, idProposta);

            stmt.executeUpdate();
            proposta.setId(idProposta);

            return proposta;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao editar proposta", e);
        }
    }

    @Override
    public void deletarProposta(int idProposta) {
        String sql = "DELETE FROM proposta WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProposta);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar proposta", e);
        }
    }

    @Override
    public List<Proposta> listarPropostas() {
        String sql = "SELECT * FROM proposta ORDER BY data_criacao DESC";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            List<Proposta> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(mapResultSetToProposta(rs));
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar propostas", e);
        }
    }

    @Override
    public List<Proposta> listarByEmpresaId(int empresaId) {
        String sql = "SELECT * FROM proposta WHERE empresa_id = ? ORDER BY data_criacao DESC";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empresaId);

            ResultSet rs = stmt.executeQuery();
            List<Proposta> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(mapResultSetToProposta(rs));
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar propostas por empresa", e);
        }
    }

    @Override
    public List<Proposta> listarByEmpregadoId(int empregadoId) {
        String sql = "SELECT * FROM proposta WHERE empregado_id = ? ORDER BY data_criacao DESC";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empregadoId);

            ResultSet rs = stmt.executeQuery();
            List<Proposta> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(mapResultSetToProposta(rs));
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar propostas por empregado", e);
        }
    }

    @Override
    public Proposta getProposta(int idProposta) {
        String sql = "SELECT * FROM proposta WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProposta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToProposta(rs);
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar proposta", e);
        }
    }

    // ---------------------
    // 🔄 MAP RESULTSET TO MODEL
    // ---------------------
    private Proposta mapResultSetToProposta(ResultSet rs) throws SQLException {
        Proposta p = new Proposta();

        p.setId(rs.getInt("id"));
        p.setEmpresaId(rs.getInt("empresa_id"));
        p.setEmpregadoId(rs.getInt("empregado_id"));
        p.setDescricao(rs.getString("descricao"));
        p.setValor(rs.getBigDecimal("valor"));
        p.setDataCriacao(rs.getTimestamp("data_criacao"));
        p.setLongoPrazo(rs.getBoolean("is_longo_prazo"));
        p.setStatus(rs.getString("status"));

        return p;
    }

    private void setStmtValores(Proposta proposta, PreparedStatement stmt) throws SQLException {
        stmt.setInt(1, proposta.getEmpresaId());
        stmt.setInt(2, proposta.getEmpregadoId());
        stmt.setString(3, proposta.getDescricao());
        stmt.setBigDecimal(4, proposta.getValor());
        stmt.setBoolean(5, proposta.isLongoPrazo());
        stmt.setString(6, proposta.getStatus());
    }
}
