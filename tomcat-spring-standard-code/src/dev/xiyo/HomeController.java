package dev.xiyo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/good-morning")
    public String hello() {
        return "good-morning";
    }
}
