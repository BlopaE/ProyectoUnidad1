
package ventanas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Pablo Erick Ramírez Cruz
 */
public class AgregarTrabajador extends JFrame{
    
    private JTextField nombreTF,sueldoTF;
    private JButton guardar;

    public AgregarTrabajador() {
        
        this.setSize(300,200);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setTitle("AGREGAR TRABAJADOR");
        this.setLocationRelativeTo(null);
        Container contenedor = this.getContentPane();
        contenedor.setLayout(null);
        
        JLabel nombre = new JLabel("NOMBRE: ");
        nombre.setBounds(20, 30, 100, 20);
        nombre.setFont(Constantes.fontBold);
        contenedor.add(nombre);
        
        nombreTF = new JTextField();
        nombreTF.setBounds(110, 30, 140, 20);
        nombreTF.setFont(Constantes.fontPlain);
        contenedor.add(nombreTF);
        
        JLabel sueldo = new JLabel("SUELDO: ");
        sueldo.setBounds(20, 80, 100, 20);
        sueldo.setFont(Constantes.fontBold);
        contenedor.add(sueldo);
        
        sueldoTF = new JTextField();
        sueldoTF.setBounds(110, 80, 140, 20);
        sueldoTF.setFont(Constantes.fontPlain);
        contenedor.add(sueldoTF);
        
        guardar = new JButton("Guardar");
        guardar.setBounds(20, 110, 240, 30);
        guardar.setBackground(Constantes.colorPrincipal);
        guardar.setForeground(Constantes.colorLight);
        guardar.setBorder(null);
        guardar.addMouseListener(new ButtonHover(guardar,ButtonHover.BACKGROUND));
        guardar.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
            
        });
        contenedor.add(guardar);
        
    }
    
    
}
