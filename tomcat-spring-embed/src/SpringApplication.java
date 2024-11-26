import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringApplication {
    public static void main(String[] args) throws Exception {
        // 임베디드 톰캣 초기화
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // 내부 접근 허용 (127.0.0.1)
        Connector connector = tomcat.getConnector();
        connector.setProperty("address", "127.0.0.1");

        // webapp 경로 설정
        String webappDir = "spring/web";
        tomcat.addWebapp("", new java.io.File(webappDir).getAbsolutePath());

        // Spring DispatcherServlet 설정
        tomcat.addServlet("", "dispatcher", createDispatcherServlet())
                .addMapping("/");

        tomcat.start();
        tomcat.getServer().await();
    }

    private static DispatcherServlet createDispatcherServlet() {
        // Spring 컨텍스트 초기화
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class); // WebConfig 등록

        return new DispatcherServlet(context);
    }
}
