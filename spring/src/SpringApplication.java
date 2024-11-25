import extra.BoardController;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
import java.util.StringJoiner;

public class SpringApplication {
    public static void main(String[] args) throws LifecycleException {
        // 스프링 컨텍스트 초기화
        AnnotationConfigWebApplicationContext  webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(AppConfig.class);

        // Tomcat 인스턴스 생성 및 포트 설정
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // 외부 접근 허용 (127.0.0.1)
        Connector connector = tomcat.getConnector();
        connector.setProperty("address", "127.0.0.1");

        // JSP 파일 경로 설정 (web 디렉토리)
        StringJoiner webAppDir = new StringJoiner(File.separator);
        webAppDir.add(new File("spring").getAbsolutePath());
        webAppDir.add("web");
        Context context = tomcat.addWebapp("/", webAppDir.toString());

        // Tomcat 시작
        tomcat.start();
        System.out.println("Tomcat started on port 8080");
        tomcat.getServer().await();
    }
}
