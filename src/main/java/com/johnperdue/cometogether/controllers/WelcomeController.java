package com.johnperdue.cometogether.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("title", "Welcome!");
        return "welcome";
    }

    @RequestMapping(value="login")
    public String login(Model model){

        model.addAttribute("title", "Login");
        return "login";
    }

    @RequestMapping(value="signup")
    public String signup(Model model){

        model.addAttribute("title", "Signup");
        return "signup";
    }
}
