package com.example.GraphQl.repo;

import com.example.GraphQl.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders,Integer> {
}
