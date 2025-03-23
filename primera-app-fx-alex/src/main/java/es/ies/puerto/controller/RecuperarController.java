package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class RecuperarController {

    @FXML private TextField textFieldIngresarEmail;
    @FXML private Button enviarButton;
    @FXML private Button openLoginButton;

    /**
     * Cambia a la pantalla principal. 
     */
    @FXML protected void openLoginClick() {

        try {
            Stage stage = (Stage) openLoginButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    @FXML protected void buttonEnviarClick() {
        System.out.println("");
    }
    
}
