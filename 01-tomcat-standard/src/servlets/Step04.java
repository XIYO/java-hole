package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Step 4: 매핑과 함께 /WEB-INF/ 하위 경로로 접근을 제한한 예제
@WebServlet("/step04")
public class Step04 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            // JSP에 전달할 데이터 설정
            req.setAttribute("message", "step04, WEB-INF");

            // JSP로 요청 포워딩
            req.getRequestDispatcher("/WEB-INF/step04.jsp").forward(req, resp);
        } catch (Exception e) {
            // 예외 발생 시 500 내부 서버 오류 응답
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }
}
