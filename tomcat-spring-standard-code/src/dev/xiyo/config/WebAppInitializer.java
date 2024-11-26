package dev.xiyo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    {
        System.out.println("----------------------");
        System.out.println("WebAppInitializer created");
        System.out.println("----------------------");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 루트 애플리케이션 컨텍스트 설정 (예: 데이터베이스 설정 등)
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // DispatcherServlet에 대한 설정 클래스 (Spring MVC 설정)
        return new Class[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        // DispatcherServlet을 루트("/") 경로에 매핑
        return new String[] { "/" };
    }
}
