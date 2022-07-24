package ir.iamgeek.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBC {
    private JDBC(){
    }
    private static final BasicDataSource BASIC_DATA_SOURCE = new BasicDataSource();
    static {
        BASIC_DATA_SOURCE.setUrl("jdbc:oracle:@thin:localhost:1521:xe");
        BASIC_DATA_SOURCE.setUsername("fatemeh");
        BASIC_DATA_SOURCE.setPassword("myjava123");
    }

    public static Connection getConnection() throws SQLException {
       return BASIC_DATA_SOURCE.getConnection();
    }

}
