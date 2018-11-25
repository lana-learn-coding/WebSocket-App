package lana.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String rootHandle() {
        return "redirect:/user";
    }
    @GetMapping("/test")
    public String testURL(){
        return "index";
    }
}
