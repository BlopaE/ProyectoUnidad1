
package model;

import java.io.Serializable;

/**
 *
 * @author pablo erick ramírez cruz
 */
public class Usuario implements Serializable{

    private String nombre;
    private char[] password;
    private String rol;
    private boolean sesionActiva = false;
    
    public static final String ADMINISTRADOR = "ADMINISTRADOR", SUBJEFE = "SUBJEFE", REGISTRADOR = "REGISTRADOR";

    public Usuario(String nombre, char[] password, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public char[] getPassword() {
        return password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setSesionActiva(boolean sesionActiva) {
        this.sesionActiva = sesionActiva;
    }

    public boolean isSesionActiva() {
        return sesionActiva;
    }

    @Override
    public String toString() {
        String pass = "";
        for (int i = 0; i<password.length; i++){
            pass+=password[i];
        }
        return "Nombre: "+nombre+" Contraseña: "+pass+" Rol: "+rol;
    }
    
    
}
