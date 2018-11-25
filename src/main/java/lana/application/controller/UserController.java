package lana.application.controller;

import lana.application.model.Group;
import lana.application.model.User;
import lana.application.service.GroupService;
import lana.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController implements Serializable {
    private UserService userService;
    private GroupService groupService;

    @Autowired
    public UserController(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
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
                        RedirectAttributes redirect) {
        if (checkUserAndGetId(user) >= 0) {
            int id = checkUserAndGetId(user);
            user = userService.findById(id);
            redirect.addFlashAttribute("user", user);
            return "redirect:/app/chat";
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
