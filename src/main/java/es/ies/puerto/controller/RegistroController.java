package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Usuario;
import es.ies.puerto.model.UsuarioCrud;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class RegistroController {

    @FXML public TextField textFiledIngresarUsuario;
    @FXML public PasswordField passwordFieldIngresarPassword;
    @FXML public PasswordField paswordFieldRepetirPassword;
    @FXML public TextField textFiledIngresarNombre;
    @FXML public TextField textFiledIngresarEmail;
    @FXML public TextField textFiledRepetirEmail;
    @FXML public Text textMensaje;
    @FXML public Button buttonRegistrar;
    @FXML public Button openLoginButton;

    private UsuarioCrud usuarioCrud;

    /**
     * Constructor general.
     */
    public RegistroController() {
        this.usuarioCrud = new UsuarioCrud(); 
    }

    /**
     * Ejecuta el registro.
     */
    @FXML protected void buttonRegistrarClick() {

        Usuario usuario = new Usuario(textFiledIngresarUsuario.getText(),
                                      passwordFieldIngresarPassword.getText(),
                                      textFiledIngresarNombre.getText(),
                                      textFiledIngresarEmail.getText());

        usuarioCrud.create(usuario);

        textMensaje.setText("Registrado correctamente");
    }

    /**
     * Cambia a la pantalla principal.
     */
    @FXML protected void openLoginClick() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 250, 400);
            Stage stage = (Stage) openLoginButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
