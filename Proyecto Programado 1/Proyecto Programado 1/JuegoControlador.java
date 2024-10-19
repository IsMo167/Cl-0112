import java.util.Scanner;
/**
 * @class JuegoControlador
 * @brief Clase que gestiona la interacción entre los juegos Gato y Cuatro en Línea.
 *
 * Esta clase controla el flujo del juego, permitiendo a los usuarios seleccionar 
 * entre jugar a Gato o Cuatro en Línea. También maneja la inicialización de los 
 * juegos y el cambio de turnos entre los jugadores.
 */
public class JuegoControlador {
    private Gato gato; ///< Instancia del juego Gato.
    private CuatroEnLinea cuatroEnLinea; ///< Instancia del juego Cuatro en Línea.
    private Object juegoActual; ///< Referencia al juego actual, que puede ser Gato o Cuatro en Línea.

    /**
     * @brief Constructor de la clase JuegoControlador.
     * @param tablero Matriz que representa el estado inicial del tablero para Gato.
     * @param jugadorActual Carácter que indica el jugador que inicia el juego.
     *
     * Este constructor crea nuevas instancias de los juegos Gato y Cuatro en Línea.
     */
    public JuegoControlador(char[][] tablero, char jugadorActual) {
        gato = new Gato(tablero, jugadorActual);
        cuatroEnLinea = new CuatroEnLinea();
    }

    /**
     * @brief Muestra el menú de selección de juegos en la consola.
     *
     * Este método imprime las opciones disponibles para que el usuario elija entre 
     * los juegos Gato, Cuatro en Línea o salir del programa.
     */
    public void mostrarMenu() {
        System.out.println("Seleccione el juego:");
        System.out.println("1. Gato");
        System.out.println("2. Cuatro en Línea");
        System.out.println("3. Salir");
    }

    /**
     * @brief Permite al usuario seleccionar un juego.
     *
     * Dependiendo de la opción elegida por el usuario, este método inicializa el 
     * juego correspondiente y gestiona la interacción. Utiliza un switch para 
     * ejecutar acciones específicas según la elección del usuario.
     */
    public void seleccionarJuego() {
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                juegoActual = gato;
                gato.iniciarJuego(this); // Iniciar el juego de Gato
                break;        
            case 2:
                juegoActual = cuatroEnLinea;
                jugarCuatroEnLinea(); // Iniciar el juego de Cuatro en Línea
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                seleccionarJuego(); // Repetir selección si la opción no es válida
        }
    }

    /**
     * @brief Inicia el juego de Cuatro en Línea.
     *
     * Este método gestiona el flujo del juego de Cuatro en Línea, mostrando el 
     * tablero, solicitando la columna donde el jugador desea colocar su ficha y 
     * verificando si el juego ha terminado. Si el movimiento es inválido, se 
     * solicita al usuario que intente de nuevo.
     */
    private void jugarCuatroEnLinea() {
        cuatroEnLinea.iniciarJuego();
        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            cuatroEnLinea.mostrarTablero();
            System.out.println("Jugador " + cuatroEnLinea.getJugadorActual() + ", elige una columna (1-7): ");
            int columna = scanner.nextInt();

            if (cuatroEnLinea.hacerMovimiento(columna-1)) {
                if (cuatroEnLinea.esJuegoTerminado()) {
                    cuatroEnLinea.mostrarTablero();
                    System.out.println("¡Jugador " + cuatroEnLinea.getJugadorActual() + " gana!");
                    juegoTerminado = true;
                } 
                else {
                    cuatroEnLinea.cambiarJugador(); // Cambiar turno
                }
            } else {
                System.out.println("Movimiento inválido, intenta de nuevo.");
            }
        }
        
        System.out.println("Desea seguir jugando? 1 = Sí   2 = No");
        int decision = scanner.nextInt();
        if (decision == 1) {
            mostrarMenu();
            seleccionarJuego(); // Volver a mostrar el menú
        }
        if (decision == 2) {
            juegoTerminado = true; // Terminar el juego
        }
    }

    /**
     * @brief Método main para inicializar el programa.
     *
     * Este método inicializa el tablero vacío y establece el jugador inicial 
     * antes de crear una nueva instancia del controlador y mostrar el menú 
     * de selección de juegos.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Inicializar el tablero vacío y el jugador inicial
        char[][] tableroInicial = new char[3][3]; // Tablero vacío
        char jugadorInicial = 'X'; // Jugador inicial
        
        // Crear el controlador pasando el tablero y el jugador
        JuegoControlador controlador = new JuegoControlador(tableroInicial, jugadorInicial);
        controlador.mostrarMenu();
        controlador.seleccionarJuego(); // Iniciar la selección de juego
    }
}
