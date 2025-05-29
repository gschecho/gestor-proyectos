package com.springBoot_javaFXS_base.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Person {

    @Id
    private long id;
    private String name;
    private String position;
    private String phone;
    private String email;

    private String dni;
    private String IBAN;
    private boolean privateTransport;

    @ManyToMany
    List<Project> projects;
}
