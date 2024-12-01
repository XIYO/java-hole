package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Step 5: 보편적인 /WEB-INF/views 하위 경로로 JSP를 구성한 예제
@WebServlet("/step05")
public class Step05 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            // JSP에 전달할 데이터 설정
            req.setAttribute("message", "step05, WEB-INF/views");

            // JSP로 요청 포워딩
            req.getRequestDispatcher("/WEB-INF/views/step05.jsp").forward(req, resp);
        } catch (Exception e) {
            // 예외 발생 시 500 내부 서버 오류 응답
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }
}
