package extra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring")
public class SpringController {
    @GetMapping
    public String home() {
        return "this is spring home";
    }

    @GetMapping("/board")
    public String board() {
        return "this is spring board";
    }



}
