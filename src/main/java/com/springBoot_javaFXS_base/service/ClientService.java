package com.springBoot_javaFXS_base.service;

import com.springBoot_javaFXS_base.entity.Client;
import com.springBoot_javaFXS_base.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }


    public void save(Client client){
        clientRepository.save(client);
    }
}
