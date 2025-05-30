package com.springBoot_javaFXS_base.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBoot_javaFXS_base.entity.Client;
import com.springBoot_javaFXS_base.entity.Person;
import com.springBoot_javaFXS_base.entity.Project;
import com.springBoot_javaFXS_base.repositories.ClientRepository;
import com.springBoot_javaFXS_base.repositories.PersonRepository;
import com.springBoot_javaFXS_base.repositories.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;


//CommandLineRunnes se ejecuta automaticmente al arrancar Spring
@Component
public class DataLoader implements CommandLineRunner {


    private final ClientRepository clientRepository;
    private final ProjectRepository projectRepository;
    private final PersonRepository personRepository;

    public DataLoader(ClientRepository clientRepository,ProjectRepository projectRepository, PersonRepository personRepository ) {
        this.clientRepository = clientRepository;
        this.projectRepository = projectRepository;
        this.personRepository =personRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        // Libreria Jackson para leer JSONS -
        ObjectMapper mapper = new ObjectMapper();
        // Adaptamos el mapper al formato pasado por el JSON
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));


        if (clientRepository.count() == 0) {
            InputStream isClients = getClass().getResourceAsStream("/clients.json");
            List<Client> clients = mapper.readValue(isClients, new TypeReference<List<Client>>() {});
            clientRepository.saveAll(clients);
            System.out.println("Clients loaded: " + clients.size());
        }

        if (projectRepository.count() == 0) {

            // leemos el archivo json
            InputStream isProjects = getClass().getResourceAsStream("/projects.json");

            //creamos la lista
            List<Project> projects = mapper.readValue(isProjects, new TypeReference<List<Project>>() {
            });

            projectRepository.saveAll(projects);
            System.out.println("Projects loaded: " + projects.size());
        }

        if (personRepository.count() == 0) {

            InputStream isPersons = getClass().getResourceAsStream("/persons.json");

            List<Person> persons = mapper.readValue(isPersons, new TypeReference<List<Person>>() {});

            // Para cada person, buscar y setear los proyectos con IDs válidos
            for (Person p : persons) {
                List<Project> projects = p.getProjects().stream()
                        .map(proj -> projectRepository.findById(proj.getId()).orElse(null))
                        .filter(Objects::nonNull)
                        .toList();

                p.setProjects(projects);
            }

            personRepository.saveAll(persons);
            System.out.println("Persons loaded: " + persons.size());
        }


    }

    }

