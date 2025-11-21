package com.economy.infrastructure.config;

import com.economy.domain.repository.*;
import com.economy.infrastructure.persistence.*;
import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DatabaseConfig {

    @ApplicationScoped
    public DatabaseConnection databaseConnection(AgroalDataSource dataSource) {
        return new DatabaseConnectionImpl(dataSource);
    }
    @ApplicationScoped
    public DepositoRepository depositoRepository(DatabaseConnection databaseConnection) {
        return new JdbcDepositoRepository(databaseConnection);
    }
    @ApplicationScoped
    public EmpregadoRepository empregadoRepository(DatabaseConnection databaseConnection) {
        return new JdbcEmpregadoRepository(databaseConnection);
    }
    @ApplicationScoped
    public EmpresaRepository empresaRepository(DatabaseConnection databaseConnection) {
        return new JdbcEmpresaRepository(databaseConnection);
    }
    @ApplicationScoped
    public PagamentoRepository pagamentoRepository(DatabaseConnection databaseConnection) {
        return new JdbcPagamentoRepository(databaseConnection);
    }
    @ApplicationScoped
    public PropostaRepository propostaRepository(DatabaseConnection databaseConnection) {
        return new JdbcPropostaRepository(databaseConnection);
    }
    @ApplicationScoped
    public SaqueRepository saqueRepository(DatabaseConnection databaseConnection) {
        return new JdbcSaqueRepository(databaseConnection);
    }

}
