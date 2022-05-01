package model;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validacion {

    public static boolean comprobarVacios(JTextField campos[]) {

        boolean vacio = false;

        for (int i = 0; i < campos.length && !vacio; i++) {
            if (campos[i].getText().isEmpty()) {
                vacio = true;
            }
        }
        return vacio;
    }

    public static boolean comprobarVacio(JTextField campo, String texto) {
        boolean vacio = false;

        if (campo.getText().isEmpty()) {
            vacio = true;
            JOptionPane.showMessageDialog(null, texto);
        }
        return vacio;
    }

    public static String comprobarVacios(Object matriz[][]) {

        String error = "";

        for (int i = 0; i < matriz[0].length; i++) {
            JTextField c = (JTextField) matriz[0][i];

            if (c.getText().isEmpty()) {
                error += "-" + (String) matriz[1][i] + "\n";
            }
        }

        return error;

    }

    public static void escribirSoloNumerosEnteros(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }
    
    public static void escribirSoloNumerosDecimales(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
    }
    
    public static void escribirSoloTexto(KeyEvent evt){
        if (!Character.isLetter(evt.getKeyChar())){
            evt.consume();
        }
    }
    
    public static boolean comprobarContraseña(String password){
        
        //Debe tener al menos 8 caracteres y maximo 16, incluyendo mayusculas, minusculas y numeros
        return password.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
    }
}
