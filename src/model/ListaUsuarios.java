
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author pablo erick ramirez cruz
 */
public class ListaUsuarios implements Serializable {
    
    //Es static ya que solo habrá una lista de usuarios
    public static ArrayList<Usuario> lista = new ArrayList();
    private static File file = new File("users.dat");
    
    public static boolean agregar(Usuario u){
        return lista.add(u);
    }
    
    public static Usuario eliminar(int index){
        return lista.remove(index);
    }
    
    public static Usuario get(Usuario u){
        return lista.get(lista.indexOf(u));
    }
    
    public static Usuario get(int i){
        return lista.get(i);
    }
    
    public static Usuario getUsuarioActivo(){
        for (Usuario u:lista){
            if (u.isSesionActiva()){
                return u;
            }
        }
        return null;
    }
    public static void saveData() throws IOException{
        
        if (!file.exists()){
            file.createNewFile();
        }
        
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(lista);
    }
    
    public static ArrayList<Usuario> loadData() throws IOException, ClassNotFoundException{
        
        if (!file.exists()){
            file.createNewFile();
        }else{
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
            ArrayList<Usuario> aux=new ArrayList<>();
            aux=(ArrayList<Usuario>) ois.readObject();
            return aux;
        }
        return new ArrayList<Usuario>();
    }
}
