package dev.xiyo.tomcatmavenspring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

    public String sayHello() {
        return "Hello, Spring!";
    }
}
