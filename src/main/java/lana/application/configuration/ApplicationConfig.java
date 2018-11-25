package lana.application.configuration;

import lana.application.configuration.formatter.GroupFormatter;
import lana.application.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {
    @Autowired
    GroupService groupService;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new GroupFormatter(groupService));
    }
}
