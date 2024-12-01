import javax.swing.*;
import java.awt.*;

public class FilaDePersonas {
    public static void main(String[] args) {
        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Fila de Personas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 300); // Ajusta el tamaño de la ventana según lo necesites

        // Crear un JPanel para contener las imágenes y textos
        JPanel panel = new JPanel();
        
        // Establecer un layout para organizar los elementos en una fila
        panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Fila de izquierda a derecha
        
        // Crear los paneles para cada persona (con nombre, imagen y prioridad)
        panel.add(crearPanelPersona("Juan", 1, "C:\\Users\\XT\\Pictures\\b2ap3_amp_sistema-informtico.png"));
        panel.add(crearPanelPersona("Ana", 2, "C:\\Users\\XT\\Pictures\\b2ap3_amp_sistema-informtico.png"));
        panel.add(crearPanelPersona("Carlos", 3, "C:\\Users\\XT\\Pictures\\b2ap3_amp_sistema-informtico.png"));
        panel.add(crearPanelPersona("Laura", 4, "C:\\Users\\XT\\Pictures\\b2ap3_amp_sistema-informtico.png"));
        panel.add(crearPanelPersona("Gabriel", 5, "C:\\Users\\XT\\Pictures\\b2ap3_amp_sistema-informtico.png"));

        // Agregar el panel al JFrame
        ventana.add(panel);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }

    // Método para crear un panel con nombre, imagen y prioridad
    private static JPanel crearPanelPersona(String nombre, int prioridad, String rutaImagen) {
        // Crear el panel principal para la persona
        JPanel panelPersona = new JPanel();
        panelPersona.setLayout(new BoxLayout(panelPersona, BoxLayout.Y_AXIS)); // Organiza en columnas

        // Etiqueta de nombre
        JLabel etiquetaNombre = new JLabel(nombre);
        etiquetaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaNombre.setFont(new Font("TimesNewRoman", Font.BOLD, 18)); // Cambia el formato de la fuente

        // Etiqueta de prioridad
        JLabel etiquetaPrioridad = new JLabel("Prioridad: " + prioridad);
        etiquetaPrioridad.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaPrioridad.setFont(new Font("TimesNewRoman", Font.PLAIN, 14)); // Cambia el formato de la fuente

        // Cargar la imagen y redimensionarla
        ImageIcon imagen = new ImageIcon(rutaImagen);
        Image imagenRedimensionada = imagen.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(imagenRedimensionada);

        // Etiqueta para la imagen
        JLabel etiquetaImagen = new JLabel(imagen);
        etiquetaImagen.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Agregar todos los componentes al panel
        panelPersona.add(etiquetaNombre);
        panelPersona.add(Box.createVerticalStrut(10)); // Espacio entre el nombre y la imagen
        panelPersona.add(etiquetaImagen);
        panelPersona.add(Box.createVerticalStrut(10)); // Espacio entre la imagen y la prioridad
        panelPersona.add(etiquetaPrioridad);

        // Retornar el panel con todos los elementos
        return panelPersona;
    }
}
