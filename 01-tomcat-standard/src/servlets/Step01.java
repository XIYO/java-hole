package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Step 1: XML 기반으로 매핑된 서블릿 예제
public class Step01 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 응답 내용 설정
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        // 응답 메시지 출력
        resp.getWriter().println("Hello, World!");
    }
}
