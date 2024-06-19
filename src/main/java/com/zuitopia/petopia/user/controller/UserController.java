package com.zuitopia.petopia.user.controller;


import com.zuitopia.petopia.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Log
@RequestMapping("/")
@AllArgsConstructor
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/check-email")
    public boolean checkEmail(@RequestParam String userEmail) {
        return userService.checkEmailExists(userEmail);
    }
}