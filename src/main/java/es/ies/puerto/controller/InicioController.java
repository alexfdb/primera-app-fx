package es.ies.puerto.controller;

import java.sql.SQLException;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Usuario;
import es.ies.puerto.model.UsuarioManager;
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
public class InicioController {

    @FXML
    private TextField textFieldUsuario;
    @FXML
    private PasswordField passwordFieldContrasenia;
    @FXML
    private Text textText;
    @FXML
    private Button buttonEnviar;
    @FXML
    private Button buttonRegistrar;
    @FXML
    private Button buttonRecuperar;
    @FXML
    private Button buttonUsuarios;

    private UsuarioManager usuarioManager;

    /**
     * Constructor general.
     */
    public InicioController() throws SQLException {
        usuarioManager = new UsuarioManager();
    }

    /**
     * Iniciar sesion.
     */
    @FXML
    protected void buttonEnviarClick() {

        if (textFieldUsuario == null || textFieldUsuario.getText().isBlank() ||
                passwordFieldContrasenia == null || passwordFieldContrasenia.getText().isBlank()) {
            textText.setText("Credenciales null o vacias");
            return;
        }

        Usuario usuario = usuarioManager.inicio(textFieldUsuario.getText(), passwordFieldContrasenia.getText());

        if (usuario != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("perfil.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 250, 400);

                PerfilController perfilController = fxmlLoader.getController();
                perfilController.setUsuario(usuario);

                Stage stage = (Stage) buttonEnviar.getScene().getWindow();
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
    @FXML
    protected void buttonRegistrarClick() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("registro.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 250, 400);
            Stage stage = (Stage) buttonRegistrar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Cambia a la pantalla de recuperacion.
     */
    @FXML
    protected void buttonRecuperarClick() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("recuperar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 250, 400);
            Stage stage = (Stage) buttonRecuperar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Cambia a la pantalla de usuarios.
     */
    @FXML
    protected void buttonUsuariosClick() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("usuarios.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 250, 400);
            Stage stage = (Stage) buttonRecuperar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}