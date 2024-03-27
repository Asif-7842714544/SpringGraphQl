package com.example.GraphQl.Services;

import com.example.GraphQl.Entities.Orders;
import com.example.GraphQl.repo.OrdersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServices {

    private final OrdersRepo ordersRepo;

    public Orders save(Orders order) {
        return ordersRepo.save(order);
    }

    public List<Orders> getOrders() {
        return ordersRepo.findAll();
    }

    public Orders findById(int orderId) {
        return ordersRepo.findById(orderId).orElseThrow(() -> new RuntimeException("No such id: " + orderId));
    }

    public boolean deleteById(int orderId) {
        Orders order = ordersRepo.findById(orderId).orElseThrow(() -> new RuntimeException("No such id: " + orderId));
        ordersRepo.delete(order);
        return true;
    }


}
