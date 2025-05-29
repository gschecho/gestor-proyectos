package com.springBoot_javaFXS_base;

import com.springBoot_javaFXS_base.logica.BaseDeDatos;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class MainApp extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        // Lanza Spring Boot en segundo plano (antes de cargar la GUI)
        //init se lanza antes que start y asi springboot no bloquea el hilo principal que es el que utiliza javaFX
        // Otra opcion sería ejecutar spring en un nuevo hilo.
        context = new SpringApplicationBuilder(GestionSpringJavaFxApplication.class).run();
    }

    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carga FXML con el controlador inyectado por Spring
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        loader.setControllerFactory(context::getBean);
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("App JavaFX + Spring Boot");
        primaryStage.show();
    }*/

    @Override
    public void start(Stage stage) {

        // Ejemplo de uso de JdbcTemplate desde el contexto Spring
        BaseDeDatos repo = context.getBean(BaseDeDatos.class);

        repo.newUsuario("Gonzalo", "gschecho@correo.com");


        System.out.println(repo.obtenerNombres());

        List<String> test = repo.obtenerNombres();

        String test2 = test.get(0);


        final int WIDTH = 600;
        final int HEIGHT = 400;




        Label label = new Label("¡Hola desde JavaFX sin FXML!");
        label.setLayoutX(100); // posición horizontal
        label.setLayoutY(150); // posición vertical

        Label label2 = new Label(   test2);
        label.setLayoutX(150); // posición horizontal
        label.setLayoutY(200); // posición vertical

        Pane root = new Pane(label, label2); // permite posición absoluta

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Aplicación JavaFX");
        stage.show();
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
