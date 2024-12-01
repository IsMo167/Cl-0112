import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Ventana de Gabriel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem nuevoItem = new JMenuItem("Nuevo");
        JMenuItem guardarItem = new JMenuItem("Guardar");
        JMenuItem salirItem = new JMenuItem("Salir");

        menuArchivo.add(nuevoItem);
        menuArchivo.add(guardarItem);
        menuArchivo.addSeparator();
        menuArchivo.add(salirItem);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        salirItem.addActionListener(e -> System.exit(0));

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));

        JLabel etiquetaNombre = new JLabel("Nombre");
        JTextField campoNombre = new JTextField(20);

        JLabel etiquetaEmail = new JLabel("Email: ");
        JTextField campoEmail = new JTextField(20);

        JLabel etiquetaTelefono = new JLabel("Teléfono: ");
        JTextField campoTelefono = new JTextField(20);

        JLabel etiquetaRol = new JLabel("Rol: ");
        String[] roles = { "Cliente", "Empleado", "Administrador" };
        JComboBox<String> comboRoles = new JComboBox<>(roles);

        // Se añade el JCheckBox para aceptar términos y condiciones
        JCheckBox checkBoxTerminos = new JCheckBox("Aceptar términos y condiciones");

        panelFormulario.add(etiquetaNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(etiquetaEmail);
        panelFormulario.add(campoEmail);
        panelFormulario.add(etiquetaTelefono);
        panelFormulario.add(campoTelefono);
        panelFormulario.add(etiquetaRol);
        panelFormulario.add(comboRoles); 
        panelFormulario.add(checkBoxTerminos); 

        // Botón Guardar
        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(e -> {
            
            if (campoNombre.getText().isEmpty() || campoEmail.getText().isEmpty() || campoTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor completar todos los campos.");
                return;
            }
            if (comboRoles.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un rol.");
                return;
            }
            if (!checkBoxTerminos.isSelected()) {
                JOptionPane.showMessageDialog(null, "Debes aceptar los términos y condiciones.");
                return;
            }

            String nombre = campoNombre.getText();
            String email = campoEmail.getText();
            String telefono = campoTelefono.getText();
            String rolSeleccionado = (String) comboRoles.getSelectedItem(); // Obtener el rol seleccionado
            
            try {
                FileWriter writer = new FileWriter("datos_usuario.txt", true);
                writer.write("\n ,   Nombre   ,    Email   ,   Teléfono   ,   Rol   , ");
                writer.write("\n , " + nombre + " , " + email + " , " + telefono + " , " + rolSeleccionado + " , ");
                writer.close();
                JOptionPane.showMessageDialog(null, "Datos guardados.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
            }
        });

        

        //Botón para limpiar el Formulario
        JButton botonLimpiarFormulario = new JButton("Limpiar Formulario");
        botonLimpiarFormulario.addActionListener(e -> {
            // Para limpiar los campos del formulario
            campoNombre.setText("");
            campoEmail.setText("");
            campoTelefono.setText("");
            comboRoles.setSelectedIndex(0); 
            checkBoxTerminos.setSelected(false); 
        });

        // Botón para limpiar el documento de texto, se añade para seguir practicando, además de que lo veo muy útil éste botón
        JButton botonLimpiarDocumentoDeTexto = new JButton("Limpiar el documento de texto");
        botonLimpiarDocumentoDeTexto.addActionListener(e -> {
            try {
                FileWriter writer = new FileWriter("datos_usuario.txt");
                writer.write(""); 
                writer.close();
                JOptionPane.showMessageDialog(null, "Contenido limpiado");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al limpiar.");
            } 
        });

        panelFormulario.add(botonGuardar); // Se añade el botón Guardar
        
        panelFormulario.add(botonLimpiarFormulario); // Para limpiar el Formulario

        panelFormulario.add(botonLimpiarDocumentoDeTexto); // Se añade el botón Limpiar Documento de texto
        add(panelFormulario);

    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}





