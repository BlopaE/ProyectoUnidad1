/*

Gestion de la nomina de los trabajadores de una institucion
para poder llevar el control de sueldos, faltas, retardos
descuentos, se deben contemplar trabajadores por quincena, semana y dia


*/
package ventanas;

import java.io.IOException;
import javax.swing.JOptionPane;
import model.ListaUsuarios;
import model.Usuario;

/**
 *
 * @author Pablo Erick Ramírez Cruz
 */
public class Main {
    
    public static void main(String[] args) {
        
        
        try {
            ListaUsuarios.lista = ListaUsuarios.loadData();
            Constantes.colorPrincipal = Constantes.loadDataColorPrincipal();
            Constantes.colorLight = Constantes.loadDataColorLight();
            Constantes.colorAcent = Constantes.loadDataColorAccent();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer los archivos: "+ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            
        }
         
        /*System.out.println("Usuarios Registrados: ");
        for (Usuario u: ListaUsuarios.lista){
            String password = "";
            for (int i=0;i<u.getPassword().length;i++){
                password+=u.getPassword()[i];
            }
            System.out.println(u.getNombre()+" "+password+" Activo: "+u.isSesionActiva());
        }*/
        
        if (ListaUsuarios.lista.isEmpty()){ //Si no hay elementos en la lista
            //Obligar a registrar un usuario administrador
            RegistroUsuario registro = new RegistroUsuario();
            registro.setVisible(true);
            registro.setDefaultCloseOperation(registro.EXIT_ON_CLOSE);
            
        }else{
            Login login = new Login();
            login.setVisible(true);
        }
    }
}
