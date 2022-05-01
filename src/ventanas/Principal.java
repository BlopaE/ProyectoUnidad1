package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import model.ListaTrabajadores;
import model.ListaUsuarios;
import model.Trabajador;
import model.Usuario;

/**
 *
 * @author pablo erick ramirez cruz
 */
public class Principal extends JFrame {

    private final JMenuItem preferencias;
    private final JMenuItem apariencia;
    private final JMenuItem rendimiento;
    private final JMenuItem gestionUsuario;
    private final JMenuItem cerrarSesion;
    private final JMenuItem reportar;
    private final JMenuItem acercaDe;
    private final Container contenedor;

    private JButton diaButton, semanaButton, quincenaButton, nombreButton, sueldoButton, faltaButton, retardoButton, agregarTrabajador, eliminarTrabajador;
    private JComboBox filtrar;
    private JLabel tituloCenter;
    private JFrame contexto = this;

    private ListaTrabajadores trabajadoresDia, trabajadoresSemana, trabajadoresQuincena;
    private Table tabla;
    public static String encabezados[] = {"Nombre(s)", "Apellidos", "Salario Base", "Retardos", "Faltas", "Salario Final", "Fecha de Registro"};

    public Principal() {

        //Cargar datos de las listas
        trabajadoresDia = new ListaTrabajadores(new File("trabajadoresDia.dat"));
        trabajadoresSemana = new ListaTrabajadores(new File("trabajadoresSemana.dat"));
        trabajadoresQuincena = new ListaTrabajadores(new File("trabajadoresQuincena.dat"));

        try {

            trabajadoresDia.setList(trabajadoresDia.loadData());
            trabajadoresSemana.setList(trabajadoresSemana.loadData());
            trabajadoresQuincena.setList(trabajadoresQuincena.loadData());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer los archivos: "+ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            
        }

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(850, 600));
        this.setTitle("SEGURABITS - Sesion de: " + ListaUsuarios.getUsuarioActivo().getNombre());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                cerrarSesion();
                guardarDatos();

            }
        });
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
        preferencias.addActionListener(new EventoNoSoportado());
        apariencia = new JMenuItem("Apariencia");
        apariencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser color = new JColorChooser();
                Constantes.colorPrincipal = color.showDialog(null, "Seleccione el color principal", Constantes.colorPrincipal);
                Constantes.colorLight = color.showDialog(null, "Seleccione el color claro", Constantes.colorLight);
                Constantes.colorAcent = color.showDialog(null, "Seleccione el color de acentuacion", Constantes.colorAcent);
                JOptionPane.showMessageDialog(contexto, "Reinicie para aplicar los cambios","Guardado",JOptionPane.PLAIN_MESSAGE);
            }
        });
        rendimiento = new JMenuItem("rendimiento");
        rendimiento.addActionListener(new EventoNoSoportado());
        
        gestionUsuario = new JMenuItem("Gestionar usuario");
        cerrarSesion = new JMenuItem("Cerrar Sesión");
        
        reportar = new JMenuItem("Reportar Errores");
        reportar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(contexto, "Puede enviar detalles del error al correo: pablo.blopa22@gmail.com", "REPORTAR", JOptionPane.PLAIN_MESSAGE);
            }
        });
        acercaDe = new JMenuItem("Acerca De");
        acercaDe.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Creditos creditos = new Creditos(contexto);
                creditos.setVisible(true);
            }
        });

        //Eventos de menu
        gestionUsuario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gestionarUsuario();
            }
        });

        cerrarSesion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
                guardarDatos();
                Login l = new Login();
                l.setVisible(true);
                setVisible(false);
            }
        });
        opciones.add(preferencias);
        opciones.add(apariencia);
        opciones.add(rendimiento);

        usuarioMenu.add(gestionUsuario);
        usuarioMenu.add(cerrarSesion);

        ayuda.add(reportar);
        ayuda.add(acercaDe);

        norte();
        oeste();
        center();
    }

    private void norte() {
        contenedor.setLayout(new BorderLayout());
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 15));
        panelNorte.setBackground(Constantes.colorPrincipal);

        JLabel title = new JLabel("TRABAJADORES POR:");
        title.setFont(Constantes.fontBold);
        title.setForeground(Constantes.colorLight);
        panelNorte.add(title);

        diaButton = new JButton("DIA");
        diaButton.setFont(Constantes.fontPlain);
        diaButton.setForeground(Constantes.colorLight);
        diaButton.setBackground(null);
        diaButton.setBorder(null);
        diaButton.setCursor(Constantes.cursorMano);
        diaButton.addMouseListener(new ButtonHover(diaButton, ButtonHover.FOREGROUND));
        panelNorte.add(diaButton);
        diaButton.addActionListener(new EventoMostrarTrabajadores());

        semanaButton = new JButton("SEMANA");
        semanaButton.setFont(Constantes.fontPlain);
        semanaButton.setForeground(Constantes.colorLight);
        semanaButton.setBackground(null);
        semanaButton.setBorder(null);
        semanaButton.setCursor(Constantes.cursorMano);
        semanaButton.addMouseListener(new ButtonHover(semanaButton, 1));
        panelNorte.add(semanaButton);
        semanaButton.addActionListener(new EventoMostrarTrabajadores());

        quincenaButton = new JButton("QUINCENA");
        quincenaButton.setFont(Constantes.fontPlain);
        quincenaButton.setForeground(Constantes.colorLight);
        quincenaButton.setBackground(null);
        quincenaButton.setBorder(null);
        quincenaButton.setCursor(Constantes.cursorMano);
        quincenaButton.addMouseListener(new ButtonHover(quincenaButton, 1));
        panelNorte.add(quincenaButton);
        quincenaButton.addActionListener(new EventoMostrarTrabajadores());

        contenedor.add(panelNorte, BorderLayout.NORTH);
    }

    private void oeste() {

        JPanel oeste = new JPanel(new GridLayout(2, 1));
        JPanel oesteNorte = new JPanel(new GridLayout(5, 1, 5, 5));
        oeste.setPreferredSize(new Dimension(200, 1200));
        oesteNorte.setBackground(Constantes.colorPrincipal);

        JLabel title = new JLabel("MODIFICAR", JLabel.CENTER);
        title.setFont(Constantes.fontBold);
        title.setForeground(Constantes.colorLight);
        oesteNorte.add(title);

        nombreButton = new JButton("  NOMBRE");
        nombreButton.setActionCommand(Modificacion.NOMBRE);
        nombreButton.setBackground(null);
        nombreButton.setBorder(null);
        nombreButton.setCursor(Constantes.cursorMano);
        nombreButton.setFont(Constantes.fontPlain);
        nombreButton.setForeground(Constantes.colorLight);
        nombreButton.addMouseListener(new ButtonHover(nombreButton, ButtonHover.FOREGROUND));
        nombreButton.setIcon(new ImageIcon(Constantes.nombre.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        nombreButton.addActionListener(new EventoModificarTrabajadores());
        oesteNorte.add(nombreButton);

        sueldoButton = new JButton("  SUELDO");
        sueldoButton.setActionCommand(Modificacion.SUELDO);
        sueldoButton.setBackground(null);
        sueldoButton.setBorder(null);
        sueldoButton.setCursor(Constantes.cursorMano);
        sueldoButton.setFont(Constantes.fontPlain);
        sueldoButton.setForeground(Constantes.colorLight);
        sueldoButton.addMouseListener(new ButtonHover(sueldoButton, ButtonHover.FOREGROUND));
        sueldoButton.setIcon(new ImageIcon(Constantes.sueldo.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        sueldoButton.addActionListener(new EventoModificarTrabajadores());
        oesteNorte.add(sueldoButton);

        retardoButton = new JButton("  RETARDO");
        retardoButton.setActionCommand(Modificacion.RETARDO);
        retardoButton.setBackground(null);
        retardoButton.setBorder(null);
        retardoButton.setCursor(Constantes.cursorMano);
        retardoButton.setFont(Constantes.fontPlain);
        retardoButton.setForeground(Constantes.colorLight);
        retardoButton.addMouseListener(new ButtonHover(retardoButton, ButtonHover.FOREGROUND));
        retardoButton.setIcon(new ImageIcon(Constantes.retardo.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        retardoButton.addActionListener(new EventoModificarTrabajadores());
        oesteNorte.add(retardoButton);

        faltaButton = new JButton("  FALTA");
        faltaButton.setActionCommand(Modificacion.FALTA);
        faltaButton.setBackground(null);
        faltaButton.setBorder(null);
        faltaButton.setCursor(Constantes.cursorMano);
        faltaButton.setFont(Constantes.fontPlain);
        faltaButton.setForeground(Constantes.colorLight);
        faltaButton.addMouseListener(new ButtonHover(faltaButton, ButtonHover.FOREGROUND));
        faltaButton.setIcon(new ImageIcon(Constantes.descuento.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        faltaButton.addActionListener(new EventoModificarTrabajadores());
        oesteNorte.add(faltaButton);

        JPanel oesteSur = new JPanel();
        oesteSur.setBackground(Constantes.colorPrincipal);
        JLabel logo = new JLabel();
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setIcon(new ImageIcon(Constantes.logo.getImage().getScaledInstance(230, 230, Image.SCALE_SMOOTH)));
        oesteSur.add(logo);
        oeste.add(oesteNorte);
        oeste.add(oesteSur);

        contenedor.add(oeste, BorderLayout.WEST);

    }

    private void center() {

        JPanel center = new JPanel(new BorderLayout());
        center.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        JPanel centerNorte = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel etiquetaMostrando = new JLabel("Mostrando por:");
        etiquetaMostrando.setFont(Constantes.fontBold);
        centerNorte.add(etiquetaMostrando);

        tituloCenter = new JLabel("DIA");
        tituloCenter.setFont(Constantes.fontBold);
        tituloCenter.setForeground(Constantes.colorAcent);
        centerNorte.add(tituloCenter);

        JLabel filtrarLabel = new JLabel("Filtrar por: ");
        filtrarLabel.setFont(Constantes.fontPlain);
        centerNorte.add(filtrarLabel);
        String[] filtros = {"Nombre", "Apellido", "Sueldo", "Retardos", "Faltas", "Fecha de Registro"};
        filtrar = new JComboBox(filtros);
        filtrar.setSelectedIndex(5);
        filtrar.setBackground(Constantes.colorAcent);
        filtrar.setForeground(Constantes.colorLight);
        filtrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarDatos((String) filtrar.getSelectedItem());
            }
        });
        centerNorte.add(filtrar);
        center.add(centerNorte, BorderLayout.NORTH);
        contenedor.add(center, BorderLayout.CENTER);

        agregarTrabajador = new JButton("AGREGAR");
        agregarTrabajador.setBackground(Constantes.colorPrincipal);
        agregarTrabajador.setForeground(Constantes.colorLight);
        agregarTrabajador.setBorder(null);
        agregarTrabajador.setFont(Constantes.fontPlain);
        agregarTrabajador.setCursor(Constantes.cursorMano);
        agregarTrabajador.addMouseListener(new ButtonHover(agregarTrabajador, ButtonHover.BACKGROUND));
        agregarTrabajador.setPreferredSize(new Dimension(80, 30));
        agregarTrabajador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (ListaUsuarios.getUsuarioActivo().getRol().equals(Usuario.ADMINISTRADOR)) {

                    AgregarTrabajador agregar = new AgregarTrabajador(tituloCenter.getText(), obtenerListaActual(), tabla);
                    agregar.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(contexto, "Solo los administradores pueden agregar trabajadores","ACCESO DENEGADO", JOptionPane.WARNING_MESSAGE);
                }

            }

        });
        centerNorte.add(agregarTrabajador);

        eliminarTrabajador = new JButton("ELIMINAR");
        eliminarTrabajador.setBackground(Constantes.colorPrincipal);
        eliminarTrabajador.setForeground(Constantes.colorLight);
        eliminarTrabajador.setBorder(null);
        eliminarTrabajador.setFont(Constantes.fontPlain);
        eliminarTrabajador.setCursor(Constantes.cursorMano);
        eliminarTrabajador.addMouseListener(new ButtonHover(eliminarTrabajador, ButtonHover.BACKGROUND));
        eliminarTrabajador.setPreferredSize(new Dimension(80, 30));
        eliminarTrabajador.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (ListaUsuarios.getUsuarioActivo().getRol().equals(Usuario.ADMINISTRADOR)) {

                    int index = tabla.getSelectedRow();
                    if (index == -1) {
                        return; //Si no hay nada seleccionado, se cancela el evento
                    }
                    int opcion = JOptionPane.showConfirmDialog(contexto, "¿Esta seguro que desea eliminar al trabajador: "
                            + obtenerListaActual().getTrabajador(index).getNombre() + " " + obtenerListaActual().getTrabajador(index).getApellido() + "?");

                    if (opcion == JOptionPane.YES_OPTION) {
                        obtenerListaActual().removeTrabajador(index);
                        tabla.actualizarTabla(obtenerListaActual().toTable(), encabezados);
                    }

                } else {
                    JOptionPane.showMessageDialog(contexto, "Solo los administradores pueden eliminar trabajadores","ACCESO DENEGADO", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        centerNorte.add(eliminarTrabajador);

        Object datos[][] = obtenerListaActual().toTable();

        JPanel centerCenter = new JPanel(new BorderLayout());
        tabla = new Table(new DefaultTableModel());
        tabla.setFont(Constantes.fontPlain);
        JScrollPane sc = new JScrollPane(tabla);
        tabla.actualizarTabla(datos, encabezados);
        centerCenter.add(sc);
        center.add(centerCenter, BorderLayout.CENTER);

    }

    private void gestionarUsuario() { //Posibilidad de cambiar nombre, contraseña y rol, eliminar, agregar, solo si el usuario activo es admi

        if (ListaUsuarios.getUsuarioActivo().getRol().equals(Usuario.ADMINISTRADOR)) {
            RegistroUsuario registroUsuario = new RegistroUsuario();
            registroUsuario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Solo los administradores pueden gestionar usuarios", "ACCESO DENEGADO", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void cerrarSesion() {

        ListaUsuarios.getUsuarioActivo().setSesionActiva(false);

        try {
            ListaUsuarios.saveData();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarDatos() {
        try {

            if (!trabajadoresDia.getList().isEmpty()) {
                trabajadoresDia.ordenarPorFecha();
            }
            if (!trabajadoresSemana.getList().isEmpty()) {
                trabajadoresSemana.ordenarPorFecha();
            }
            if (!trabajadoresQuincena.getList().isEmpty()) {
                trabajadoresQuincena.ordenarPorFecha();
            }

            trabajadoresDia.saveData();
            trabajadoresSemana.saveData();
            trabajadoresQuincena.saveData();
            
            Constantes.saveDataColorPrincipal();
            Constantes.saveDataColorLight();
            Constantes.saveDataColorAccent();

        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ListaTrabajadores obtenerListaActual() {

        switch (tituloCenter.getText()) {
            case Trabajador.DIA:
                return trabajadoresDia;
            case Trabajador.SEMANA:
                return trabajadoresSemana;
            case Trabajador.QUINCENA:
                return trabajadoresQuincena;
            default:
                return null;
        }
    }

    private void filtrarDatos(String filtro) {
        switch (filtro) {
            case "Nombre":
                obtenerListaActual().ordenarPorNombre();
                break;
            case "Apellido":
                obtenerListaActual().ordenarPorApellido();
                break;
            case "Sueldo":
                obtenerListaActual().ordenarPorSalario();
                break;
            case "Retardos":
                obtenerListaActual().ordenarPorRetardos();
                break;
            case "Faltas":
                obtenerListaActual().ordenarPorFaltas();
                break;
            case "Fecha de Registro":
                obtenerListaActual().ordenarPorFecha();
                break;
            default:
                break;
        }
        tabla.actualizarTabla(obtenerListaActual().toTable(), encabezados);
    }

    private class EventoMostrarTrabajadores implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            tituloCenter.setText(e.getActionCommand());
            tabla.actualizarTabla(obtenerListaActual().toTable(), encabezados);

        }
    }

    private class EventoModificarTrabajadores implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Si es un registrador, no debe hacer nada
            if (ListaUsuarios.getUsuarioActivo().getRol().equals(Usuario.REGISTRADOR) && (e.getActionCommand().equals(Modificacion.NOMBRE) || e.getActionCommand().equals(Modificacion.SUELDO))) {
                JOptionPane.showMessageDialog(contexto, "Solo los administradores y subjefes pueden moficar el nombre y el sueldo", "ACCESO DENEGADO", JOptionPane.WARNING_MESSAGE);
            } else {

                int index = tabla.getSelectedRow();
                if (index == -1) {
                    return;
                }
                Trabajador t = obtenerListaActual().getTrabajador(index);
                Modificacion m = new Modificacion(e.getActionCommand(),t,obtenerListaActual(),tabla);
                m.setVisible(true);
            }
        }
    }
    
    private class EventoNoSoportado implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(contexto, "Proximamente... :)", "No soportado aún", JOptionPane.PLAIN_MESSAGE);
        }
        
    }
}
