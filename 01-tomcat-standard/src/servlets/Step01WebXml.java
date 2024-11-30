package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Step01Servlet 클래스
 *
 * 간단한 서블릿으로 HTTP 요청을 처리하고, "Hello, World!" 응답을 반환합니다.
 *
 * <p>이 서블릿은 web.xml에 매핑되어 사용됩니다. 매핑 정보는 아래 경로에서 확인할 수 있습니다:</p>
 *
 * <p>클래스 주요 기능:</p>
 * <ul>
 *     <li>HTTP 요청 수신</li>
 *     <li>간단한 "Hello, World!" 메시지 응답</li>
 * </ul>
 *
 * <p>사용 예:</p>
 * <pre>
 * 1. 웹 브라우저에서 서블릿 매핑 URL로 접근합니다.
 * 2. 서블릿이 "Hello, World!" 메시지를 반환합니다.
 * </pre>
 */
public class Step01WebXml extends HttpServlet {

    /**
     * HTTP 요청을 처리하고 응답을 반환하는 메서드입니다.
     *
     * @param req  클라이언트로부터의 HTTP 요청 객체
     * @param resp 클라이언트에게 보낼 HTTP 응답 객체
     *
     * @throws ServletException 서블릿에서 처리 중 에러가 발생한 경우
     * @throws IOException      입출력 에러가 발생한 경우
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 응답 내용 설정
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        // 응답 메시지 출력
        resp.getWriter().println("Hello, World!");
    }
}
