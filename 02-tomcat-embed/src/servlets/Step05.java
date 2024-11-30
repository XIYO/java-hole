package servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 이 서블릿은 코드로 매핑되어 사용됩니다.
 * {@link Application#main(String[])} 메서드에서 "/step02" 경로로 매핑되었습니다.
 */
public class Step05 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            // JSP에 전달할 데이터 설정
            req.setAttribute("message", "step05, /web/WEB-INF/views/step05.jsp"); // JSP에 전달할 데이터 설정

            // JSP로 요청 포워딩
            req.getRequestDispatcher("/WEB-INF/views/step05.jsp").forward(req, resp); // JSP로 포워딩
        } catch (Exception e) {
            // 예외 발생 시 500 내부 서버 오류 응답
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }
}
