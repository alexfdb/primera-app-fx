package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.abstractas.AbstractController;
import es.ies.puerto.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class PerfilController extends AbstractController {

    private Usuario usuario;

    /**
     * Inicializar el idioma
     */
    @FXML public void initialize(){
        cambiarIdioma();
    }

    /**
     * Recibe los datos del Usuario desde el login
     * @param usuario usuario validado
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        cargarDatos();
    }

    /**
     * Carga datos
     */
    private void cargarDatos(){
        if (usuario != null ) {
            nickText.setText(usuario.getNick());
            contraseniaText.setText(usuario.getContrasenia());
            nombreText.setText(usuario.getNombre());
            emailText.setText(usuario.getEMail());
        }
    }

    /**
     * Cambia a la pantalla principal. 
     */
    @FXML protected void inicioButtonClick() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            Stage stage = (Stage) inicioButton.getScene().getWindow();
            stage.setTitle("Pantalla Login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}