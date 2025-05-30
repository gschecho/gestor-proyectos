package com.springBoot_javaFXS_base.repositories;

import com.springBoot_javaFXS_base.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
