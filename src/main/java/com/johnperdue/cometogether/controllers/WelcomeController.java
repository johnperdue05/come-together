package com.johnperdue.cometogether.controllers;

import com.johnperdue.cometogether.models.State;
import com.johnperdue.cometogether.models.Project;
import com.johnperdue.cometogether.models.User;
import com.johnperdue.cometogether.models.data.ProjectDao;
import com.johnperdue.cometogether.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ProjectDao projectDao;

    User activeUser;

    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("title", "Welcome!");
        model.addAttribute("activeUser", activeUser);
        return "welcome";
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String login(Model model){

        model.addAttribute("title", "Login");
        model.addAttribute("activeUser", activeUser);
        return "login";
    }
    @RequestMapping(value="login", method = RequestMethod.POST)
    public String processLogin(Model model, @RequestParam String username, @RequestParam String password){
        ArrayList<User> users = (ArrayList<User>) userDao.findAll();
        model.addAttribute("title", "Login");

        for (User user : users){
            String uName = user.getUsername();
            String pass = user.getPassword();
            if (uName.equals(username) && pass.equals(password)){
                user.setActive(true);
                activeUser = user;
                model.addAttribute("activeUser", activeUser);
                return "welcome";
            }
        }
        model.addAttribute("activeUser", activeUser);
        return "redirect:/";
    }
    @RequestMapping(value="logout")
    public String logout(Model model){
        model.addAttribute("title", "Logout");
        activeUser.setActive(false);
        return "logout";
    }

    @RequestMapping(value="signup", method = RequestMethod.GET)
    public String displaySignupForm(Model model){

        model.addAttribute("title", "Signup");
        model.addAttribute("activeUser", activeUser);
        model.addAttribute(new User());
        model.addAttribute("states", State.values());

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
            activeUser = newUser;
            userDao.save(newUser);
            model.addAttribute("title", "Welcome!");
            return "welcome";
        }else {
            return "signup";
        }
    }
    //TODO:  Figure out why the drop button isn't working right
    //TODO:  Fix State display.
    @RequestMapping(value="user/{userId}", method = RequestMethod.GET)
    public String viewUserProfile(Model model, @PathVariable int userId){
        User aUser = userDao.findOne(userId);
        model.addAttribute("title", "User Profile");
        model.addAttribute("activeUser", activeUser);
        model.addAttribute("user", aUser);
        return "user";
    }
    //TODO: Get post form to display
    @RequestMapping(value="post", method = RequestMethod.GET)
    public String displayPostForm(Model model){
        model.addAttribute("title", "Create a Project");
        model.addAttribute("activeUser", activeUser);
        model.addAttribute(new Project());

        return "post";
    }
    @RequestMapping(value="post", method = RequestMethod.POST)
    public String processPostForm(@ModelAttribute @Valid Project newProject, Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create a Project");
            model.addAttribute("activeUser", activeUser);
            return "post";
        }

        User currentUser=userDao.findOne(activeUser.getId());
        currentUser.addProject(newProject);
        projectDao.save(newProject);
        userDao.save(currentUser);
        model.addAttribute("title", "Post Saved!");
        model.addAttribute("activeUser", activeUser);
        return "welcome";
    }
    @RequestMapping(value="view/{postId}", method = RequestMethod.GET)
    public String processViewForm(@PathVariable int postId, Model model){
        Project aProject = projectDao.findOne(postId);
        model.addAttribute("title", aProject.getTitle());
        model.addAttribute("activeUser", activeUser);
        model.addAttribute("project", aProject);
        return "view";
    }
}
