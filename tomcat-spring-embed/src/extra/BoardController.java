package extra;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String home() {
        return "this is spring home";
    }

    @GetMapping("/board")
    public String hello() {
        return "Hello, JSP!";
    }
}