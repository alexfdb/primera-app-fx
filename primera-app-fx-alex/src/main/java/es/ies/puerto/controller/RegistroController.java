package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.crud.UsuarioCrud;
import es.ies.puerto.model.Usuario;
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
public class RegistroController extends UsuarioCrud{
    
    @FXML private TextField textFiledIngresarUsuario;

    @FXML private PasswordField passwordFieldIngresarPassword;

    @FXML PasswordField paswordFieldRepetirPassword;

    @FXML TextField textFiledIngresarNombre;

    @FXML TextField textFiledIngresarEmail;

    @FXML TextField textFiledRepetirEmail;

    @FXML Text textMensaje;

    @FXML Button buttonRegistrar;

    @FXML Button openLoginButton;

    @FXML
    protected void buttonRegistrarClick() {

        Usuario usuario = new Usuario(textFiledIngresarUsuario.getText(),
                                      passwordFieldIngresarPassword.getText(),
                                      textFiledIngresarNombre.getText(),
                                      textFiledIngresarEmail.getText());

        create(usuario);

        textMensaje.setText("Registrado correctamente");
    }

    @FXML
    protected void openLoginClick() {

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
