package es.ies.puerto.abstractas;

import es.ies.puerto.config.ConfigManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class AbstractController {

    //Login
    @FXML public TextField textFieldUsuario;
    @FXML public PasswordField textFieldPassword;
    @FXML public Text textFieldMensaje;
    @FXML public Button aceptarButton;
    @FXML public Button openRegistrarButton;
    @FXML public Button openRecuperarButton;
    @FXML public ComboBox comboIdioma;

    //Perfil
    @FXML public Text nickText;
    @FXML public Text contraseniaText;
    @FXML public Text nombreText;
    @FXML public Text emailText;
    @FXML public Button inicioButton;

    //Recuperar
    @FXML public TextField textFieldIngresarEmail;
    @FXML public Button enviarButton;
    @FXML public Text text;
    @FXML public Button openLoginButton;

    //Registro
    @FXML public TextField textFiledIngresarUsuario;
    @FXML public PasswordField passwordFieldIngresarPassword;
    @FXML public PasswordField paswordFieldRepetirPassword;
    @FXML public TextField textFiledIngresarNombre;
    @FXML public TextField textFiledIngresarEmail;
    @FXML public TextField textFiledRepetirEmail;
    @FXML public Text textMensaje;
    @FXML public Button buttonRegistrar;
    
    /**
     * Cambia el idioma de la aplicacion
     */
    @FXML public void cambiarIdioma() {

        Platform.runLater(() -> {
            //Login
            textFieldUsuario.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldUsuario"));
            textFieldPassword.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldPassword"));
            textFieldMensaje.setText(ConfigManager.ConfigProperties.getProperty("textFieldMensaje"));
            aceptarButton.setText(ConfigManager.ConfigProperties.getProperty("aceptarButton"));
            openRegistrarButton.setText(ConfigManager.ConfigProperties.getProperty("openRegistrarButton"));
            openRecuperarButton.setText(ConfigManager.ConfigProperties.getProperty("openRecuperarButton"));

            //Perfil
            nickText.setText(ConfigManager.ConfigProperties.getProperty("nickText"));
            contraseniaText.setText(ConfigManager.ConfigProperties.getProperty("contraseniaText"));
            nombreText.setText(ConfigManager.ConfigProperties.getProperty("nombreText"));
            emailText.setText(ConfigManager.ConfigProperties.getProperty("emailText"));
            inicioButton.setText(ConfigManager.ConfigProperties.getProperty("inicioButton"));

            //Recuperar
            textFieldIngresarEmail.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldIngresarEmail"));
            enviarButton.setText(ConfigManager.ConfigProperties.getProperty("enviarButton"));
            text.setText(ConfigManager.ConfigProperties.getProperty("text"));
            openLoginButton.setText(ConfigManager.ConfigProperties.getProperty("openLoginButton"));

            //Registro
            textFiledIngresarUsuario.setPromptText(ConfigManager.ConfigProperties.getProperty("textFiledIngresarUsuario"));
            passwordFieldIngresarPassword.setPromptText(ConfigManager.ConfigProperties.getProperty("passwordFieldIngresarPassword"));
            paswordFieldRepetirPassword.setPromptText(ConfigManager.ConfigProperties.getProperty("paswordFieldRepetirPassword"));
            textFiledIngresarNombre.setPromptText(ConfigManager.ConfigProperties.getProperty("textFiledIngresarNombre"));
            textFiledIngresarEmail.setPromptText(ConfigManager.ConfigProperties.getProperty("textFiledIngresarEmail"));
            textFiledRepetirEmail.setPromptText(ConfigManager.ConfigProperties.getProperty("textFiledRepetirEmail"));
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("textMensaje"));
            buttonRegistrar.setText(ConfigManager.ConfigProperties.getProperty("buttonRegistrar"));
        });
    }

}
