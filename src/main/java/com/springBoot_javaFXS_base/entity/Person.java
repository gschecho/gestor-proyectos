package com.springBoot_javaFXS_base.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstName;
    private String lastName;
    private String position;
    private String phone;
    private String email;

    private String dni;
    private String iban;
    private boolean privateTransport;

    @ManyToMany
    @JoinTable(
            name="person_project",
            joinColumns = @JoinColumn(name ="person_id"),
            inverseJoinColumns = @JoinColumn(name="project_id")
    )
    List<Project> projects;


    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;



}
