package servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 이 서블릿은 코드로 매핑되어 사용됩니다.
 * {@link Application#main(String[])} 메서드에서 "/step02" 경로로 매핑되었습니다.
 */
public class Step02 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 응답 타입과 인코딩 설정
        resp.setContentType("text/plain"); // MIME 타입 설정
        resp.setCharacterEncoding("UTF-8"); // 문자 인코딩 설정

        // 응답 본문 작성
        resp.getWriter().println("Hi, World!");
    }
}
