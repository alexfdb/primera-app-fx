package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PerfilController {

    @FXML private Text nickText;
    @FXML private Text contraseniaText;
    @FXML private Text nombreText;
    @FXML private Text emailText;
    @FXML private Button inicioButton;

    /**
     * Cambia a la pantalla principal. 
     */
    @FXML protected void inicioButtonClick() {

        try {
            Stage stage = (Stage) inicioButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}