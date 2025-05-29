package com.springBoot_javaFXS_base.logica;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BaseDeDatos {

private final JdbcTemplate jdbc;


// Esto carga en la MainApp que hace la inyeccion al crear el contexto de spring
public BaseDeDatos(JdbcTemplate jdbc){
    this.jdbc = jdbc;
}

    public List<String> obtenerNombres() {
        return jdbc.query("SELECT nombre FROM usuarios",
                (rs, rowNum) -> rs.getString("nombre"));
    }

    public void newUsuario(String nombre, String email){
    jdbc.update("INSERT INTO usuarios (nombre, email) VALUES ('" + nombre +"','" + email+"')");

        System.out.println("Usuario Añadido :"+nombre);
    }



}
