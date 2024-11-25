package extra;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/board")
public class BoardController extends HttpServlet {
    private final BoardService boardService;

    public BoardController() {
        this.boardService = new BoardService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> boards = boardService.getBoards();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Board List</h1>");
        out.println("<ul>");
        for (String board : boards) {
            out.println("<li>" + board + "</li>");
        }
        out.println("</ul>");
        out.println("<a href=\"/add-board.html\">Add Board</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        boardService.addBoard(title, content);
        resp.sendRedirect("/board");
    }
}