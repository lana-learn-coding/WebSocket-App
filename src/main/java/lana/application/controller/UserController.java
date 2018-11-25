package lana.application.controller;

import lana.application.model.User;
import lana.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public User setUser() {
        return new User();
    }

    @GetMapping({"/", ""})
    public String RootHandle() {
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "user/login";
    }

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "user/signup";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute User user) {
        if (checkUserAndGetId(user) < 0) {
            userService.save(user);
            return "redirect:/user/login";
        }
        return "user/signup";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user,
                        Model model) {
        if (checkUserAndGetId(user) >= 0) {
            int id = checkUserAndGetId(user);
            //TODO: do sth with user(user below does not content password)
            user = userService.findById(id);
            return "index";
        }
        return "user/login";
    }

    private int checkUserAndGetId(User user) {
        List<User> userList = userService.findAllFull();
        for (User _user : userList) {
            if ((_user.getUsername().equals(user.getUsername()))
                    && (_user.getPassword().equals(user.getPassword()))) {
                return _user.getId();
            }
        }
        return -1;
    }
}
