import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilaDePersonas {
    private JFrame ventana;
    private JPanel panel;
    private ColaPrioridad colaPersonas; // Cola de prioridad personalizada
    private NodoHistorial historialAtendidos; // Historial de clientes atendidos como lista enlazada
    private String rutaImagenPredeterminada = "C:\\Users\\XT\\Cl-0112\\Corrección Examen 2\\Uso con Interfaz (Distinto código sin)\\b2ap3_amp_sistema-informtico.png"; // Ruta de la imagen fija

    public FilaDePersonas() {
        // Inicializar ventana y panel
        ventana = new JFrame("Fila de Personas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000, 500);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        colaPersonas = new ColaPrioridad();
        historialAtendidos = null; // Inicializar el historial como una lista vacía

        // Crear los botones
        JButton botonAgregar = new JButton("Agregar Persona");
        botonAgregar.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
        botonAgregar.setForeground(Color.BLACK);
        botonAgregar.setBackground(new Color(47, 79, 79));

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPersonaInteractiva();
            }
        });

        JButton botonAtender = new JButton("Atender Cliente");
        botonAtender.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
        botonAtender.setForeground(Color.BLACK);
        botonAtender.setBackground(new Color(47, 79, 79));

        botonAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atenderCliente();
            }
        });

        // Crear el botón "Historial Atendidos"
        JButton botonHistorial = new JButton("Historial Atendidos");
        botonHistorial.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
        botonHistorial.setForeground(Color.BLACK);
        botonHistorial.setBackground(new Color(47, 79, 79));

        botonHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHistorialAtendidos();
            }
        });

        // Crear el botón "Salir"
        JButton salirBoton = new JButton("Salir");
        salirBoton.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
        salirBoton.setForeground(Color.BLACK);
        salirBoton.setBackground(new Color(128, 0, 0));

        // Acción del botón "Salir" para cerrar la ventana
        salirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?",
                        "Confirmación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    ventana.dispose(); // Cierra la ventana de Banco
                }
            }
        });

        // Agregar los botones al panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(botonAgregar);
        panelBotones.add(botonAtender);
        panelBotones.add(botonHistorial); // Agregar el botón Historial Atendidos
        panelBotones.add(salirBoton);

        // Agregar el panel y los botones a la ventana
        ventana.add(panel, BorderLayout.CENTER);
        ventana.add(panelBotones, BorderLayout.SOUTH);

        // Crear panel de indicaciones y agregarlo a la ventana
        agregarPanelIndicaciones();

        ventana.setVisible(true);
    }

    // Método para agregar el panel de indicaciones
    private void agregarPanelIndicaciones() {
        // Crear un panel para las indicaciones
        JPanel panelIndicaciones = new JPanel();
        panelIndicaciones.setBackground(new Color(255, 248, 220)); // Color de fondo suave

        // Crear el área de texto para las indicaciones
        JTextArea textoIndicaciones = new JTextArea();
        textoIndicaciones.setText(
                "Indicaciones de uso:\n" +
                        "         * Presione el botón agregarCliente si desea agregar un cliente más.\n" +
                        "         * Coloca el nombre del cliente.\n" +
                        "         * Coloca la prioridad del Cliente\n" +
                        "         * Si desea atender un cliente presiona el botón atender cliente\n\n" +
                        "         * Si desea salir del Banco, presiona Salir\n\n" +
                        "         ¡Disfruta del programa!"
        );

        // Ajustar la fuente y alineación del texto
        textoIndicaciones.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
        textoIndicaciones.setForeground(new Color(0, 0, 128)); // Color de texto azul oscuro
        textoIndicaciones.setMargin(new Insets(10, 10, 10, 10)); // Márgenes para crear espacio
        textoIndicaciones.setLineWrap(true); // Ajustar el texto al tamaño del área
        textoIndicaciones.setWrapStyleWord(true); // Cortar por palabras completas
        textoIndicaciones.setEditable(false); // Hacer que el área de texto no sea editable

        // Agregar el área de texto al panel
        panelIndicaciones.setLayout(new BorderLayout());
        panelIndicaciones.add(textoIndicaciones, BorderLayout.CENTER);

        // Agregar el panel de indicaciones a la ventana principal (por ejemplo, en la parte superior)
        ventana.add(panelIndicaciones, BorderLayout.NORTH);
    }

    // Método para pedir datos al usuario e ingresar una nueva persona
    public void agregarPersonaInteractiva() {
        // Pedir el nombre de la persona
        String nombre = JOptionPane.showInputDialog(ventana, "Ingrese el nombre de la persona:"); //Se pide el nombre de la persona
        //Para efectos de que el nombre no puede ser nulo o vacío
        if (nombre == null || nombre.trim().isEmpty()) { //Si nombre es nulo ó nombre es vacío
            JOptionPane.showMessageDialog(ventana, "El nombre no puede estar vacío."); //Imprime el mensaje "El nombre no puede ser vacío"
            return;
        }

        // Pedir la prioridad de la persona con validación de rango (1 a 4)
        int prioridad = pedirPrioridadValida();

        // Crear una nueva persona y agregarla a la cola con prioridad
        colaPersonas.agregarPersona(nombre, prioridad);

        // Actualizar la visualización en la interfaz gráfica
        actualizarPanel();
    }

    // Método para pedir y validar la prioridad entre 1 y 4
    private int pedirPrioridadValida() {
        int prioridad;
        while (true) { 
            String prioridadStr = JOptionPane.showInputDialog(ventana, "Ingrese la prioridad de la persona (1 a 4):"); //Se pide la prioridad de la persona
            //Se revisa que la prioridad debe ser si o si un int, y a la vez que se encuentre en el rango de 1 y 4
            try {
                prioridad = Integer.parseInt(prioridadStr); 
                if (prioridad >= 1 && prioridad <= 4) { //Si la prioridad está en el rango de 1 y 4, contándosen éstos extremos
                    break; // Prioridad válida, salir del bucle
                } else {
                    JOptionPane.showMessageDialog(ventana, "La prioridad debe estar entre 1 y 4. Inténtelo de nuevo."); //Entonces vuelve a pedir la prioridad
                }
            } catch (NumberFormatException e) { //Sino imprime el mensaje de que debe ingresar un número válido, funciona para que no se caiga el programa
                JOptionPane.showMessageDialog(ventana, "Debe ingresar un número válido para la prioridad.");
            }
        }
        return prioridad; //retorna la prioridad
    }

    // Método para atender al primer cliente en la cola
    public void atenderCliente() {
        // Sacar al primer cliente en la cola
        Persona atendido = colaPersonas.sacarPrimero();
        if (atendido == null) { 
            JOptionPane.showMessageDialog(ventana, "No hay más personas en la fila para atender.");
        } else {
            JOptionPane.showMessageDialog(ventana, "Se ha atendido a: " + atendido.getNombre());
            agregarAlHistorial(atendido); // Agregar al historial
        }

        // Actualizar la visualización en la interfaz gráfica
        actualizarPanel();
    }

    // Método para agregar al historial de personas atendidas
    private void agregarAlHistorial(Persona persona) {
        NodoHistorial nuevoNodo = new NodoHistorial(persona);

        if (historialAtendidos == null) {
            historialAtendidos = nuevoNodo; // Si el historial está vacío, simplemente lo asignamos
        } else {
            // Insertar al final del historial
            NodoHistorial actual = historialAtendidos;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para mostrar el historial de clientes atendidos, ordenado por prioridad
    private void mostrarHistorialAtendidos() {
        // Ordenar el historial de manera manual por prioridad de forma descendente
        historialAtendidos = ordenarHistorialPorPrioridad(historialAtendidos);

        // Construir el mensaje del historial ordenado
        StringBuilder historial = new StringBuilder("Historial de Clientes Atendidos:\n\n");
        NodoHistorial actual = historialAtendidos;
        while (actual != null) {
            historial.append("Nombre: ").append(actual.persona.getNombre())
                    .append(" | Prioridad: ").append(actual.persona.getPrioridad())
                    .append("\n");
            actual = actual.siguiente;
        }

        // Mostrar el historial en un cuadro de mensaje
        JOptionPane.showMessageDialog(ventana, historial.toString());
    }

    // Método para ordenar el historial de clientes atendidos por prioridad (descendente)
    private NodoHistorial ordenarHistorialPorPrioridad(NodoHistorial historial) {
        if (historial == null || historial.siguiente == null) {
            return historial; // Si el historial está vacío o tiene solo un elemento, no hay nada que ordenar
        }

        // Usamos el algoritmo de ordenación por burbuja
        boolean intercambio;
        do {
            intercambio = false;
            NodoHistorial actual = historial;
            while (actual.siguiente != null) {
                if (actual.persona.getPrioridad() < actual.siguiente.persona.getPrioridad()) {
                    // Intercambiar las personas si están en el orden incorrecto
                    Persona temp = actual.persona;
                    actual.persona = actual.siguiente.persona;
                    actual.siguiente.persona = temp;
                    intercambio = true;
                }
                actual = actual.siguiente;
            }
        } while (intercambio); // Repetir hasta que no haya más intercambios

        return historial;
    }

    // Método para actualizar la visualización de la interfaz
    private void actualizarPanel() {
        panel.removeAll(); // Limpiar panel actual

        // Mostrar las personas en la cola de prioridad
        NodoPersona actual = colaPersonas.frente;
        while (actual != null) {
            panel.add(crearPanelPersona(actual.persona.getNombre(), actual.persona.getPrioridad(), rutaImagenPredeterminada));
            actual = actual.siguiente;
        }

        panel.revalidate();
        panel.repaint();
    }

    // Método para crear un panel para mostrar la información de cada persona
    private JPanel crearPanelPersona(String nombre, int prioridad, String rutaImagen) {
        JPanel panelPersona = new JPanel();
        panelPersona.setLayout(new BoxLayout(panelPersona, BoxLayout.Y_AXIS));

        JLabel etiquetaNombre = new JLabel(nombre);
        etiquetaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaNombre.setFont(new Font("TimesNewRoman", Font.BOLD, 18));

        JLabel etiquetaPrioridad = new JLabel("Prioridad: " + prioridad);
        etiquetaPrioridad.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaPrioridad.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));

        // Cargar la imagen predeterminada y redimensionarla a 100x100 píxeles
        ImageIcon imagen = new ImageIcon(rutaImagen);
        Image imagenRedimensionada = imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(imagenRedimensionada);

        JLabel etiquetaImagen = new JLabel(imagen);
        etiquetaImagen.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelPersona.add(etiquetaNombre);
        panelPersona.add(Box.createVerticalStrut(10)); // Espacio entre el nombre y la imagen
        panelPersona.add(etiquetaImagen);
        panelPersona.add(Box.createVerticalStrut(10)); // Espacio entre la imagen y la prioridad
        panelPersona.add(etiquetaPrioridad);

        return panelPersona;
    }

    public static void main(String[] args) {
        new FilaDePersonas();
    }
}

