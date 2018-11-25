package lana.application.controller;

import lana.application.model.Message;
import lana.application.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {
    @Autowired
    MessageService messageService;
    @GetMapping("/")
    public String rootHandle() {
        return "redirect:/user";
    }
    @GetMapping("/test")
    public String testURL(@ModelAttribute Message message){
        return "index";
    }
    @PostMapping("/test")
    public String test(@ModelAttribute Message message){
        messageService.save(message);
        return "index";
    }
}
