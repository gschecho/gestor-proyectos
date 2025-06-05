package com.springBoot_javaFXS_base.repositories;

import com.springBoot_javaFXS_base.entity.Client;
import com.springBoot_javaFXS_base.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> getAllByClient(Client client);
    public List<Person> findAll();
    public List<Person> findByFirstName(String firstName);

}
