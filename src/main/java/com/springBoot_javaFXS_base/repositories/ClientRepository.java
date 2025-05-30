package com.springBoot_javaFXS_base.repositories;

import com.springBoot_javaFXS_base.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


}
