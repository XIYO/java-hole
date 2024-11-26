package dev.xiyo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodEveningController {

    {
        System.out.println("GoodEveningController created");
    }

    @GetMapping("/good-evening")
    public String goodEvening() {
        return "good evening, Spring!";
    }
}
