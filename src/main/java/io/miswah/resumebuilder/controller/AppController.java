package io.miswah.resumebuilder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class AppController {

    @GetMapping("/home")
    public String home(){
        return "Hello Home";
    }


    @GetMapping("/edit")
    public String edit(){
        return "Edit page";
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
        model.addAttribute("userId", userId);
        return "resume-templates/2/index";
    }
}
