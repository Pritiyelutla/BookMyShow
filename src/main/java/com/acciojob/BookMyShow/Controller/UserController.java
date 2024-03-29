package com.acciojob.BookMyShow.Controller;

import com.acciojob.BookMyShow.Service.UserService;
import com.acciojob.BookMyShow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

     @PostMapping("/adduser")
    public String addUser(@RequestBody User user)
     {
         return userService.addUser(user);
     }
}
