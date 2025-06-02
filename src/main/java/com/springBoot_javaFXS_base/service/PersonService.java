package com.springBoot_javaFXS_base.service;

import com.springBoot_javaFXS_base.entity.Person;
import com.springBoot_javaFXS_base.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAllPersons(){
        return personRepository.findAll();
    }
}
