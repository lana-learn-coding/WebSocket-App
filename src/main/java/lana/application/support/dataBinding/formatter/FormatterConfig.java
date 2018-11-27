package lana.application.support.dataBinding.formatter;


import lana.application.service.GroupService;
import lana.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FormatterConfig implements WebMvcConfigurer {
    private GroupService groupService;
    private UserService userService;

    @Autowired
    public FormatterConfig(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new GroupFormatter(groupService));
        registry.addFormatter(new UserFormatter(userService));
    }
}
