package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Step05Views 클래스
 *
 * <p>"/hell" URL로 매핑된 서블릿으로, HTTP GET 요청을 처리합니다.
 * 요청에 대해 데이터를 JSP로 전달하고 해당 JSP를 클라이언트에 렌더링하여 응답합니다.</p>
 *
 * <h2>클래스 주요 특징:</h2>
 * <ul>
 *     <li>{@link HttpServlet}을 상속하여 서블릿 기본 기능 제공</li>
 *     <li>{@code @WebServlet} 어노테이션을 사용하여 "/hell" 경로로 매핑</li>
 *     <li>JSP로 데이터를 전달하고 클라이언트에 렌더링된 결과를 반환</li>
 * </ul>
 *
 * <h2>URL 매핑:</h2>
 * <ul>
 *     <li>경로: <strong>"/hell"</strong></li>
 *     <li>"/hell" 경로로 들어온 요청을 이 서블릿이 처리합니다.</li>
 * </ul>
 *
 * <h2>사용 방법:</h2>
 * <pre>
 * 브라우저에서 다음 URL로 접근하세요:
 * http://localhost:8080/hell
 * </pre>
 *
 * <h2>응답 내용:</h2>
 * <p>이 서블릿은 데이터를 JSP에 전달한 뒤 렌더링된 HTML 페이지를 응답으로 반환합니다.</p>
 */
@WebServlet("/step05")
public class Step05Views extends HttpServlet {
    /**
     * HTTP GET 요청 처리 메서드
     *
     * <p>"/hell" URL 경로로 들어온 GET 요청을 처리합니다. 요청 데이터를 JSP에 전달한 뒤,
     * JSP를 클라이언트에 렌더링하여 응답으로 반환합니다.</p>
     *
     * <h3>기능:</h3>
     * <ul>
     *     <li>JSP에 전달할 데이터를 {@code req.setAttribute()}를 통해 설정</li>
     *     <li>{@code RequestDispatcher}를 사용해 JSP로 요청을 포워딩</li>
     *     <li>예외 발생 시 HTTP 500 에러를 클라이언트에 반환</li>
     * </ul>
     *
     * @param req  클라이언트로부터의 HTTP 요청 객체
     * @param resp 클라이언트에게 보낼 HTTP 응답 객체
     *
     * @throws IOException 입출력 처리 중 오류가 발생한 경우
     */
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
