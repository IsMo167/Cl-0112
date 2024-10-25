import javax.swing.*;
public class VentanaPrincipal extends JFrame {
     public VentanaPrincipal (){
        setTitle ("Ventana de Gabriel");
        setSize (500, 400);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);

        JMenuBar menuBar = new JMenuBar ();
        JMenu menuArchivo = new JMenu ("Archivo");
        JMenuItem nuevoItem = new JMenuItem ("Nuevo");
        JMenuItem guardarItem = new JMenuItem ("Guardar");
        JMenuItem salirItem = new JMenuItem ("Salir");

        menuArchivo.add(nuevoItem);
        menuArchivo.add (guardarItem);
        menuArchivo.addSeparator();
        menuArchivo.add (salirItem);
        menuBar.add(menuArchivo);
        setJMenuBar (menuBar);
     }

     public static void main (String [] args){
        VentanaPrincipal ventana = new VentanaPrincipal ();
        ventana.setVisible (true);

        

     }
}