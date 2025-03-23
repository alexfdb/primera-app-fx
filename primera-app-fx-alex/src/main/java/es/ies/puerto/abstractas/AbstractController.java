package es.ies.puerto.abstractas;

import es.ies.puerto.config.ConfigManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AbstractController {

    @FXML public TextField textFieldUsuario;
    @FXML public PasswordField textFieldPassword;
    @FXML public Text textFieldMensaje;
    @FXML public Button aceptarButton;
    @FXML public Button openRegistrarButton;
    @FXML public Button openRecuperarButton;
    @FXML public ComboBox comboIdioma;
    
    @FXML public void cambiarIdioma() {
        textFieldUsuario.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldUsuario"));
        textFieldPassword.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldPassword"));
        textFieldMensaje.setText(ConfigManager.ConfigProperties.getProperty("textFieldMensaje"));
        aceptarButton.setText(ConfigManager.ConfigProperties.getProperty("aceptarButton"));
        openRegistrarButton.setText(ConfigManager.ConfigProperties.getProperty("openRegistrarButton"));
        openRecuperarButton.setText(ConfigManager.ConfigProperties.getProperty("openRecuperarButton"));

    }

}
