package ir.iamgeek.transactionManagement;

import ir.iamgeek.common.Monitor;

import java.sql.Connection;

public class EntityManager {

    public Connection connection() {
        Connection connection = null;
        Monitor.THREAD_LOCAL.set(connection);
        return connection;
    }

}
