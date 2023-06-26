package com.techpro.project.controllers;


import com.techpro.project.entity.Orders;
import com.techpro.project.exceptions.UserNotFoundException;
import com.techpro.project.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @PostMapping("/order")
    Orders NewOrder(@RequestBody Orders newOrder){
        return ordersRepository.save(newOrder);
    }

    @GetMapping("/orders")
    List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    @GetMapping("/order/{id}")
    Orders getOrderById(@PathVariable int id){
        return ordersRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/order/{id}")
    String deletePeople(@PathVariable int id){
        if (!ordersRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        ordersRepository.deleteById(id);
        return "Deleted successfully!";
    }


}
