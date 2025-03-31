package es.ies.puerto.model;

/**
 * @author alexfdb
 * @version 1.0.0
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioManager {

    private DatabaseManager databaseManager;

    /**
     * Construcor vacio.
     */
    public UsuarioManager() {
    }

    /**
     * Obtiene todos los usuarios.
     * 
     * @return retorna todos los usuarios.
     * @throws SQLException error controlado.
     */
    public ArrayList<Usuario> obtenerUsuarios() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (PreparedStatement sentencia = databaseManager.conectar().prepareStatement(sql);
                ResultSet resultSet = sentencia.executeQuery()) {
            while (resultSet.next()) {
                String nick = resultSet.getString("nick");
                String contrasenia = resultSet.getString("contrasenia");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                Usuario usuario = new Usuario(nick, contrasenia, nombre, email);
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

}