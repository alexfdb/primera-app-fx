package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Usuario;
import es.ies.puerto.model.UsuarioCrud;
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
public class LoginController {

    @FXML public TextField textFieldUsuario;
    @FXML public PasswordField textFieldPassword;
    @FXML public Text textFieldMensaje;
    @FXML public Button aceptarButton;
    @FXML public Button openRegistrarButton;
    @FXML public Button openRecuperarButton;
    @FXML public ComboBox comboIdioma;

    private UsuarioCrud usuarioCrud;
    private static final String PATH = "src/main/resources/";
    private static final String FICHEROSTR= "idioma-";

    /**
     * Constructor general.
     */
    public LoginController() {
        usuarioCrud = new UsuarioCrud();
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

        Usuario usuario = usuarioCrud.login(textFieldUsuario.getText(), textFieldPassword.getText());
        if(usuario != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("perfil.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 250, 400);

                PerfilController perfilController = fxmlLoader.getController();
                perfilController.setUsuario(usuario);

                Stage stage = (Stage) aceptarButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Cambia a la pantalla de registro.
     */
    @FXML protected void openRegistrarClick() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("registro.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 250, 400);
            Stage stage = (Stage) openRegistrarButton.getScene().getWindow();
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
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("recuperar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 250, 400);
            Stage stage = (Stage) openRecuperarButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}