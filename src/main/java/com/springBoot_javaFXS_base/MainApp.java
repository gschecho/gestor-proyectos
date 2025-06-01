package com.springBoot_javaFXS_base;

import com.springBoot_javaFXS_base.utils.BaseDeDatos;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class MainApp extends Application {

    private static ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        // Lanza Spring Boot en segundo plano (antes de cargar la GUI)
        //init se lanza antes que start y asi springboot no bloquea el hilo principal que es el que utiliza javaFX
        // Otra opcion sería ejecutar spring en un nuevo hilo.
        context = new SpringApplicationBuilder(GestionSpringJavaFxApplication.class).run();
    }

    //ESCENA

    private static Scene scene;

    public static void setRoot(String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent  loadFXML(String fxml) throws IOException{
        //getResource lee directamente de la carpeta resources hay que especificar el path interior
        var separator = File.separator;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(separator + "fxml"+ separator + fxml + ".fxml"));
        loadSpringBootBeans(fxmlLoader);
        return fxmlLoader.load();
    }

    //FIN

    //Cargar bean Spring
    private static void loadSpringBootBeans(FXMLLoader loader){
        loader.setControllerFactory(context::getBean);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = loadFXML("login");
        scene = new Scene(root); // inicializa la escena

        primaryStage.setScene(scene); // asigna la escena al stage
        primaryStage.setTitle("App JavaFX + Spring Boot");
        primaryStage.show();
    }


    @Override
    public void stop() throws Exception {
        context.close();        // Cierra el contexto Spring
        Platform.exit();        // Cierra JavaFX
    }

    public static void main(String[] args) {
        launch(args);  // Este método llama a init() y luego a start()
    }


}
