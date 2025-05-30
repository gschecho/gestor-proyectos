package com.springBoot_javaFXS_base.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBoot_javaFXS_base.entity.Project;
import com.springBoot_javaFXS_base.repositories.ClientRepository;
import com.springBoot_javaFXS_base.repositories.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;


//CommandLineRunnes se ejecuta automaticmente al arrancar Spring
@Component
public class DataLoader implements CommandLineRunner {


    private final ClientRepository clientRepository;
    private final ProjectRepository projectRepository;

    public DataLoader(ClientRepository clientRepository,ProjectRepository projectRepository ) {
        this.clientRepository = clientRepository;
        this.projectRepository = projectRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        // Libreria Jackson para leer JSONS -
        ObjectMapper mapper = new ObjectMapper();
        // Adaptamos el mapper al formato pasado por el JSON
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));

        // leemos el archivo json
        InputStream isProjects = getClass().getResourceAsStream("/projects.json");

        //creamos la lista
        List<Project> projects = mapper.readValue(isProjects, new TypeReference<List<Project>>() {});

        projectRepository.saveAll(projects);
        System.out.println("Projects loaded: " + projects.size());

    }
}
