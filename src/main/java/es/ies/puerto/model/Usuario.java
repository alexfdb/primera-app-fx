package es.ies.puerto.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class Usuario {

    @JsonProperty
    private String nick;

    @JsonProperty
    private String contrasenia;

    @JsonProperty
    private String nombre;

    @JsonProperty
    private String email;

    /**
     * Constructor vacio.
     */
    public Usuario() {
    }

    /**
     * Constructor general.
     * 
     * @param nick        nick del usuario
     * @param contrasenia contrasenia del usuario
     * @param nombre      nombre del usuario
     * @param email       email del usuario
     */
    public Usuario(String nick, String contrasenia, String nombre, String email) {
        this.nick = nick;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.email = email;
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
        return this.email;
    }

    public void setEMail(String eMail) {
        this.email = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
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
