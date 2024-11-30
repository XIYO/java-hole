import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import servlets.Step02;
import servlets.Step04;
import servlets.Step05;

import java.io.File;
import java.sql.SQLException;
import java.util.StringJoiner;

/**
 * Tomcat Embedding Application
 */
public class Application {

    public static void main(String[] args) throws LifecycleException, SQLException {
        StringJoiner webAppDirJoiner = new StringJoiner(File.separator);
        webAppDirJoiner.add(System.getProperty("user.dir"));
        webAppDirJoiner.add("02-tomcat-embed");
        webAppDirJoiner.add("web");

        // Tomcat 인스턴스 생성 및 포트 설정
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // 내부 접근 허용 (127.0.0.1)
        Connector connector = tomcat.getConnector();
        connector.setProperty("address", "127.0.0.1");

        // 웹 애플리케이션 디렉토리 설정
        Context context = tomcat.addWebapp("", webAppDirJoiner.toString());

        // 서블릿 추가 및 매핑
//        tomcat.addServlet("", "step01", new Step01WebXml()); // web.xml로 등록하기 때문에 필요 없으며, 중복 등록시에는 에러
        tomcat.addServlet("", "step02", new Step02()); // @WebServlet 은 embed 에서는 자동 등록 되지 않는다.
        tomcat.addServlet("", "step04", new Step04());
        tomcat.addServlet("", "step05", new Step05());

        // URL 매핑
//        context.addServletMappingDecoded("/step01", "step01");
        context.addServletMappingDecoded("/step02", "step02");
        context.addServletMappingDecoded("/step04", "step04");
        context.addServletMappingDecoded("/step05", "step05");

        // 서블릿 등록
        StandardContext standardContext = (StandardContext) context;
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());

        // Tomcat 시작
        tomcat.start();
        System.out.println("Tomcat started on port 8080");
        tomcat.getServer().await();
    }
}
