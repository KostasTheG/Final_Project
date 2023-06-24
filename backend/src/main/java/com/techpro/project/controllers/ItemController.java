package com.techpro.project.controllers;


import com.techpro.project.entity.Items;
import com.techpro.project.exceptions.UserNotFoundException;
import com.techpro.project.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ItemController {

    @Autowired
    private ItemsRepository itemsRepository;

    @PostMapping("/item")
    Items newItem(@RequestBody Items newItem) {

        return itemsRepository.save(newItem);
    }

    @GetMapping("/items")
    List<Items> getAllItems(){

        return itemsRepository.findAll();
    }

    @GetMapping("/item{id}")
    Items getUserById(@PathVariable int id){
        return itemsRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/item/{id}")
    Items updateItems(@RequestBody Items newItem, @PathVariable int id){
        return itemsRepository.findById(id).map(item -> {
            item.setItemId(newItem.getItemId());
            item.setName(newItem.getName());
            return itemsRepository.save(item);
        }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("item/{id}")
    String deleteUser(@PathVariable int id){
        if (!itemsRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        itemsRepository.deleteById(id);
        return "Item deleted successfully!";
    }

}
