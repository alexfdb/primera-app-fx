package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.abstractas.AbstractController;
import es.ies.puerto.config.ConfigManager;
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
    private static final String PATH = "src/main/resources/";
    private static final String FICHEROSTR= "idioma-";

    /**
     * Constructor general.
     */
    public LoginController() {
        usuarioCrud = new UsuarioCrud();
    }

    /**
     * Inicializa algo
     */
    @FXML public void initialize() {
        List<String> idiomas = new ArrayList<>();
        idiomas.add("es");
        idiomas.add("en");
        comboIdioma.getItems().addAll(idiomas);
        cargarIdioma("es");
        cambiarIdioma();
    }

    /**
     * Selecciona el idioma
     */
    @FXML protected void seleccionarIdiomaClick() {
        String idioma = comboIdioma.getValue().toString();
        cargarIdioma(idioma);
        cambiarIdioma();

    }

    /**
     * Carga el idioma
     * @param idioma idioma a cargar
     */
    private void cargarIdioma(String idioma) {
        String path = PATH + FICHEROSTR + idioma + ".properties";
        ConfigManager.ConfigProperties.setPath(path);
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
                Stage stage = (Stage) aceptarButton.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("perfil.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 820, 640);

                PerfilController perfilController = fxmlLoader.getController();
                perfilController.setUsuario(usuario);

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