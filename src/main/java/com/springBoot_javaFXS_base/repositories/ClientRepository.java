package com.springBoot_javaFXS_base.repositories;

import com.springBoot_javaFXS_base.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {


}
