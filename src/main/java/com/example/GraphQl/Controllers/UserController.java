package com.example.GraphQl.Controllers;

import com.example.GraphQl.Entities.User;
import com.example.GraphQl.Services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;

    @MutationMapping
    public User createUser(@Argument String username, @Argument String password, @Argument String email, @Argument String phone) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        return userServices.createUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @QueryMapping(name = "getUser")
    public User getUserById(@Argument int userId){
        return userServices.getUser(userId);
    }

    @MutationMapping(name = "deleteUser")
    public boolean deleteUser(@Argument int userId){
        return userServices.deleteUser(userId);
    }

}
