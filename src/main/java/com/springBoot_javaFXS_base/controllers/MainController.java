package com.springBoot_javaFXS_base.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @FXML
    private Label label;

    public void initialize() {
        label.setText("Hola desde JavaFX + Spring Boot");
    }
}
