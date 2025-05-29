package com.springBoot_javaFXS_base.controllers;


import com.springBoot_javaFXS_base.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @FXML
    private Label label;

    @FXML
    private Button button;

    @FXML
    private void switchToPrimary() throws IOException{
        MainApp.setRoot(fxml:"main");
    }


    public void initialize() {
        label.setText("XXX");
    }
}
