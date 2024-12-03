package dev.xiyo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "dev.xiyo")
public class AppConfig {

    {
        System.out.println("AppConfig created");
    }

    // 필요한 추가 설정이 있다면 여기에 작성
}
