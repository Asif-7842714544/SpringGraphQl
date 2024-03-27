package com.example.GraphQl.repo;

import com.example.GraphQl.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
