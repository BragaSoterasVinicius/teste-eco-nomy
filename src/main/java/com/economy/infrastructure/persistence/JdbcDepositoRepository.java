package com.economy.infrastructure.persistence;

import com.economy.domain.model.Deposito;
import com.economy.domain.repository.DepositoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDepositoRepository implements DepositoRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcDepositoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Deposito criarDeposito(Deposito deposito) {
        String sql = """
            INSERT INTO deposito (empresa_id, valor, origem, data_deposito)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[] {"id"})) {

            stmt.setInt(1, deposito.getEmpresaId());
            stmt.setBigDecimal(2, deposito.getValor());
            stmt.setString(3, deposito.getOrigem());
            stmt.setTimestamp(4, new Timestamp(deposito.getDateDeposito().getTime()));

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    deposito.setId(rs.getInt(1));
                }
            }

            return deposito;

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting deposito", e);
        }
    }

    @Override
    public Deposito editarDeposito(Deposito deposito, int idDeposito) {
        String sql = """
            UPDATE deposito
            SET empresa_id = ?, valor = ?, origem = ?, data_deposito = ?
            WHERE id = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, deposito.getEmpresaId());
            stmt.setBigDecimal(2, deposito.getValor());
            stmt.setString(3, deposito.getOrigem());
            stmt.setTimestamp(4, new Timestamp(deposito.getDateDeposito().getTime()));
            stmt.setInt(5, idDeposito);

            stmt.executeUpdate();
            deposito.setId(idDeposito);

            return deposito;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating deposito with id " + idDeposito, e);
        }
    }

    @Override
    public void deletarDeposito(int idDeposito) {
        String sql = "DELETE FROM deposito WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idDeposito);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting deposito with id " + idDeposito, e);
        }
    }

    @Override
    public List<Deposito> listarDepositos() {
        String sql = "SELECT * FROM deposito ORDER BY id DESC";
        List<Deposito> lista = new ArrayList<>();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listing all depositos", e);
        }

        return lista;
    }

    @Override
    public List<Deposito> listarByEmpresaId(int empresaId) {
        String sql = "SELECT * FROM deposito WHERE empresa_id = ? ORDER BY id DESC";
        List<Deposito> lista = new ArrayList<>();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empresaId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listing depositos for empresa " + empresaId, e);
        }

        return lista;
    }

    private Deposito mapRow(ResultSet rs) throws SQLException {
        Deposito d = new Deposito();

        d.setId(rs.getInt("id"));
        d.setEmpresaId(rs.getInt("empresa_id"));
        d.setValor(rs.getBigDecimal("valor"));
        d.setOrigem(rs.getString("origem"));

        Timestamp ts = rs.getTimestamp("data_deposito");
        d.setDateDeposito(ts != null ? new Date(ts.getTime()) : null);

        return d;
    }
}
