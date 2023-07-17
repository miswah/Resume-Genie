package io.miswah.resumebuilder.controller;


import io.miswah.resumebuilder.models.UserProfile;
import io.miswah.resumebuilder.repository.UserProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Controller
public class AppController {

    @Autowired
    UserProfileRepository userProfileRepository;

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

        Optional<UserProfile> userProfile = userProfileRepository.findByUserName(userId);

        userProfile.orElseThrow(RuntimeException::new);


        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile.get());
        return "resume-templates/"+userProfile.get().getSelectedTemplate()+"/index";
    }
}
