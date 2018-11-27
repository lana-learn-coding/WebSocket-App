package lana.application.support.dataBinding.formatter;

import lana.application.model.User;
import lana.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class UserFormatter implements Formatter<User> {

    private UserService userService;

    @Autowired
    public UserFormatter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User parse(String text, Locale locale) throws ParseException {
        try {
            int id = Integer.parseInt(text);
            return userService.findFullById(id);
        } catch (Throwable e) {
            return null;
        }
    }

    @Override
    public String print(User object, Locale locale) {
        return object.getId() + "-" + object.getUsername();
    }
}
