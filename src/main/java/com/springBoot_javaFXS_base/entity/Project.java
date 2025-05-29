package com.springBoot_javaFXS_base.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Project {

    @Id
    private long id;
    private String name;

    private String status;
    private Date date;

    @ManyToOne
    private Client client;

    @OneToMany
    private List<Person> crew;


}
