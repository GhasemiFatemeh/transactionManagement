package ir.iamgeek.transactionManagement;

import ir.iamgeek.common.JDBC;

import java.sql.Connection;
import java.sql.SQLException;

public class EntityManager {
    public static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    public Connection connection() {
        Connection connection;
        try {
            connection = JDBC.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        THREAD_LOCAL.set(connection);
        return connection;
    }

}
