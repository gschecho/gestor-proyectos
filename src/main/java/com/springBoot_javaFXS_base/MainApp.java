package com.springBoot_javaFXS_base;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class MainApp extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        // Lanza Spring Boot en segundo plano (antes de cargar la GUI)
        context = new SpringApplicationBuilder(GestionSpringJavaFxApplication.class).run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carga FXML con el controlador inyectado por Spring
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        loader.setControllerFactory(context::getBean);
        primaryStage.setScene(new Scene(loader.load()));
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
