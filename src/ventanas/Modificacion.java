
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
 * @author pablo erick ramirez cruz
 */
public class Modificacion extends JFrame{
    
    private JTextField campo;
    private JButton guardar;
    
    public Modificacion(String title, String msj) {
        
        this.setSize(300,200);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        Container contenedor = this.getContentPane();
        contenedor.setLayout(null);
        
        JLabel mensaje = new JLabel(msj,JLabel.CENTER);
        mensaje.setBounds(0, 20, 300, 30);
        mensaje.setFont(Constantes.fontBold);
        contenedor.add(mensaje);
        
        campo = new JTextField();
        campo.setBounds(20, 60, 240, 30);
        contenedor.add(campo);
        
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
