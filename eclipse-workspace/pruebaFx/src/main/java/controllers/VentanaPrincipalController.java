package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VentanaPrincipalController {

    @FXML
    private Button btnBoton;

    @FXML
    private Label lblLabel;

    @FXML
    void btnPressed(ActionEvent event) {
      lblLabel.setText("Hola mundo");
    }

}
