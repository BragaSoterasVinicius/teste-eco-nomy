package com.economy.infrastructure.persistence;

import io.agroal.api.AgroalDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionImpl implements DatabaseConnection {
    private final DataSource dataSource;

    public DatabaseConnectionImpl(AgroalDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
