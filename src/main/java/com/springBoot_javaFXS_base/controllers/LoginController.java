package com.springBoot_javaFXS_base.controllers;

import com.springBoot_javaFXS_base.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class LoginController {

    @FXML
    Button btnMain;

    @FXML
    Button btnClients;

    @FXML
    public void btnToMain(ActionEvent event) throws IOException {
        var separator = File.separator;
        System.out.println("Main");
        MainApp.setRoot("views/main");
    }

    @FXML
    public void btnToCients(ActionEvent event) throws IOException  {


            System.out.println("cliente");
            var separator = File.separator;
            MainApp.setRoot("views/clients");


    }

}
