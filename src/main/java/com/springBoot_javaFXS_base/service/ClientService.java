package com.springBoot_javaFXS_base.service;

import com.springBoot_javaFXS_base.entity.Client;
import com.springBoot_javaFXS_base.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAllClients(){
         List<Client> clients = clientRepository.findAll();
        logger.debug("Clients found: {}", clients);
        return clients;
    }


    public void save(Client client){
        clientRepository.save(client);
    }
}
