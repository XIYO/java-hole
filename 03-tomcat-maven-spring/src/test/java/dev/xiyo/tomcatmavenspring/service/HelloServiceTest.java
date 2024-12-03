package dev.xiyo.tomcatmavenspring.service;

import dev.xiyo.tomcatmavenspring.repository.HelloRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:application-context.xml") // XML 설정 로드
class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    void sayHello() {
        System.out.println(this.helloService.sayHello());
    }
}
