package com.economy.infrastructure.persistence;

import com.economy.domain.model.Empregado;
import com.economy.domain.repository.EmpregadoRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmpregadoRepository implements EmpregadoRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcEmpregadoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Empregado criarEmpregado(Empregado empregado) {
        String sql = """
            INSERT INTO empregado (cpf, nome, email, saldo, senha, data_criacao)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[] {"id"})) {

            stmt.setString(1, empregado.getCpf());
            stmt.setString(2, empregado.getNome());
            stmt.setString(3, empregado.getEmail());
            stmt.setBigDecimal(4, empregado.getSaldo());
            stmt.setString(5, empregado.getSenha());
            stmt.setTimestamp(6, new Timestamp(empregado.getDataCriacao().getTime()));

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    empregado.setEmpregadoId(rs.getInt(1));
                }
            }

            return empregado;

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting empregado", e);
        }
    }

    // -----------------------------------------------------------
    // UPDATE
    // -----------------------------------------------------------
    @Override
    public Empregado editarEmpregado(Empregado empregado, int idEmpregado) {
        String sql = """
            UPDATE empregado
            SET cpf = ?, nome = ?, email = ?, saldo = ?, senha = ?, data_criacao = ?
            WHERE id = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, empregado.getCpf());
            stmt.setString(2, empregado.getNome());
            stmt.setString(3, empregado.getEmail());
            stmt.setBigDecimal(4, empregado.getSaldo());
            stmt.setString(5, empregado.getSenha());
            stmt.setTimestamp(6, new Timestamp(empregado.getDataCriacao().getTime()));
            stmt.setInt(7, idEmpregado);

            stmt.executeUpdate();
            empregado.setEmpregadoId(idEmpregado);

            return empregado;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating empregado " + idEmpregado, e);
        }
    }

    // -----------------------------------------------------------
    // DELETE
    // -----------------------------------------------------------
    @Override
    public void deletarEmpregado(int idEmpregado) {
        String sql = "DELETE FROM empregado WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEmpregado);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting empregado " + idEmpregado, e);
        }
    }

    // -----------------------------------------------------------
    // LIST ALL
    // -----------------------------------------------------------
    @Override
    public List<Empregado> listarEmpregados() {
        String sql = "SELECT * FROM empregado ORDER BY id DESC";
        List<Empregado> empregados = new ArrayList<>();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                empregados.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listing empregados", e);
        }

        return empregados;
    }

    // -----------------------------------------------------------
    // LIST BY ID (your interface calls it listarByIdUsuario)
    // -----------------------------------------------------------
    @Override
    public List<Empregado> listarByIdUsuario(int idUsuario) {
        String sql = "SELECT * FROM empregado WHERE id = ?";

        List<Empregado> lista = new ArrayList<>();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listing empregado " + idUsuario, e);
        }

        return lista;
    }

    // -----------------------------------------------------------
    // LOGIN
    // -----------------------------------------------------------
    @Override
    public Empregado loginEmpregado(String email, String senha) {
        String sql = """
            SELECT * FROM empregado
            WHERE email = ? AND senha = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

            return null; // login failed

        } catch (SQLException e) {
            throw new RuntimeException("Error logging empregado", e);
        }
    }

    // -----------------------------------------------------------
    // INTERNAL ROW MAPPER
    // -----------------------------------------------------------
    private Empregado mapRow(ResultSet rs) throws SQLException {
        Empregado e = new Empregado();

        e.setEmpregadoId(rs.getInt("id"));
        e.setCpf(rs.getString("cpf"));
        e.setNome(rs.getString("nome"));
        e.setEmail(rs.getString("email"));

        BigDecimal saldo = rs.getBigDecimal("saldo");
        e.setSaldo(saldo != null ? saldo : BigDecimal.ZERO);

        e.setSenha(rs.getString("senha"));

        Timestamp ts = rs.getTimestamp("data_criacao");
        e.setDataCriacao(ts != null ? new Date(ts.getTime()) : null);

        return e;
    }
}
