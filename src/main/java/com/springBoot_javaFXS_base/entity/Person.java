package com.springBoot_javaFXS_base.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String position;
    private String phone;
    private String email;

    private String dni;
    private String IBAN;
    private boolean privateTransport;

    @ManyToMany
    @JoinTable(
            name="person_project",
            joinColumns = @JoinColumn(name ="person_id"),
            inverseJoinColumns = @JoinColumn(name="project_id")
    )
    List<Project> projects;
}
