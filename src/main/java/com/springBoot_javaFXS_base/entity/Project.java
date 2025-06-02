package com.springBoot_javaFXS_base.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    private String status;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(mappedBy = "projects")
    private List<Person> crew;


}