// Clase para representar a una persona con nombre y prioridad
class Persona {
    private String nombre;
    private int prioridad;

    public Persona(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }
}

// Nodo de la cola de prioridad
class NodoPersona {
    Persona persona;
    NodoPersona siguiente;

    public NodoPersona(Persona persona) {
        this.persona = persona;
        this.siguiente = null;
    }
}

// Cola de prioridad utilizando lista enlazada
class ColaPrioridad {
    NodoPersona frente;

    public ColaPrioridad() {
        frente = null;
    }

    // Método para agregar una persona en la cola según su prioridad
    public void agregarPersona(String nombre, int prioridad) {
        Persona nuevaPersona = new Persona(nombre, prioridad);
        NodoPersona nuevoNodo = new NodoPersona(nuevaPersona);

        if (frente == null || frente.persona.getPrioridad() > prioridad) {
            // Insertar al inicio si la cola está vacía o la prioridad es menor que la del frente
            nuevoNodo.siguiente = frente;
            frente = nuevoNodo;
        } else {
            // Insertar en la posición correcta según la prioridad
            NodoPersona actual = frente;
            while (actual.siguiente != null && actual.siguiente.persona.getPrioridad() <= prioridad) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para sacar a la primera persona de la cola
    public Persona sacarPrimero() {
        if (frente == null) {
            return null; // Si no hay personas en la cola
        }

        Persona personaAtendida = frente.persona;
        frente = frente.siguiente; // Avanzar al siguiente en la cola

        return personaAtendida;
    }
}

// Nodo para el historial de personas atendidas
class NodoHistorial {
    Persona persona;
    NodoHistorial siguiente;

    public NodoHistorial(Persona persona) {
        this.persona = persona; 
        this.siguiente = null; //El siguiente se inicializa en null
    }
}
