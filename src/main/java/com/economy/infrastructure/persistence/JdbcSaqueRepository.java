package com.economy.infrastructure.persistence;

import com.economy.domain.model.Saque;
import com.economy.domain.repository.SaqueRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcSaqueRepository implements SaqueRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcSaqueRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Saque criarSaque(Saque saque) {
        String sql = """
            INSERT INTO saque (empregado_id, valor, metodo)
            VALUES (?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"id"})) {

            stmt.setInt(1, saque.getEmpregadoId());
            stmt.setBigDecimal(2, saque.getValor());
            stmt.setString(3, saque.getMetodo());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                saque.setId(rs.getInt(1));
            }

            return saque;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar saque", e);
        }
    }

    @Override
    public List<Saque> listarByEmpregadoId(int empregadoId) {
        String sql = """
            SELECT * FROM saque
             WHERE empregado_id = ?
             ORDER BY data_saque DESC
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empregadoId);

            ResultSet rs = stmt.executeQuery();
            List<Saque> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(mapResultSetToSaque(rs));
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar saques por empregado", e);
        }
    }

    private Saque mapResultSetToSaque(ResultSet rs) throws SQLException {
        Saque s = new Saque();

        s.setId(rs.getInt("id"));
        s.setEmpregadoId(rs.getInt("empregado_id"));
        s.setValor(rs.getBigDecimal("valor"));
        s.setMetodo(rs.getString("metodo"));
        s.setDataSaque(rs.getTimestamp("data_saque"));

        return s;
    }
}
