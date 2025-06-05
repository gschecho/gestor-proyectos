package com.springBoot_javaFXS_base.service;

import com.springBoot_javaFXS_base.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;




}
