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
    @FXML private PasswordField paswordFieldRepetirPassword;
    @FXML private TextField textFiledIngresarNombre;
    @FXML private TextField textFiledIngresarEmail;
    @FXML private TextField textFiledRepetirEmail;
    @FXML private Text textMensaje;
    @FXML private Button buttonRegistrar;
    @FXML private Button openLoginButton;

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
