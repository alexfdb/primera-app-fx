package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class PerfilController {

    @FXML private Text nickText;
    @FXML private Text contraseniaText;
    @FXML private Text nombreText;
    @FXML private Text emailText;
    @FXML private Button inicioButton;

    private Usuario usuario;

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
            Scene scene = new Scene(fxmlLoader.load(), 250, 400);
            Stage stage = (Stage) inicioButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}