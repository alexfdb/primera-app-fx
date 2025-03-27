package es.ies.puerto.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @FXML
    private TextField textFiledIngresarUsuario;
    @FXML
    private PasswordField passwordFieldIngresarContrasenia;
    @FXML
    private PasswordField paswordFieldRepetirContrasenia;
    @FXML
    private TextField textFiledIngresarNombre;
    @FXML
    private TextField textFiledIngresarEmail;
    @FXML
    private Text textText;
    @FXML
    private Button buttonEnviar;
    @FXML
    private Button buttonInicio;

    private UsuarioCrud usuarioCrud;

    /**
     * Constructor general.
     */
    public RegistroController() {
        this.usuarioCrud = new UsuarioCrud();
    }

    /**
     * Registra un nuevo UsuarioModel.
     */
    @FXML
    protected void buttonEnviarClick() {
        if (!validarCampos()) {
            textText.setText("Credenciales null o vacias");
            return;
        }

        if (!passwordFieldIngresarContrasenia.getText().equals(paswordFieldRepetirContrasenia.getText())) {
            textText.setText("La contraseña debe coincidir");
        }

        if (!validarEmail(textFiledIngresarEmail.getText())) {
            textText.setText("El formato del email no es válido");
            return;
        }

        Usuario usuario = new Usuario(textFiledIngresarUsuario.getText(),
                passwordFieldIngresarContrasenia.getText(),
                textFiledIngresarNombre.getText(),
                textFiledIngresarEmail.getText());

        usuarioCrud.create(usuario);

        textText.setText("Registrado correctamente");
    }

    /**
     * Valida los campos del registro.
     * 
     * @return retorna true si los campos fueron validados.
     */
    private boolean validarCampos() {
        if (textFiledIngresarUsuario == null || textFiledIngresarUsuario.getText().isBlank() ||
                passwordFieldIngresarContrasenia == null || passwordFieldIngresarContrasenia.getText().isBlank() ||
                paswordFieldRepetirContrasenia == null || paswordFieldRepetirContrasenia.getText().isBlank() ||
                textFiledIngresarNombre == null || textFiledIngresarNombre.getText().isBlank() ||
                textFiledIngresarEmail == null || textFiledIngresarEmail.getText().isBlank()) {
            textText.setText("Credenciales null o vacias");
            return false;
        }
        return true;
    }

    /**
     * Valida el formato del email.
     * 
     * @param email El email a validar.
     * @return true si el formato es válido, false en caso contrario.
     */
    private boolean validarEmail(String email) {
        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Cambia a la pantalla principal.
     */
    @FXML
    protected void buttonInicioClick() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("inicio.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 250, 400);
            Stage stage = (Stage) buttonInicio.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}