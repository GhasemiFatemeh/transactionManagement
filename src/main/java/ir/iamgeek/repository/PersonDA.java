package ir.iamgeek.repository;

import ir.iamgeek.annotation.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDA {
    @Transactional
    public void insert(){
        System.out.println("hi! you did it!!");
    }
}
