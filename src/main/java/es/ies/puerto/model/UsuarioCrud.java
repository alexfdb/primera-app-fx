package es.ies.puerto.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class UsuarioCrud extends JsonUtil {

    private Set<Usuario> usuarios;

    /**
     * Constructor general.
     */
    public UsuarioCrud() {
        this.usuarios = new HashSet<>(jsonToSet());
    }

    /**
     * Agrega un nuevo usuario a la lista y lo inserta en el json.
     * 
     * @param usuario usuario a agregar a la lista.
     * @return retorna true si el usuario fue agregado.
     */
    public boolean create(Usuario usuario) {
        if (usuario == null || usuario.getEMail() == null || usuario.getEMail().isBlank()) {
            return false;
        }
        if (usuarios.add(usuario)) {
            return setToJson(usuarios);
        }
        return false;
    }

    /**
     * Comprueba las credenciales al logearse.
     * 
     * @param nick     nick del usuario.
     * @param password contrasenia del usuario.
     * @return retorna true si ambos son correctos.
     */
    public Usuario login(String nick, String contrasenia) {
        if (nick == null || nick.isBlank() || contrasenia == null || contrasenia.isBlank()) {
            return null;
        }
        for (Usuario u : usuarios) {
            if (nick.equals(u.getNick()) && contrasenia.equals(u.getContrasenia())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Busca un email en la lista de usuarios.
     * 
     * @param email email a buscar.
     * @return retorna true si encontro el email.
     */
    public boolean serchEmail(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }
        for (Usuario u : usuarios) {
            if (u.getEMail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}