package com.example.GraphQl.Services;

import com.example.GraphQl.Entities.User;
import com.example.GraphQl.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserRepo userRepo;

    //    creating user
    public User createUser(User user) {
        return userRepo.save(user);
    }

    //    getting all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    //    getting a single user
    public User getUser(int userId) {
        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("user not found for id " + userId));
    }

    //    updating user
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    //    deleting a user
    public boolean deleteUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("user not found for id " + userId));
        userRepo.delete(user);
        return true;
    }

}
