package lana.application.controller;

import lana.application.model.Group;
import lana.application.model.Message;
import lana.application.model.User;
import lana.application.service.GroupService;
import lana.application.service.MessageService;
import lana.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RootController {
    private MessageService messageService;
    private GroupService groupService;
    private UserService userService;

    @Autowired
    public void setRoot(MessageService messageService,
                        GroupService groupService,
                        UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
        this.groupService = groupService;
    }


    //TODO: rootController are now for test, must rewrite
    //---------------------------------------------
    @GetMapping("/")
    public String rootHandle() {
        return "redirect:/user";
    }

    @GetMapping("/test")
    public String testURL(@ModelAttribute Message message) {
        return "index";
    }

    @PostMapping("/test")
    public String test(@ModelAttribute Message message) {
        messageService.save(message);
        return "index";
    }
}
