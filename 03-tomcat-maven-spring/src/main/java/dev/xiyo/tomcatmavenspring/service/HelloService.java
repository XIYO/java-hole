package dev.xiyo.tomcatmavenspring.service;

import dev.xiyo.tomcatmavenspring.dao.HelloDao;
import dev.xiyo.tomcatmavenspring.repository.HelloRepository;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final HelloDao helloDao;

    public HelloService(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    public String sayHello() {
        return this.helloDao.sayHello();
    }
}
