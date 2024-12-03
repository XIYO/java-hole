package dev.xiyo.tomcatmavenspring.controller;

import dev.xiyo.tomcatmavenspring.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return this.helloService.sayHello();
    }
}