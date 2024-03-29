package com.acciojob.BookMyShow.Service;

import com.acciojob.BookMyShow.Repository.UserRepository;
import com.acciojob.BookMyShow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public String addUser(User user)
    {

        userRepository.save(user);

        return "User had been added to the db "+user.getUserId();
    }

}
