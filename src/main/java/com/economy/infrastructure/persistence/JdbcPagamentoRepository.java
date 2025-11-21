package com.economy.infrastructure.persistence;

import com.economy.domain.model.Pagamento;
import com.economy.domain.repository.PagamentoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPagamentoRepository implements PagamentoRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcPagamentoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Pagamento criarPagamento(Pagamento pagamento) {
        String sql = """
            INSERT INTO pagamento (proposta_id, empresa_id, empregado_id, valor, data_pagamento)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"id"})) {

            stmt.setInt(1, pagamento.getPropostaId());
            stmt.setInt(2, pagamento.getEmpresaId());
            stmt.setInt(3, pagamento.getEmpregadoId());
            stmt.setBigDecimal(4, pagamento.getValor());
            stmt.setTimestamp(5, new Timestamp(pagamento.getDataPagamento().getTime()));

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pagamento.setId(rs.getInt(1));
                }
            }

            return pagamento;

        } catch (SQLException e) {
            throw new RuntimeException("Error creating pagamento", e);
        }
    }

    // -----------------------------------------------------------
    // UPDATE
    // -----------------------------------------------------------
    @Override
    public Pagamento editarPagamento(Pagamento pagamento, int idPagamento) {
        String sql = """
            UPDATE pagamento
            SET proposta_id = ?, empresa_id = ?, empregado_id = ?, valor = ?, data_pagamento = ?
            WHERE id = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pagamento.getPropostaId());
            stmt.setInt(2, pagamento.getEmpresaId());
            stmt.setInt(3, pagamento.getEmpregadoId());
            stmt.setBigDecimal(4, pagamento.getValor());
            stmt.setTimestamp(5, new Timestamp(pagamento.getDataPagamento().getTime()));
            stmt.setInt(6, idPagamento);

            stmt.executeUpdate();
            pagamento.setId(idPagamento);

            return pagamento;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating pagamento " + idPagamento, e);
        }
    }

    // -----------------------------------------------------------
    // GET BY ID
    // -----------------------------------------------------------
    @Override
    public Pagamento getById(int pagamentoId) {
        String sql = "SELECT * FROM pagamento WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pagamentoId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving pagamento " + pagamentoId, e);
        }
    }

    // -----------------------------------------------------------
    // LIST BY EMPREGADO (USER)
    // -----------------------------------------------------------
    @Override
    public List<Pagamento> listarPagamentosPorEmpregadoId(int empregadoId) {
        String sql = "SELECT * FROM pagamento WHERE empregado_id = ? ORDER BY data_pagamento DESC";
        List<Pagamento> pagamentos = new ArrayList<>();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empregadoId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pagamentos.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listing pagamentos for empregado " + empregadoId, e);
        }

        return pagamentos;
    }

    // -----------------------------------------------------------
    // LIST BY EMPRESA
    // -----------------------------------------------------------
    @Override
    public List<Pagamento> listarPagamentosPorEmpresaId(int empresaId) {
        String sql = "SELECT * FROM pagamento WHERE empresa_id = ? ORDER BY data_pagamento DESC";
        List<Pagamento> pagamentos = new ArrayList<>();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empresaId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pagamentos.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listing pagamentos for empresa " + empresaId, e);
        }

        return pagamentos;
    }

    // -----------------------------------------------------------
    // INTERNAL MAPPER
    // -----------------------------------------------------------
    private Pagamento mapRow(ResultSet rs) throws SQLException {
        Pagamento p = new Pagamento();

        p.setId(rs.getInt("id"));
        p.setPropostaId(rs.getInt("proposta_id"));
        p.setEmpresaId(rs.getInt("empresa_id"));
        p.setEmpregadoId(rs.getInt("empregado_id"));
        p.setValor(rs.getBigDecimal("valor"));

        Timestamp ts = rs.getTimestamp("data_pagamento");
        p.setDataPagamento(ts != null ? new Date(ts.getTime()) : null);

        return p;
    }
}
