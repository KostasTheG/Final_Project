package com.techpro.project.controllers;

import com.techpro.project.entity.People;
import com.techpro.project.exceptions.UserNotFoundException;
import com.techpro.project.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @PostMapping("/people")
    People newPeople(@RequestBody People newPeople){
        return peopleRepository.save(newPeople);
    }

    @GetMapping("/people/{personId}")
    People getPeopleById(@PathVariable int personId){
        return peopleRepository.findById(personId).orElseThrow(()-> new UserNotFoundException(personId));
    }

    @GetMapping("/returnpeople")
    List<People> getAllPeople(){

        return peopleRepository.findAll();
    }

    @PutMapping("/people/{personId}")
    People updatePeople(@RequestBody People newPeople, @PathVariable int personId){
        return peopleRepository.findById(personId).map(people -> {
            people.setFirstName(newPeople.getFirstName());
            people.setLastName(newPeople.getLastName());
            people.setEmail(newPeople.getEmail());
            return peopleRepository.save(people);
        }).orElseThrow(()->new UserNotFoundException(personId));
    }


    @DeleteMapping("/people/{personId}")
    String deletePeople(@PathVariable int personId){
        if (!peopleRepository.existsById(personId)){
            throw new UserNotFoundException(personId);
        }
        peopleRepository.deleteById(personId);
        return "Deleted successfully!";
    }


}
