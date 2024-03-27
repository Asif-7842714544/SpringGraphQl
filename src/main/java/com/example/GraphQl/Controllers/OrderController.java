package com.example.GraphQl.Controllers;

import com.example.GraphQl.Entities.Orders;
import com.example.GraphQl.Services.OrderServices;
import com.example.GraphQl.Services.UserServices;
import com.example.GraphQl.repo.OrdersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final UserServices userServices;
    private final OrderServices orderService;

    @MutationMapping(name = "createOrder")
    private Orders createOrder(
            @Argument String orderDetails,
            @Argument String address,
            @Argument int price,
            @Argument int userId) {
        Orders order = new Orders();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(userServices.getUser(userId));

        return orderService.save(order);
    }

    @QueryMapping(name = "getOrders")
    public List<Orders> getAllOrders(){
        return orderService.getOrders();
    }

    @QueryMapping(name = "getOrder")
    public Orders getOrderById(@Argument int orderId){
        return orderService.findById(orderId);
    }

    @MutationMapping(name = "deleteOrder")
    public boolean deleteOrderById(@Argument int orderId){
        return orderService.deleteById(orderId);
    }

}
