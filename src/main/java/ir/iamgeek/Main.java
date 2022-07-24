package ir.iamgeek;

import ir.iamgeek.common.Spring;
import ir.iamgeek.repository.PersonDA;

public class Main {
    public static void main(String[] args) {
        PersonDA personDA = (PersonDA) Spring.getBean("personDA");
        personDA.insert();
    }
}
