package com.johnperdue.cometogether.controllers;

//import com.johnperdue.cometogether.models.State;
//import com.johnperdue.cometogether.models.Project;
import com.johnperdue.cometogether.models.User;
//import com.johnperdue.cometogether.models.data.ProjectDao;
import com.johnperdue.cometogether.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class WelcomeController {

    @Autowired
    private UserDao userDao;
    //@Autowired
    //private ProjectDao projectDao;

    //User activeUser;

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

    @RequestMapping(value="signup", method = RequestMethod.GET)
    public String displaySignupForm(Model model){

        model.addAttribute("title", "Signup");
        model.addAttribute(new User());
        /* model.addAttribute("states", State.values()); */

        return "signup";
    }
    @RequestMapping(value="signup", method = RequestMethod.POST)
    public String processSignupForm(@ModelAttribute @Valid User newUser, Errors errors, @RequestParam String verify, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Signup");
            return "signup";
        }
        String password = newUser.getPassword();
        if (password.equals(verify)){
            newUser.setActive(true);
            //activeUser = newUser;
            userDao.save(newUser);
            model.addAttribute("title", "Welcome!");
            return "redirect:";
        }else {
            return "signup";
        }
    }
    /*@RequestMapping(value="post", method = RequestMethod.GET)
    public String displayPostForm(Model model, User activeUser){
        model.addAttribute("title", "Create a Project");
        //model.addAttribute("user", activeUser);
        model.addAttribute(new Project());

        return "post";
    }*/
    /*@RequestMapping(value="post", method = RequestMethod.POST)
    public String processPostForm(@ModelAttribute @Valid Project newProject, Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create a Project");
            return "post";
        }
        projectDao.save(newProject);
        return "welcome";
    }*/

}
