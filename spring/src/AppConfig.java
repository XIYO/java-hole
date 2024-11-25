import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "extra") // BoardDao가 위치한 패키지
public class AppConfig {
}
