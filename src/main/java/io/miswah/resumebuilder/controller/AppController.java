package io.miswah.resumebuilder.controller;


import io.miswah.resumebuilder.models.UserProfile;
import io.miswah.resumebuilder.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
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
    public String edit(Model model, Principal principal){
        UserProfile userProfile = getUserProfile(principal.getName());
        model.addAttribute("userId", principal.getName());
        model.addAttribute("userProfile", userProfile);
        return "profile-edit";
    }

    @PostMapping("/edit")
    public String postEdit(Model mode, Principal principal, @ModelAttribute UserProfile userProfile){
        UserProfile savedUserProfile = getUserProfile(principal.getName());
        userProfile.setId(savedUserProfile.getId());
        userProfile.setUserName(savedUserProfile.getUserName());
//        userProfile.setSelectedTemplate(savedUserProfile.getSelectedTemplate());
        userProfileRepository.save(userProfile);
        System.out.println("Save updated data for user "+ userProfile.getUserName());
        return "redirect:/view/"+principal.getName();
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {

       UserProfile userProfile = getUserProfile(userId);

        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile);
        return "resume-templates/"+userProfile.getSelectedTemplate()+"/index";
    }



    private UserProfile getUserProfile (String userId){
        Optional<UserProfile> userProfile = userProfileRepository.findByUserName(userId);

        userProfile.orElseThrow(RuntimeException::new);

        return userProfile.get();
    }


}
