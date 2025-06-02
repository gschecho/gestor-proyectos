package com.springBoot_javaFXS_base.controllers;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.springBoot_javaFXS_base.MainApp;
import com.springBoot_javaFXS_base.entity.Project;
import com.springBoot_javaFXS_base.utils.BaseDeDatos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
        MainApp.setRoot("views/clients");

    }

@FXML
private void newWindow(ActionEvent evento) throws IOException{
    System.out.println("Nueva ventana");
    Stage stage = new Stage();
    Scene scene;

    String fxml = "views/newClient";
    FXMLLoader fxmlLoader =  new FXMLLoader(MainApp.class.getResource( "/fxml/" + fxml + ".fxml"));
    Parent root = fxmlLoader.load();
    scene = new Scene(root); // inicializa la escena

    // Hacer que sea modal
    stage.initModality(Modality.APPLICATION_MODAL);

    // Asociar con la ventana principal (opcional pero recomendable)
    Stage ownerStage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
    stage.initOwner(ownerStage);

    stage.setScene(scene);
    stage.setTitle("App JavaFX + Spring Boot");

    // Bloquea hasta que el usuario cierre esta ventana
    stage.showAndWait();

    // Aquí podrías acceder al controlador si necesitas recuperar datos
    // NewClientController controller = fxmlLoader.getController();
    // Cliente nuevo = controller.getClienteCreado(); // o similar

    System.out.println("Ventana cerrada");



}


    @FXML
    private void populateTableName(BaseDeDatos bbdd){
        this.project = FXCollections.observableArrayList(bbdd.obtenerNombres());
    }


    @FXML
    public void initialize() {

        welcomeText.setText("Bienvenido");
        populateTableName( bbdd);

        // Asociar columna con el valor de String directamente
        proyectosTableName.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()));



        proyectosTableView.setItems(project);

        System.out.println( );

    }
}
