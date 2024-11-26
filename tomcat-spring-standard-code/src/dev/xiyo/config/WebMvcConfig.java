package dev.xiyo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    {
        System.out.println("WebMvcConfig created");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); // JSP 파일의 경로
        resolver.setSuffix(".jsp");           // JSP 파일의 확장자
        return resolver;
    }

    /**
     * 폴백, 경로 처리가 안될경우 기본 서블릿으로 처리
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); // 기본 서블릿 요청 처리 활성화
    }
}
