package es.ies.puerto.model;
import java.util.Objects;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class Usuario {
    
    private String nick;
    private String contrasenia;
    private String nombre;
    private String eMail;

    /**
     * Constructor vacio.
     */
    public Usuario() {
    }

    /**
     * Constructor general.
     * @param nick nick del usuario.
     * @param contrasenia contrasenia del usuario.
     * @param nombre nombre del usuario.
     * @param eMail eMail del usuario.
     */
    public Usuario(String nick, String contrasenia, String nombre, String eMail) {
        this.nick = nick;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.eMail = eMail;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEMail() {
        return this.eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(eMail, usuario.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eMail);
    }

    @Override
    public String toString() {
        return "{" +
            " nick='" + getNick() + "'" +
            ", contrasenia='" + getContrasenia() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", eMail='" + getEMail() + "'" +
            "}";
    }
    
}
