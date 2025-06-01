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
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String nif;

    private String number;

    @OneToMany(mappedBy = "client")
    List<Project> projects;

    @OneToMany(mappedBy = "client")
    List<Person> contacts;
}
