import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Ventana de Gabriel");
        setSize(500, 400);
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

        // Añadiendo el JCheckBox para aceptar términos y condiciones
        JCheckBox checkBoxTerminos = new JCheckBox("Aceptar términos y condiciones");

        panelFormulario.add(etiquetaNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(etiquetaEmail);
        panelFormulario.add(campoEmail);
        panelFormulario.add(etiquetaTelefono);
        panelFormulario.add(campoTelefono);
        panelFormulario.add(etiquetaRol);
        panelFormulario.add(comboRoles); // Añadimos el JComboBox al panel
        panelFormulario.add(checkBoxTerminos); // Añadimos el JCheckBox al panel

        // Botón "Guardar"
        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(e -> {
            // Validaciones
            if (campoNombre.getText().isEmpty() || campoEmail.getText().isEmpty() || campoTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                return;
            }
            if (comboRoles.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un rol.");
                return;
            }
            if (!checkBoxTerminos.isSelected()) {
                JOptionPane.showMessageDialog(null, "Debes aceptar los términos y condiciones para continuar.");
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
                JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
            }
        });

        // Botón "Limpiar"
        JButton botonLimpiar = new JButton("Limpiar");
        botonLimpiar.addActionListener(e -> {
            campoNombre.setText("");
            campoEmail.setText("");
            campoTelefono.setText("");
            comboRoles.setSelectedIndex(0); // Reinicia el JComboBox a la primera opción
            checkBoxTerminos.setSelected(false); // Desmarca el JCheckBox
        });

        panelFormulario.add(botonGuardar);
        panelFormulario.add(botonLimpiar); // Añadimos el botón "Limpiar"
        add(panelFormulario);
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}




