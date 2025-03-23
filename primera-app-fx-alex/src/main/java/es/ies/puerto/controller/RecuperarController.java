package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.crud.UsuarioCrud;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class RecuperarController {

    @FXML private TextField textFieldIngresarEmail;
    @FXML private Button enviarButton;
    @FXML private Text text;
    @FXML private Button openLoginButton;

    UsuarioCrud usuarioCrud;

    public RecuperarController(){
        this.usuarioCrud = new UsuarioCrud();
    }

    @FXML
    protected void buttonEnviarClick(){
        if (textFieldIngresarEmail == null || textFieldIngresarEmail.getText().isEmpty()) {
            text.setText("¡El Email no puede ser nulo o vacio!");
            return;
        }

        if (!usuarioCrud.serchEmail(textFieldIngresarEmail.getText())) {
            text.setText("El correo electrónico no es válido o no esta registrado.");
            return;
        }
        text.setText("¡Mensaje enviado!, revisa el email");
    }

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
    
}
