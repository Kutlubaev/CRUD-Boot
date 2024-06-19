package ru.kutlubaev.boot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kutlubaev.boot.entity.User;
import ru.kutlubaev.boot.service.UserService;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/")
    public ModelAndView getAllUsers() {
        List<User> users = userService.getAll();
        ModelAndView modelAndView = new ModelAndView("allUsers");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage(@RequestParam("id") int id) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView("editPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("editPage");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/");
        userService.edit(user);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("addPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("addPage");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/");
        userService.add(user);
        return modelAndView;
    }

    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        User user = userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }

}
