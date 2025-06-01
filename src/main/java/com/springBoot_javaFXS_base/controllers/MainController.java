package com.springBoot_javaFXS_base.controllers;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.springBoot_javaFXS_base.MainApp;
import com.springBoot_javaFXS_base.entity.Project;
import com.springBoot_javaFXS_base.utils.BaseDeDatos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class MainController {

    @Autowired
    BaseDeDatos bbdd;

    @FXML
    private Button proyectosBtnNuevoProyecto;

    @FXML
    private Button btnClients;

    @FXML
    private Label welcomeText;

    @FXML
    private void switchToPrimary() throws IOException {
        MainApp.setRoot("main");
    }

    // VISTA TABLA PROYECTOS
    @FXML
    private TableView<String> proyectosTableView;

    @FXML
    private TableColumn<String, String> proyectosTableName;


    private ObservableList<String> project;


    @FXML
    private void onClicProyectosBtnNuevoProyecto(ActionEvent evento) {
        welcomeText.setText("Botón apretado");
        // Aquí puedes poner cualquier lógica: cambiar vista, mostrar alerta, etc.
    }

    @FXML
    private void onClickBtnClients(ActionEvent evento) throws IOException {
        System.out.println("cliente");
        var separator = File.separator;
        MainApp.setRoot("views" +separator+"clients");

    }




    @FXML
    private void populateTableName(BaseDeDatos bbdd){
        this.project = FXCollections.observableArrayList(bbdd.obtenerNombres());

    }

    public void initialize() {

        welcomeText.setText("Bienvenido");
        populateTableName( bbdd);

        // Asociar columna con el valor de String directamente
        proyectosTableName.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()));



        proyectosTableView.setItems(project);

        System.out.println( );

    }
}
