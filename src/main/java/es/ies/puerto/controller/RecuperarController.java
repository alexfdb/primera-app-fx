package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.UsuarioCrud;
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
    @FXML private Button buttonEnviar;
    @FXML private Text textText;
    @FXML private Button buttonInicio;

    UsuarioCrud usuarioCrud;

    /**
     * Constructor general.
     */
    public RecuperarController(){
        this.usuarioCrud = new UsuarioCrud();
    }

    /**
     * Ejecuta el envio
     */
    @FXML protected void buttonEnviarClick(){
        if (textFieldIngresarEmail == null || textFieldIngresarEmail.getText().isEmpty()) {
            textText.setText("¡El Email no puede ser nulo o vacio!");
            return;
        }

        if (!usuarioCrud.serchEmail(textFieldIngresarEmail.getText())) {
            textText.setText("El correo electrónico no es válido o no esta registrado.");
            return;
        }
        textText.setText("¡Mensaje enviado!, revisa el email");
    }

    /**
     * Cambia a la pantalla principal. 
     */
    @FXML protected void buttonInicioClick() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 250, 400);
            Stage stage = (Stage) buttonInicio.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
}
