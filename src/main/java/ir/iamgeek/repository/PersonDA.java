package ir.iamgeek.repository;

import ir.iamgeek.annotation.Persistence;
import ir.iamgeek.annotation.Transactional;
import ir.iamgeek.entity.Person;
import ir.iamgeek.transactionManagement.EntityManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class PersonDA {

    @Persistence
    private EntityManager entityManager;

    @Transactional
    public void insert(Person person) throws SQLException {
        Connection connection = entityManager.connection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into person(id, name, family, age) values (?,?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.setInt(4, person.getAge());
        preparedStatement.executeUpdate();
    }

    @Transactional
    public void delete(Connection connection, Person person) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete person where id=?");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.executeUpdate();
    }
}
