
package ventanas;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo erick ramirez cruz
 */
public class Table extends JTable{

    DefaultTableModel model;
    public Table(DefaultTableModel model) {
        this.model = model;
        this.setModel(model);
        
    }
    
    //Desactiva la opcion de editar las celdas
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    public void setTableModel(DefaultTableModel model){
        this.model = model;
        this.setModel(model);
        
    }
    
    public void actualizarTabla(Object [][] dataVector, Object[] columnIdentifiers){
        model.setDataVector(dataVector, columnIdentifiers);
    }
    
    
}
