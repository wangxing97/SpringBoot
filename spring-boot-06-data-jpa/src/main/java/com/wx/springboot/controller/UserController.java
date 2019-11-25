package com.wx.springboot.controller;
import com.wx.springboot.entity.User;
import com.wx.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userRepository.getOne(id);
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }

    @GetMapping("/userAll")
    public List<User> getAll(User user){
        return userRepository.findAll();
    }

    @GetMapping("/deleteuser")
    public String deleteUser(@RequestParam("id") Integer id){
        userRepository.deleteById(id);
        return "redirect:/userAll";
    }

}
