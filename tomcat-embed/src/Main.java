import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import servlets.*;

import java.io.File;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) throws LifecycleException {
        // Tomcat 인스턴스 생성 및 포트 설정
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // 외부 접근 허용 (127.0.0.1)
        Connector connector = tomcat.getConnector();
        connector.setProperty("address", "127.0.0.1");

        // JSP 파일 경로 설정 (web 디렉토리)
        StringJoiner webAppDir = new StringJoiner(File.separator);
        webAppDir.add(new File("tomcat-embed").getAbsolutePath());
        webAppDir.add("web");
        Context context = tomcat.addWebapp("/", webAppDir.toString());

        // 서블릿 추가 및 매핑
//        tomcat.addServlet("", "step01", new Step01WebXml()); // web.xml로 등록하기 때문에 필요 없으며, 중복 등록시에는 에러
//        tomcat.addServlet("", "step02", new Step02WebServlet()); // @WebServlet으로 등록하기 때문에 필요 없으며, 중복 등록시에는 에러
//        tomcat.addServlet("", "step04", new Step04WebInf()); // @WebServlet으로 등록하기 때문에 필요 없으며, 중복 등록시에는 에러
//        tomcat.addServlet("", "step05", new Step05Views()); // @WebServlet으로 등록하기 때문에 필요 없으며, 중복 등록시에는 에러
        tomcat.addServlet("", "step06", new Step06NonOption());

        // URL 매핑
//        context.addServletMappingDecoded("/step01", "step01");
//        context.addServletMappingDecoded("/step02", "step02");
//        context.addServletMappingDecoded("/step04", "step04");
//        context.addServletMappingDecoded("/step05", "step05");
        context.addServletMappingDecoded("/step06", "step06");

        // Tomcat 시작
        tomcat.start();
        System.out.println("Tomcat started on port 8080");
        tomcat.getServer().await();
    }
}
