import java.io.FileWriter;
import java.io.IOException;

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

         salirItem.addActionListener(e -> System.exit(0));

         JPanel panelFormulario = new JPanel ();
         panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));

         JLabel etiquetaNombre = new JLabel ("Nombre");
         JTextField campoNombre = new JTextField (20);

         JLabel etiquetaEmail = new JLabel ("Email: ");
         JTextField campoEmail = new JTextField (20);

         JLabel etiquetaTelefono = new JLabel ("Teléfono: ");
         JTextField campoTelefono = new JTextField (20);

         panelFormulario.add(etiquetaNombre);
         panelFormulario.add(campoNombre);
         panelFormulario.add (etiquetaEmail);
         panelFormulario.add(campoEmail);
         panelFormulario.add(etiquetaTelefono);
         panelFormulario.add (campoTelefono);
         add(panelFormulario);

         JButton botonGuardar = new JButton ("Guardar");

         botonGuardar.addActionListener (e ->{
               String nombre = campoNombre.getText ();
               String email = campoEmail.getText ();
               String telefono = campoTelefono.getText ();

               try{
                  FileWriter writer = new FileWriter ("datos_usuario.txt", true);
                  writer.write ("\n |   Nombre " + "   |    Email " + "   |   Teléfono   | ");
                  writer.write ("\n | " + nombre + " | " + email + " | " + telefono + " | ");
                  writer.close ();
                  JOptionPane.showMessageDialog (null, "Datos guardados exitosamente.");
               } catch (IOException ex) {
                  JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
               }
         });

         panelFormulario.add (botonGuardar);
      }

     public static void main (String [] args){
        VentanaPrincipal ventana = new VentanaPrincipal ();
        ventana.setVisible (true);

     }
}