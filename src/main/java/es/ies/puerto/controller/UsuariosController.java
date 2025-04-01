package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UsuariosController {

    @FXML
    private Text textLista;
    @FXML
    private Button buttonInicio;

    public void buttonInicioClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("inicio.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 250, 400);
            Stage stage = (Stage) buttonInicio.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}