import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("extra")
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 정적 리소스 핸들러 추가
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 커스텀 메시지 컨버터 등록
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); // 뷰 파일의 기본 경로
        resolver.setSuffix(".jsp");           // 뷰 파일의 확장자
        return resolver;
    }

}
