package com.springBoot_javaFXS_base.controllers;

import com.springBoot_javaFXS_base.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;

@Component
public class ClientsController {

    @FXML
    private Button toMainView;

    @FXML
    private void switchToPrimary() throws IOException {
        var separator = File.separator;
        MainApp.setRoot("views" +separator+"main");
    }
}
