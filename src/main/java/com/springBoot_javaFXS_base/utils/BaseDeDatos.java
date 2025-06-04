/*
package com.springBoot_javaFXS_base.utils;


import java.util.List;


@Repository
public class BaseDeDatos {

private final JdbcTemplate jdbc;


// Esto carga en la MainApp que hace la inyeccion al crear el contexto de spring
public BaseDeDatos(JdbcTemplate jdbc){
    this.jdbc = jdbc;
}

    public List<String> obtenerNombres() {
        return jdbc.query("SELECT first_name FROM persons",
                (rs, rowNum) -> rs.getString("first_name"));
    }

    /*
   // public void newUsuario(String nombre, String email){
   // jdbc.update("INSERT INTO persons (nombre, email) VALUES ('" + nombre +"','" + email+"')");
   //   System.out.println("Usuario Añadido :"+nombre);
   // }
}
*/