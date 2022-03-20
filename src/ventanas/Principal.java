
package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;


/**
 *
 * @author pablo erick ramirez cruz
 */
public class Principal extends JFrame{
    
    private JMenuItem preferencias, apariencia, rendimiento, gestionUsuario,cambiarUsuario, cerrarSesion, reportar, acercaDe;
    private Container contenedor;
    private JButton diaButton, semanaButton, quincenaButton, sueldoButton, faltaButton, retardoButton, agregarTrabajador, eliminarTrabajador;
    private JComboBox filtrar;

    public Principal() {
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(800,600));
        this.setTitle("SEGURABITS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(Constantes.icon.getImage());
        contenedor = this.getContentPane();
        
        
        JMenuBar barra = new JMenuBar();
        JMenu opciones = new JMenu("Opciones");
        JMenu usuarioMenu = new JMenu("Usuario");
        JMenu ayuda = new JMenu("Ayuda");
        
        this.setJMenuBar(barra);
        barra.add(opciones);
        barra.add(usuarioMenu);
        barra.add(ayuda);
        
        preferencias = new JMenuItem("Preferencias");
        apariencia = new JMenuItem("Apariencia");
        apariencia.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser color = new JColorChooser();
                Constantes.colorPrincipal = color.showDialog(null, "Seleccione el color principal", Constantes.colorPrincipal);
            }
        });
        rendimiento = new JMenuItem("rendimiento");
        gestionUsuario = new JMenuItem("Gestionar usuario");
        cambiarUsuario = new JMenuItem("Cambiar de Usuario");
        cerrarSesion = new JMenuItem("Cerrar Sesión");
        reportar = new JMenuItem("Reportar Errores");
        acercaDe = new JMenuItem("Acerca De");
        
        opciones.add(preferencias);
        opciones.add(apariencia);
        opciones.add(rendimiento);
        
        usuarioMenu.add(gestionUsuario);
        usuarioMenu.add(cambiarUsuario);
        usuarioMenu.add(cerrarSesion);
        
        ayuda.add(reportar);
        ayuda.add(acercaDe);
        
        norte();
        oeste();
        center();
    }
    
    private void norte(){
        contenedor.setLayout(new BorderLayout());
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.CENTER,30,15));
        panelNorte.setBackground(Constantes.colorPrincipal);
        JLabel title = new JLabel("TRABAJADORES:");
        title.setFont(Constantes.fontBold);
        title.setForeground(Constantes.colorLight);
        panelNorte.add(title);
        
        diaButton = new JButton("DIA");
        diaButton.setFont(Constantes.fontPlain);
        diaButton.setForeground(Constantes.colorLight);
        diaButton.setBackground(null);
        diaButton.setBorder(null);
        diaButton.setCursor(Constantes.cursorMano);
        diaButton.addMouseListener(new ButtonHover(diaButton,ButtonHover.FOREGROUND));
        panelNorte.add(diaButton);
        
        semanaButton = new JButton("SEMANA");
        semanaButton.setFont(Constantes.fontPlain);
        semanaButton.setForeground(Constantes.colorLight);
        semanaButton.setBackground(null);
        semanaButton.setBorder(null);
        semanaButton.setCursor(Constantes.cursorMano);
        semanaButton.addMouseListener(new ButtonHover(semanaButton,1));
        panelNorte.add(semanaButton);
        
        quincenaButton = new JButton("QUINCENA");
        quincenaButton.setFont(Constantes.fontPlain);
        quincenaButton.setForeground(Constantes.colorLight);
        quincenaButton.setBackground(null);
        quincenaButton.setBorder(null);
        quincenaButton.setCursor(Constantes.cursorMano);
        quincenaButton.addMouseListener(new ButtonHover(quincenaButton,1));
        panelNorte.add(quincenaButton);
        
        contenedor.add(panelNorte,BorderLayout.NORTH);
    }
    
    private void oeste(){
        
        JPanel oeste = new JPanel(new GridLayout(2,1));
        JPanel oesteNorte = new JPanel(new GridLayout(4,1,10,10));
        oeste.setPreferredSize(new Dimension(180,1200));
        oesteNorte.setBackground(Constantes.colorPrincipal);
        
        JLabel title = new JLabel("MODIFICAR",JLabel.CENTER);
        title.setFont(Constantes.fontBold);
        title.setForeground(Constantes.colorLight);
        oesteNorte.add(title);
        
        sueldoButton = new JButton("  SUELDO");
        sueldoButton.setBackground(null);
        sueldoButton.setBorder(null);
        sueldoButton.setCursor(Constantes.cursorMano);
        sueldoButton.setFont(Constantes.fontPlain);
        sueldoButton.setForeground(Constantes.colorLight);
        sueldoButton.addMouseListener(new ButtonHover(sueldoButton,ButtonHover.FOREGROUND));
        sueldoButton.setIcon(new ImageIcon(Constantes.sueldo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        sueldoButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
               Modificacion m = new Modificacion("SUELDO","Ingresa el nuevo sueldo");
               m.setVisible(true);
               m.setAlwaysOnTop(true);
            }
        
        });
        oesteNorte.add(sueldoButton);
        
        retardoButton = new JButton("  RETARDO");
        retardoButton.setBackground(null);
        retardoButton.setBorder(null);
        retardoButton.setCursor(Constantes.cursorMano);
        retardoButton.setFont(Constantes.fontPlain);
        retardoButton.setForeground(Constantes.colorLight);
        retardoButton.addMouseListener(new ButtonHover(retardoButton,ButtonHover.FOREGROUND));
        retardoButton.setIcon(new ImageIcon(Constantes.retardo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        retardoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Modificacion m = new Modificacion("RETARDO","Ingresa la cantidad de retardos");
               m.setVisible(true);
               m.setAlwaysOnTop(true);
            }
        
        });
        oesteNorte.add(retardoButton);
        
        faltaButton = new JButton("  FALTA");
        faltaButton.setBackground(null);
        faltaButton.setBorder(null);
        faltaButton.setCursor(Constantes.cursorMano);
        faltaButton.setFont(Constantes.fontPlain);
        faltaButton.setForeground(Constantes.colorLight);
        faltaButton.addMouseListener(new ButtonHover(faltaButton,ButtonHover.FOREGROUND));
        faltaButton.setIcon(new ImageIcon(Constantes.descuento.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        faltaButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               Modificacion m = new Modificacion("FALTAS","Ingresa la cantidad de faltas");
               m.setVisible(true);
               m.setAlwaysOnTop(true);
            }
        });
        oesteNorte.add(faltaButton);
        
        
        JPanel oesteSur = new JPanel();
        oesteSur.setBackground(Constantes.colorPrincipal);
        JLabel logo = new JLabel();
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setIcon(new ImageIcon(Constantes.logo.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
        oesteSur.add(logo);
        oeste.add(oesteNorte);
        oeste.add(oesteSur);
        
        contenedor.add(oeste,BorderLayout.WEST);
        
    }
    
    private void center(){
        
        JPanel center = new JPanel(new BorderLayout());
        center.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        JPanel centerNorte = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
        
        JLabel filtrarLabel = new JLabel("Filtrar por: ");
        filtrarLabel.setFont(Constantes.fontPlain);
        centerNorte.add(filtrarLabel);
        String [] filtros = {"Sueldo", "Retardos", "Faltas"};
        filtrar = new JComboBox(filtros);
        filtrar.setBackground(Constantes.colorAcent);
        filtrar.setForeground(Constantes.colorLight);
        centerNorte.add(filtrar);
        center.add(centerNorte, BorderLayout.NORTH);
        contenedor.add(center, BorderLayout.CENTER);
        
        agregarTrabajador = new JButton("AGREGAR");
        agregarTrabajador.setBackground(Constantes.colorPrincipal);
        agregarTrabajador.setForeground(Constantes.colorLight);
        agregarTrabajador.setBorder(null);
        agregarTrabajador.setFont(Constantes.fontPlain);
        agregarTrabajador.setCursor(Constantes.cursorMano);
        agregarTrabajador.addMouseListener(new ButtonHover(agregarTrabajador,ButtonHover.BACKGROUND));
        agregarTrabajador.setPreferredSize(new Dimension(80,30));
        agregarTrabajador.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                AgregarTrabajador agregar = new AgregarTrabajador();
                agregar.setVisible(true);
            }
            
        });
        centerNorte.add(agregarTrabajador);
        
        eliminarTrabajador = new JButton("ELIMINAR");
        eliminarTrabajador.setBackground(Constantes.colorPrincipal);
        eliminarTrabajador.setForeground(Constantes.colorLight);
        eliminarTrabajador.setBorder(null);
        eliminarTrabajador.setFont(Constantes.fontPlain);
        eliminarTrabajador.setCursor(Constantes.cursorMano);
        eliminarTrabajador.addMouseListener(new ButtonHover(eliminarTrabajador,ButtonHover.BACKGROUND));
        eliminarTrabajador.setPreferredSize(new Dimension(80,30));
        centerNorte.add(eliminarTrabajador);
        
        String encabezados [] = {"Nombre", "Sueldo", "Retardos", "Faltas"};
        String tablaDatos[][] = {
            {"Pablo Erick Ramírez","12,000","2","0"},
            {"Jose Martínez","12,000","2","0"},
            {"Luis Venegas","5,000","1","1"},
            {"Marta Flores","1,000","2","4"},
            {"Pancho Pantera","45,000","0","0"}
        }; 
        
        JPanel centerCenter = new JPanel(new BorderLayout());
        JTable tabla = new JTable(tablaDatos, encabezados){
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.setFont(Constantes.fontPlain);
        JScrollPane sc = new JScrollPane(tabla);
        centerCenter.add(sc);
        center.add(centerCenter,BorderLayout.CENTER);
        
        
    }
}
