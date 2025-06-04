package com.springBoot_javaFXS_base.controllers;

import com.springBoot_javaFXS_base.entity.Client;
import com.springBoot_javaFXS_base.entity.Person;
import com.springBoot_javaFXS_base.service.ClientService;
import com.springBoot_javaFXS_base.service.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewClientController {

    @FXML public Button saveNewClientBtn;
    @FXML public Button removeContactBtn;
    @FXML public TextField nameNewClient;
    @FXML public TextField nifNewClient;
    @FXML public TextField adressNewClient;
    @FXML public ChoiceBox<Person> newClientContactSelector;
    @FXML public ListView<Person> newClientContactView;

    private ObservableList<Person> availableContacts;
    private ObservableList<Person> selectedContacts;


    @Autowired  private ClientService clientService;
    @Autowired PersonService personService;





    @FXML
    public void initialize() {
        List<Person> people = personService.findAllPersons();
        availableContacts = FXCollections.observableArrayList(people != null ? people : new ArrayList<>());
        selectedContacts = FXCollections.observableArrayList();

        newClientContactSelector.setItems(availableContacts);
        newClientContactView.setItems(selectedContacts);

        newClientContactSelector.setConverter(new StringConverter<>() {
            @Override
            public String toString(Person person) {
                return person != null ? person.getFirstName() + " " + person.getLastName() : "";
            }

            @Override
            public Person fromString(String string) {
                return null; // No editable desde texto
            }
        });

        newClientContactSelector.setOnAction(event -> {
            Person selected = newClientContactSelector.getValue();
            if (selected != null && !selectedContacts.contains(selected)) {
                selectedContacts.add(selected);
                availableContacts.remove(selected);
                newClientContactSelector.getItems().remove(selected);
            }
        });
    }

    @FXML
    public void saveNewClient(ActionEvent actionEvent) {
        if (nameNewClient.getText().isEmpty() || nifNewClient.getText().isEmpty()) {
            showAlert("Campos requeridos", "El nombre y el NIF son obligatorios.");
            return;
        }

        Client client = new Client();
        client.setName(nameNewClient.getText());
        client.setNif(nifNewClient.getText());
        client.setAddress(adressNewClient.getText());
        client.setContacts(new ArrayList<>(selectedContacts));

        clientService.save(client);

        showAlert("Éxito", "Cliente guardado correctamente.");
        resetForm();
    }

    @FXML
    public void removeSelectedContact(ActionEvent event) {
        Person selected = newClientContactView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selectedContacts.remove(selected);
            availableContacts.add(selected);
            newClientContactSelector.getItems().add(selected);
        }
    }

    private void resetForm() {
        nameNewClient.clear();
        nifNewClient.clear();
        adressNewClient.clear();
        selectedContacts.clear();

        availableContacts.setAll(personService.findAllPersons());
        newClientContactSelector.setItems(availableContacts);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
