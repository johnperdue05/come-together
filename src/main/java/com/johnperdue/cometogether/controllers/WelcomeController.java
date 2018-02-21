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
    @ResponseBody
    public String login(){
        return "Here's where you'll be able to login";
    }

    @RequestMapping(value="signup")
    @ResponseBody
    public String signup(){
        return "And here's where you'll be able to sign up!";
    }
}
