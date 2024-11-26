package dev.xiyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Controller
public class MappingInfoController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/mapping-info")
    public String getMappingInfo() {
        RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);

        Map<?, ?> handlerMethods = handlerMapping.getHandlerMethods();

        System.out.println("Spring Mappings:");
        handlerMethods.forEach((key, value) -> {
            System.out.println("URL Pattern: " + key);
            System.out.println("Handler Method: " + value);
            System.out.println("----------");
        });

        return "mapping-info";
    }
}
