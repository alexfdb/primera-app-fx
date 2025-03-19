package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.crud.UsuarioCrud;
import es.ies.puerto.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class LoginController extends AbstractController{

    @FXML private TextField textFieldUsuario;
    @FXML private PasswordField textFieldPassword;
    @FXML private Text textFieldMensaje;
    @FXML private Button aceptarButton;
    @FXML private Button openRegistrarButton;
    @FXML private Button openRecuperarButton;
    @FXML private ComboBox comboIdioma;

    private UsuarioCrud usuarioCrud;

    public LoginController() {
        usuarioCrud = new UsuarioCrud();
    }

    @FXML 
    public void initialize() {
        List<String> idiomas = new ArrayList<>();
        idiomas.add("es");
        idiomas.add("en");
        idiomas.add("fr");
        comboIdioma.getItems().addAll(idiomas);
    }

    @FXML protected void cambiarIdioma() {
        Properties properties = loadIdioma("idioma", comboIdioma.getValue().toString());
        comboIdioma.setPromptText(properties.getProperty("comboIdioma"));
        textFieldMensaje.setText(properties.getProperty("textFieldMensaje"));
    }

    /**
     * Ejecuta el logeo.
     */
    @FXML protected void onLoginButtonClick() {

        if (textFieldUsuario== null || textFieldUsuario.getText().isEmpty() || 
            textFieldPassword == null || textFieldPassword.getText().isEmpty() ) {
                textFieldMensaje.setText("Credenciales null o vacias");
                return;
        }

        if(usuarioCrud.login(textFieldUsuario.getText(), textFieldPassword.getText())) {
            try {
                Stage stage = (Stage) aceptarButton.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("perfil.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 820, 640);
                stage.setTitle("Pantalla Perfil");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        textFieldMensaje.setText("El usuario no esta registrado.");

    }



    /**
     * Cambia a la pantalla de registro.
     */
    @FXML protected void openRegistrarClick() {

        try {
            Stage stage = (Stage) openRegistrarButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("registro.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Registro");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Cambia a la pantalla de recuperacion.
     */
    @FXML protected void openRecuperarClick() {

        try {
            Stage stage = (Stage) openRecuperarButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("recuperar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Pantalla Recuperar");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}