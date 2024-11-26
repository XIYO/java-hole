package dev.xiyo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "dev.xiyo") // 서비스 계층 스캔
public class AppConfig {

}
