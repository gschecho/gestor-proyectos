package com.springBoot_javaFXS_base;

//import com.springBoot_javaFXS_base.utils.BaseDeDatos;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
        //No hay que utilizar en el loader ya que utiliza / en la ruta
        var separator = File.separator;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource( "/fxml/" + fxml + ".fxml"));
        loadSpringBootBeans(fxmlLoader);
        // Spring inyecta el controlador asi no hace falta escribirlo en FXML.
        // Importante
        fxmlLoader.setControllerFactory(context::getBean);
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


        primaryStage.setOnCloseRequest( event -> {
            event.consume();
            logout(primaryStage);

        });




    }



    private boolean confirmarSalida() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir de la aplicación");
        alert.setHeaderText("Estás a punto de salir");
        alert.setContentText("¿Deseas salir de la aplicación?");
        return alert.showAndWait().filter(response -> response == ButtonType.OK).isPresent();
    }

    private void logout(Stage stage) {
        if (confirmarSalida()) {
            System.out.println("Cerrando...");
            stage.close();
        }
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
