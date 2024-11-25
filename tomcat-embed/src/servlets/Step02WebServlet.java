package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Step02Servlet 클래스
 *
 * Step01Servlet을 상속받아 확장한 서블릿입니다.
 * 이 서블릿은 "/hi" URL로 요청을 처리하며, "Hi, World!"라는 메시지를 응답으로 반환합니다.
 *
 * <p>클래스 특징:</p>
 * <ul>
 *     <li>Step01Servlet의 기능을 기반으로 동작</li>
 *     <li>{@code @WebServlet} 어노테이션을 통해 URL 매핑을 정의</li>
 *     <li>{@code service()} 메서드를 오버라이드하여 요청 처리 로직 구현</li>
 * </ul>
 *
 * <p>URL 매핑:</p>
 * <ul>
 *     <li>"/hi" 경로로 매핑되어 클라이언트가 이 경로로 요청을 보낼 때 실행됩니다.</li>
 * </ul>
 *
 * <p>사용 예:</p>
 * <pre>
 * http://localhost:8080/hi
 * </pre>
 *
 * <p>요청이 위 URL로 들어오면, 브라우저는 "Hi, World!" 메시지를 출력합니다.</p>
 */
@WebServlet("/step02")
public class Step02WebServlet extends HttpServlet {

    /**
     * HTTP 요청을 처리하고 "Hi, World!" 메시지를 응답으로 반환합니다.
     *
     * @param req  클라이언트로부터의 HTTP 요청 객체
     * @param resp 클라이언트에게 보낼 HTTP 응답 객체
     *
     * @throws IOException 응답 출력 중 입출력 오류가 발생한 경우
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 응답 타입과 인코딩 설정
        resp.setContentType("text/plain"); // MIME 타입 설정
        resp.setCharacterEncoding("UTF-8"); // 문자 인코딩 설정

        // 응답 본문 작성
        resp.getWriter().println("Hi, World!");
    }
}
