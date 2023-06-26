package com.techpro.project.service;

import com.techpro.project.entity.People;
import com.techpro.project.repository.PeopleRepository;

public class ServicepeopleImpl implements Servicepeople{

    private PeopleRepository peopleRepository;

    public People savePeople(People people) {

        return peopleRepository.save(people);
    }

    public People readPeople(int id) {
        return null;
    }
}
