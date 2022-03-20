
package ventanas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
/**
 *
 * @author pablo erick ramirez cruza
 */
public class Constantes {
    
    //Colores
    public static Color colorPrincipal = new Color(39, 76, 119);
    public static Color colorLight = new Color(231, 236, 239);
    public static Color colorAcent = new Color(96, 150, 186);
    
    //Fuentes
    public static Font fontBold = new Font("Arial",Font.BOLD,16);
    public static Font fontPlain = new Font("Arial",Font.PLAIN, 14);
    
    //Iconos
    public static ImageIcon icon = new ImageIcon(Constantes.class.getResource("icon.png"));
    public static ImageIcon logo = new ImageIcon(Constantes.class.getResource("logo.png"));
    public static ImageIcon sueldo = new ImageIcon(Constantes.class.getResource("sueldo.png"));
    public static ImageIcon retardo = new ImageIcon(Constantes.class.getResource("retardo.png"));
    public static ImageIcon descuento = new ImageIcon(Constantes.class.getResource("descuento.png"));

    //Cursores
    public static Cursor cursorMano = new Cursor(Cursor.HAND_CURSOR);
}
