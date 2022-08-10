package ir.iamgeek;

import ir.iamgeek.common.JDBC;
import ir.iamgeek.common.Spring;
import ir.iamgeek.entity.Person;
import ir.iamgeek.repository.PersonDA;

import java.sql.Connection;

public class Main {
    public static void main(String[] args){
        PersonDA personDA = (PersonDA) Spring.getBean("personDA");
        Person person = new Person();
        person.setId(1L).setName("fatemeh").setFamily("ghasemi").setAge(21);
        try{
            personDA.insert(person);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
