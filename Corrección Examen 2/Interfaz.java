import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz {
    // Variables globales para el tamaño de la celda y la fuente
    private static int tamañoCelda = 80; // Tamaño por defecto de la celda
    private static int tamañoFuente = 20; // Tamaño de la fuente por defecto

    // Variables para almacenar el resultado de los tableros
    private static String[][] tableroRecursivo;
    private static String[][] tableroIterativo;

    public static void main(String[] args) {
        // Crear la ventana
        JFrame ventana = new JFrame("Ventana con Menú");

        // Configurar el cierre de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer tamaño de la ventana
        ventana.setSize(1000, 700);

        // Crear la barra de menú (JMenuBar)
        JMenuBar barraDeMenu = new JMenuBar();

        // Crear el menú "Archivo" (JMenu)
        JMenu archivoMenu = new JMenu("Caballos");

        // Cambiar el color de fondo y el formato de "Archivo"
        archivoMenu.setFont(new Font("TimesNewRoman", Font.BOLD, 24)); // Cambiar la fuente
        archivoMenu.setForeground(new Color(128, 0, 0)); // Cambiar el color de texto

        // Crear el menú para "Caballo Recursivo"
        JMenu caballoRecursivoMenu = new JMenu("Caballo Recursivo");
        caballoRecursivoMenu.setFont(new Font("TimesNewRoman", Font.BOLD, 20)); // Cambiar la fuente
        caballoRecursivoMenu.setForeground(new Color(128, 0, 0)); // Cambiar el color de texto
        JMenuItem caballoRecursivoItem = new JMenuItem("Iniciar Caballo Recursivo");
        caballoRecursivoItem.setFont(new Font("TimesNewRoman", Font.BOLD, 16)); // Cambiar la fuente
        caballoRecursivoItem.setForeground(new Color(25, 25, 112)); // Cambiar el color de texto
        JMenu tamañoCaballoRecursivoMenu = new JMenu("Tamaño");

        // Crear submenú para cambiar el tamaño del tablero en "Caballo Recursivo"
        JMenuItem tamañoPequeñoRecursivo = new JMenuItem("Pequeño");
        JMenuItem tamañoMedianoRecursivo = new JMenuItem("Mediano");
        JMenuItem tamañoGrandeRecursivo = new JMenuItem("Grande");

        // Agregar los ítems al submenú de tamaño
        tamañoCaballoRecursivoMenu.add(tamañoPequeñoRecursivo);
        tamañoCaballoRecursivoMenu.add(tamañoMedianoRecursivo);
        tamañoCaballoRecursivoMenu.add(tamañoGrandeRecursivo);

        // Agregar los ítems al menú "Caballo Recursivo"
        caballoRecursivoMenu.add(caballoRecursivoItem);
        caballoRecursivoMenu.add(tamañoCaballoRecursivoMenu);

        // Crear el menú para "Caballo Iterativo"
        JMenu caballoIterativoMenu = new JMenu("Caballo Iterativo");
        caballoIterativoMenu.setFont(new Font("TimesNewRoman", Font.BOLD, 20)); // Cambiar la fuente
        caballoIterativoMenu.setForeground(new Color(128, 0, 0)); // Cambiar el color de texto
        JMenuItem caballoIterativoItem = new JMenuItem("Iniciar Caballo Iterativo");
        caballoIterativoItem.setFont(new Font("TimesNewRoman", Font.BOLD, 16)); // Cambiar la fuente
        caballoIterativoItem.setForeground(new Color(25, 25, 112)); // Cambiar el color de texto
        JMenu tamañoCaballoIterativoMenu = new JMenu("Tamaño");

        // Crear submenú para cambiar el tamaño del tablero en "Caballo Iterativo"
        JMenuItem tamañoPequeñoIterativo = new JMenuItem("Pequeño");
        JMenuItem tamañoMedianoIterativo = new JMenuItem("Mediano");
        JMenuItem tamañoGrandeIterativo = new JMenuItem("Grande");

        // Agregar los ítems al submenú de tamaño
        tamañoCaballoIterativoMenu.add(tamañoPequeñoIterativo);
        tamañoCaballoIterativoMenu.add(tamañoMedianoIterativo);
        tamañoCaballoIterativoMenu.add(tamañoGrandeIterativo);

        // Agregar los ítems al menú "Caballo Iterativo"
        caballoIterativoMenu.add(caballoIterativoItem);
        caballoIterativoMenu.add(tamañoCaballoIterativoMenu);

        // Agregar los menús al menú principal
        archivoMenu.add(caballoRecursivoMenu);
        archivoMenu.add(caballoIterativoMenu);

        // Agregar el menú a la barra de menú
        barraDeMenu.add(archivoMenu);

        // Asignar la barra de menú a la ventana
        ventana.setJMenuBar(barraDeMenu);

        // Crear un panel para las indicaciones
        JPanel panelIndicaciones = new JPanel();
        panelIndicaciones.setBackground(new Color(255, 248, 220)); // Color de fondo suave

        // Crear el área de texto para las indicaciones
        JTextArea textoIndicaciones = new JTextArea();
        textoIndicaciones.setText(
            "Indicaciones de uso:\n" +
            "         * Presione el menú que se muestra arriba al extremo izquierdo. Sea Caballos o Banco\n" +
            "         * Si elije Caballos: presione el tipo de Caballo sea Recursivo o Iterativo.\n" +
            "         * Si deseas iniciar con el Caballo según el tipo, presione iniciar caballo _______.\n" +
            "         * Si deseas cambiar el tamaño de los números presione en el submenú correspondiente.\n\n" +
            "         * Si desea limpiar la ventana, presione el botón vaciar, junto a Sí en la ventana de confirmación.\n\n" +
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

        // Crear un panel donde se mostrará el tablero
        JPanel tableroPanel = new JPanel();
        ventana.add(tableroPanel, BorderLayout.CENTER);

        // Crear un panel con un botón "Vaciar"
        JPanel panelBotones = new JPanel();
        JButton vaciarButton = new JButton("Vaciar");

        // Establecer el fondo del panel de botones
        panelBotones.setBackground(new Color(255, 222, 173));

        // Estilo del botón Vaciar
        vaciarButton.setPreferredSize(new Dimension(250, 75));
        vaciarButton.setBackground(new Color(100, 149, 237)); // Color de fondo azul
        vaciarButton.setForeground(new Color(25, 25, 112)); // Color de texto blanco
        vaciarButton.setFont(new Font("TimesNewRoman", Font.BOLD, 40));

        panelBotones.add(vaciarButton);
        ventana.add(panelBotones, BorderLayout.SOUTH);

        // Mostrar la ventana
        ventana.setVisible(true);

        // Acciones para "Caballo Recursivo"
        caballoRecursivoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ejecutar siempre la clase CaballoRecursivo y mostrar el tablero
                tableroRecursivo = CaballoRecursivo.resolverRecursivoTablero();
                mostrarTableroEnInterfaz(tableroPanel, tableroRecursivo);
            }
        });

        // Acciones para "Caballo Iterativo"
        caballoIterativoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ejecutar siempre la clase CaballoIterativo y mostrar el tablero
                if (tableroIterativo == null) {
                    SwingWorker<String[][], Void> worker = new SwingWorker<String[][], Void>() {
                        @Override
                        protected String[][] doInBackground() throws Exception {
                            return CaballoIterativo.resolverIterativoTablero();
                        }

                        @Override
                        protected void done() {
                            try {
                                tableroIterativo = get();
                                mostrarTableroEnInterfaz(tableroPanel, tableroIterativo);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    };
                    worker.execute();
                } else {
                    mostrarTableroEnInterfaz(tableroPanel, tableroIterativo);
                }
            }
        });

        // Cambiar tamaño del tablero en "Caballo Recursivo"
        tamañoPequeñoRecursivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamañoCelda = 60;
                tamañoFuente = 15;
                // Solo redibujar el tablero sin ejecutar el algoritmo
                if (tableroRecursivo != null) {
                    mostrarTableroEnInterfaz(tableroPanel, tableroRecursivo);
                }
            }
        });

        tamañoMedianoRecursivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamañoCelda = 80;
                tamañoFuente = 20;
                // Solo redibujar el tablero sin ejecutar el algoritmo
                if (tableroRecursivo != null) {
                    mostrarTableroEnInterfaz(tableroPanel, tableroRecursivo);
                }
            }
        });

        tamañoGrandeRecursivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamañoCelda = 100;
                tamañoFuente = 25;
                // Solo redibujar el tablero sin ejecutar el algoritmo
                if (tableroRecursivo != null) {
                    mostrarTableroEnInterfaz(tableroPanel, tableroRecursivo);
                }
            }
        });

        // Cambiar tamaño del tablero en "Caballo Iterativo"
        tamañoPequeñoIterativo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamañoCelda = 60;
                tamañoFuente = 15;
                // Solo redibujar el tablero sin ejecutar el algoritmo
                if (tableroIterativo != null) {
                    mostrarTableroEnInterfaz(tableroPanel, tableroIterativo);
                }
            }
        });

        tamañoMedianoIterativo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamañoCelda = 80;
                tamañoFuente = 20;
                // Solo redibujar el tablero sin ejecutar el algoritmo
                if (tableroIterativo != null) {
                    mostrarTableroEnInterfaz(tableroPanel, tableroIterativo);
                }
            }
        });

        tamañoGrandeIterativo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamañoCelda = 100;
                tamañoFuente = 25;
                // Solo redibujar el tablero sin ejecutar el algoritmo
                if (tableroIterativo != null) {
                    mostrarTableroEnInterfaz(tableroPanel, tableroIterativo);
                }
            }
        });

        // Agregar acción para el botón "Vaciar"
        vaciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar el cuadro de confirmación
                int opcion = JOptionPane.showConfirmDialog(ventana, "¿Estás seguro de que quieres vaciar el tablero?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    // Si la opción es "Sí", vaciar los tableros y actualizar la interfaz
                    tableroRecursivo = null;
                    tableroIterativo = null;
                    tableroPanel.removeAll();
                    tableroPanel.revalidate();
                    tableroPanel.repaint();
                }
            }
        });

        
        Box.createRigidArea(new Dimension(50, 0));

        // Crear el menú "Banco"
        JMenu bancoMenu = new JMenu("Banco");
        bancoMenu.setFont(new Font("TimesNewRoman", Font.BOLD, 24)); // Cambiar la fuente
        bancoMenu.setForeground(new Color(128, 0, 0)); // Cambiar el color de texto

        // Crear el botón "Salir"
        JMenuItem salirItem = new JMenuItem("Salir");
        salirItem.setFont(new Font("TimesNewRoman", Font.BOLD, 16)); // Cambiar la fuente
        salirItem.setForeground(new Color(25, 25, 112)); // Cambiar el color de texto

        // Agregar la acción al botón "Salir" que cierra la ventana
        salirItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(ventana, "¿Estás seguro de que quieres salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    ventana.dispose(); // Cerrar la ventana
                }
            }
        });
 

        // Crear un ítem en el menú "Banco" que abrirá la ventana de FilaDePersonas
        JMenuItem filaDePersonasItem = new JMenuItem("Ver Fila de Personas");
        filaDePersonasItem.setFont(new Font("TimesNewRoman", Font.BOLD, 16)); // Cambiar la fuente
        filaDePersonasItem.setForeground(new Color(25, 25, 112)); // Cambiar el color de texto

        // Agregar la acción para abrir la ventana de FilaDePersonas
        filaDePersonasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar la ventana de FilaDePersonas
                new FilaDePersonas();
            }
        });

        // Agregar el ítem al menú "Banco"
        bancoMenu.add(filaDePersonasItem);

        // Agregar el menú "Banco" a la barra de menú
        barraDeMenu.add(bancoMenu);

    }

    // Método para mostrar el tablero en la interfaz
    private static void mostrarTableroEnInterfaz(JPanel tableroPanel, String[][] tablero) {
        tableroPanel.removeAll();
        tableroPanel.setLayout(new GridLayout(tablero.length, tablero[0].length));

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                JLabel celda = new JLabel(tablero[i][j], SwingConstants.CENTER);
                celda.setPreferredSize(new Dimension(tamañoCelda, tamañoCelda));
                celda.setFont(new Font("TimesNewRoman", Font.PLAIN, tamañoFuente));

                // Establecer el color de fondo
                if ((i + j) % 2 == 0) {
                    celda.setBackground(Color.WHITE);
                    celda.setForeground(Color.BLACK); // Texto negro en casillas blancas
                } else {
                    celda.setBackground(Color.BLACK);
                    celda.setForeground(Color.WHITE); // Texto blanco en casillas negras
                }
                celda.setOpaque(true);

                // Añadir la celda al panel
                tableroPanel.add(celda);
            }
        }
        tableroPanel.revalidate();
        tableroPanel.repaint();
    }
}
