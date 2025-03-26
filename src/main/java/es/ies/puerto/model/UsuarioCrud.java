package es.ies.puerto.model;

import java.util.HashSet;
import java.util.Set;

import es.ies.puerto.util.JsonUtil;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class UsuarioCrud extends JsonUtil{
    
    private Set<Usuario> usuarios;

    /**
     * Constructor general.
     */
    public UsuarioCrud() {
        this.usuarios = new HashSet<>(jsonToSet());
    }

    /**
     * Agrega un nuevo usuario a la lista y lo inserta en el json.
     * @param usuario usuario a agregar a la lista.
     * @return retorna true si el usuario fue agregado.
     */
    public boolean create(Usuario usuario) {
        if(usuarios.add(usuario)) {
            return setToJson(usuarios);
        }
        return false;
    }

    /**
     * Muestra un usuario de la lista.
     * @param usuario usuario a mostrar.
     * @return retorna el usuario a mostrar.
     */
    public Usuario read(Usuario usuario) {
        for (Usuario u : usuarios) {
            if(usuario.equals(u)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Comprueba las credenciales al logearse.
     * @param nick nick del usuario.
     * @param password contrasenia del usuario.
     * @return retorna true si ambos son correctos.
     */
    public Usuario login(String nick, String password) {
        for (Usuario u : usuarios) {
            if(nick.equals(u.getNick()) && password.equals(u.getContrasenia())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Busca un email en la lista de usuarios.
     * @param email email a buscar.
     * @return retorna true si encontro el email.
     */
    public boolean serchEmail(String email) {
        for (Usuario u : usuarios) {
            if(u.getEMail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}