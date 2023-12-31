package io.miswah.resumebuilder.controller;


import io.miswah.resumebuilder.dto.SignupDTO;
import io.miswah.resumebuilder.models.Education;
import io.miswah.resumebuilder.models.Experience;
import io.miswah.resumebuilder.models.User;
import io.miswah.resumebuilder.models.UserProfile;
import io.miswah.resumebuilder.repository.UserProfileRepository;
import io.miswah.resumebuilder.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
public class AppController {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        SignupDTO newUser = new SignupDTO();
        model.addAttribute("user", newUser);
        return "signup";
    }


    @PostMapping("/signup")
    public String registerUserAccount(
            @ModelAttribute("user") @Valid SignupDTO userDto,
            HttpServletRequest request,
            Errors errors) {

        User newUser = new User(userDto.getUserName(), userDto.getPassword(), true, "USER", userDto.getEmail());

        userRepository.save(newUser);

        return "redirect:/edit";
    }

    @GetMapping("/edit")
    public String edit(Model model, Principal principal){
        UserProfile userProfile = getUserProfile(principal.getName());
        model.addAttribute("userId", principal.getName());
        model.addAttribute("userProfile", userProfile);
        return "profile-edit";
    }

    @PostMapping("/save")
    public String save(Model model, Principal principal, @ModelAttribute UserProfile userProfile, @RequestParam(required = false) String add){
        UserProfile savedUserProfile = getUserProfile(principal.getName());
        userProfile.setId(savedUserProfile.getId());
        userProfile.setUserName(savedUserProfile.getUserName());

        //Remove empty skills
        userProfile.getSkills().removeIf(String::isEmpty);
        //remove empty education
        userProfile.getEducationList().removeIf(Education::isEmpty);
        //remove empty experience
        userProfile.getExperienceList().removeIf(Experience::isEmpty);

        if("experience".equalsIgnoreCase(add)){
            userProfile.getExperienceList().add(new Experience());
        } else if ("education".equalsIgnoreCase(add)){
            userProfile.getEducationList().add(new Education());
        } else if ("skill".equalsIgnoreCase(add)){
            userProfile.getSkills().add("");
        }

        userProfileRepository.save(userProfile);
        System.out.println("Save updated data for user "+ userProfile.getUserName());

        return "redirect:/edit";
    }

    @GetMapping("/delete")
    public String delete(Model model, Principal principal, @RequestParam String type, @RequestParam int index){
        UserProfile userProfile = getUserProfile(principal.getName());
        if("experience".equalsIgnoreCase(type)){
            userProfile.getExperienceList().remove(index);
        } else if ("education".equalsIgnoreCase(type)){
            userProfile.getEducationList().remove(index);
        } else if ("skill".equalsIgnoreCase(type)){
            userProfile.getSkills().remove(index);
        }

        userProfileRepository.save(userProfile);
        System.out.println("Deleted "+type+" for user"+ userProfile.getUserName());

        return "redirect:/edit";

    }

    @PostMapping("/edit")
    public String postEdit(Model mode, Principal principal, @ModelAttribute UserProfile userProfile){
        UserProfile savedUserProfile = getUserProfile(principal.getName());
        userProfile.setId(savedUserProfile.getId());
        userProfile.setUserName(savedUserProfile.getUserName());

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

        return userProfile.orElseGet(UserProfile::new);

    }

    private static void removeEmptyEducation(List<Education> list) {
        // Define your condition here to check if the object is empty
        list.removeIf(Education::isEmpty);
    }

    private static void removeEmptyExperience(List<Experience> list) {
        // Define your condition here to check if the object is empty
        list.removeIf(Experience::isEmpty);
    }
}
