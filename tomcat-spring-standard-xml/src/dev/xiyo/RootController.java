package dev.xiyo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/root")
public class RootController {

    {
        System.out.println("RootController created");
    }

    @RequestMapping
    public String index() {
        return "root";
    }
}
