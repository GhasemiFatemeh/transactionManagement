package ir.iamgeek.repository;

import ir.iamgeek.annotation.Transactional;
import ir.iamgeek.common.JDBC;
import ir.iamgeek.entity.Person;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class PersonDA {
    @Transactional
    public void insert(Connection connection, Person person) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into person(id, name, family, age) values (?,?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.setInt(4, person.getAge());
    }

    @Transactional
    public void delete(Connection connection, Person person) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("delete person where id=?");
        preparedStatement.setLong(1, person.getId());
    }
}
