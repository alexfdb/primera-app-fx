package es.ies.puerto.crud;

import java.util.HashSet;
import java.util.Set;

import es.ies.puerto.model.Usuario;
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

}