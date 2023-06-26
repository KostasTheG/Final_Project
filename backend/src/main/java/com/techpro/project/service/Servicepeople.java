package com.techpro.project.service;

import com.techpro.project.entity.People;

public interface Servicepeople {

    People savePeople(People people);

    People readPeople(int id);

}
