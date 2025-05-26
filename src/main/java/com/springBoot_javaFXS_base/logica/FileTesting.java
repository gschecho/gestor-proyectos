package com.springBoot_javaFXS_base.logica;

import org.springframework.web.util.UriBuilder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTesting {
    public static void main(String[] args) {

        Path myPath = Paths.get("");
        Path otro = Paths.get("some","path", "archivo.txt");

        //Home dir
        System.getProperty("user.home");

        //Path del programa

        var dir= System.getProperty("user.dir");
        System.out.println(dir);

        //Path alguna carpeta

        var imagenes = Paths.get(System.getProperty("user.home"), "Pictures");

        System.out.println(System.getProperty("home"));

        // eliminar archivo
        //Files.deleteIfExists("PATH");

        //Rename File
        File archivo = new File(System.getProperty("user.home") + File.pathSeparator+ "Documents" + File.pathSeparator+ "test.txt" );
        File archivoConOtroNombre = new File(System.getProperty("user.home") + "/Documents/" + "eliminame.txt" );

        archivo.renameTo(archivoConOtroNombre);



        //// NESTED

        File TEMP_DIRECTORY = new File(System.getProperty("java.io.tmpdir"));

        File newDirectory = new File(TEMP_DIRECTORY, "new_directory");

        System.out.println(newDirectory.exists());
        if( newDirectory.exists() == false){
            newDirectory.mkdir();
        }
        System.out.println(newDirectory.exists());
        System.out.println(newDirectory.getAbsolutePath());
        if(newDirectory.exists()== true){
            newDirectory.deleteOnExit();
        }




       // assertFalse(newDirectory.exists());
       // assertTrue(newDirectory.mkdir());



    }
}
