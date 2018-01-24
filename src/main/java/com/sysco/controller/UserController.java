package com.sysco.controller;

import com.sysco.model.User;
import com.sysco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/Users", method = RequestMethod.GET)
    public List<User> listUsers(Model model) {
//        model.addAttribute("User", new User());
//        model.addAttribute("listUsers", this.userService.listUsers());
        return this.userService.listUsers();
    }

    //For add and update User both
    @RequestMapping(value= "/User/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("User") User p){

        if(p.getId() == 0){
            //new User, add it
            this.userService.addUser(p);
        }else{
            //existing User, call update
            this.userService.updateUser(p);
        }

        return "redirect:/Users";

    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){

        this.userService.removeUser(id);
        return "redirect:/Users";
    }

    @RequestMapping("/edit/{id}")
    public User editUser(@PathVariable("id") int id, Model model){
//        model.addAttribute("User", this.userService.getUserById(id));
//        model.addAttribute("listUsers", this.userService.listUsers());
        return this.userService.getUserById(id);
    }
}
