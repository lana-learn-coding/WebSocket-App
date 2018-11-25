package lana.application.controller.chatController;

import lana.application.model.Group;
import lana.application.model.Message;
import lana.application.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/app/chat")
public class ChatController {
    @GetMapping({"", "/"})
    public String getChatMainPage(@ModelAttribute("user") User user,
                                  Model model) {
        List<Group> groupList = user.getGroups();
        model.addAttribute("user", user);
        model.addAttribute("groups", groupList);
        return "chat/main";
    }
}
