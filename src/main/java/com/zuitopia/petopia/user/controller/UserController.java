package com.zuitopia.petopia.user.controller;


import com.zuitopia.petopia.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log
@RequestMapping("/")
@AllArgsConstructor
public class UserController {
    public UserService userService;

    @GetMapping("/signup")
    public void getUserSignUp(Model model) {


        
    }




}
