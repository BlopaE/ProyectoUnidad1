
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author pablo erick ramirez cruz
 */
public class ListaTrabajadores implements Serializable {
    
    private ArrayList<Trabajador> list;
    private File file;
    
    public ListaTrabajadores(File file){
        list = new ArrayList<Trabajador>();
        this.file = file;
    }
    
    public ArrayList<Trabajador> getList() {
        return list;
    }

    public void setList(ArrayList<Trabajador> list) {
        this.list = list;
    }
    
    public boolean addTrabajador(Trabajador t){
        return list.add(t);
    }
    
    public Trabajador removeTrabajador(int index){
        return list.remove(index);
    }
    
    public Trabajador getTrabajador(Trabajador t){
        return list.get(list.indexOf(t));
    }
    
    public Trabajador getTrabajador(int index){
        return list.get(index);
    }
    
    public void ordenarPorFecha(){
        if (list.isEmpty()) return;
        Ordenamiento.quicksortFecha(list, 0, list.size()-1);
    }
    
    public void ordenarPorNombre(){
        if (list.isEmpty()) return;
        Ordenamiento.quicksortNombre(list, 0, list.size()-1);
    }
    
    public void ordenarPorApellido(){
        if (list.isEmpty()) return;
        Ordenamiento.quicksortApellido(list, 0, list.size()-1);
    }
    
    public void ordenarPorSalario(){
        
        if (list.isEmpty()) return;
        Ordenamiento.quicksortSalario(list, 0, list.size()-1);
    }
    
    public void ordenarPorRetardos(){
        if (list.isEmpty()) return;
        Ordenamiento.quicksortRetardos(list, 0, list.size()-1);
    }
    
    public void ordenarPorFaltas(){
        if (list.isEmpty()) return;
        Ordenamiento.quicksortFaltas(list, 0, list.size()-1);
    }
    
    public Object[][] toTable(){
        
        Object [][] table=new Object[list.size()][7];
        
        for (int i=0;i<list.size();i++){
            
            table[i][0]=list.get(i).getNombre();
            table[i][1]=list.get(i).getApellido();
            table[i][2]=list.get(i).getSalario();
            table[i][3]=list.get(i).getRetardos();
            table[i][4]=list.get(i).getFaltas();
            table[i][5]=list.get(i).getSalarioFinal();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            table[i][6]=list.get(i).getFechaRegistro().format(formatter);
        }
        return table;
    }
    
    public void saveData() throws IOException{
        
        if (!file.exists()){
            file.createNewFile();
        }
        
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(list);
    }
    
    public ArrayList<Trabajador> loadData() throws IOException, ClassNotFoundException{
        
        if (!file.exists()){
            file.createNewFile();
        }else{
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
            ArrayList<Trabajador> aux=new ArrayList<>();
            aux=(ArrayList<Trabajador>) ois.readObject();
            return aux;
        }
        return new ArrayList<Trabajador>();
    }
}
