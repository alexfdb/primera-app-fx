package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.abstractas.AbstractController;
import es.ies.puerto.crud.UsuarioCrud;
import es.ies.puerto.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class RegistroController extends AbstractController {

    private UsuarioCrud usuarioCrud;

    /**
     * Constructor general.
     */
    public RegistroController() {
        this.usuarioCrud = new UsuarioCrud(); 
    }

    /**
     * Inicializar el idioma
     */
    @FXML public void initialize(){
        cambiarIdioma();
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
