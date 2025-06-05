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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;

    private String status;
    private Date dateStart;

    private Date deadline;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(mappedBy = "projects")
    private List<Person> crew;



    private enum status{
        BRIEF,
        PRESUPUESTADO,
        GUION,
        PRODUCCIÓN,
        POSTPRODUCCIÓN,
        FINALIZADO,
        ENTRGADO
    };
}
