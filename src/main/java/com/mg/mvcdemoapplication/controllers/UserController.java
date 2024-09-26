package com.mg.mvcdemoapplication.controllers;

import com.mg.mvcdemoapplication.entities.UserEntity;
import com.mg.mvcdemoapplication.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class UserController {

    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserController(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @GetMapping("/")
    public String welcome() {
        return "../static/welcome";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userEntityRepository.findAll());
        return "users";
    }

    @GetMapping("/add-user")
    public String addUser(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("userEntity", userEntity);
        return "add-user";
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("userEntity") UserEntity userEntity) {
        userEntity.setCreatedAt(LocalDateTime.now());
        userEntityRepository.save(userEntity);
        return "redirect:/users";
    }
}
