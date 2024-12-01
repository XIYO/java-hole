package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Step 2: 애너테이션을 사용하여 매핑한 서블릿 예제
@WebServlet("/step02")
public class Step02 extends Step01 {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 응답 타입과 인코딩 설정
        resp.setContentType("text/plain"); // MIME 타입 설정
        resp.setCharacterEncoding("UTF-8"); // 문자 인코딩 설정

        // 응답 본문 작성
        resp.getWriter().println("Hi, World!");
    }
}
