package com.bootapp.springbootapplication.controller;

import com.bootapp.springbootapplication.accessingdatamysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bootapp.springbootapplication.accessingdatamysql.User;

@Controller
@RequestMapping("")
public class MainController {
    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public @ResponseBody String addNewUser(@RequestParam(value="name",required = false,defaultValue = "def") String name,
                                          @RequestParam(value="email",required = false,defaultValue = "def")String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }
    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
