import java.util.Scanner;
/**
 * @class Gato
 * @brief Clase para gestionar el juego de Gato (Tres en raya).
 * 
 * Esta clase permite crear un tablero de juego, realizar movimientos y determinar 
 * el estado del juego. Los jugadores pueden alternar entre 'X' y 'O', y la clase 
 * proporciona métodos para verificar si hay un ganador o si el tablero está lleno.
 * 
 * El tablero se representa como una matriz de caracteres y se inicializa con guiones bajos 
 * ('_') para indicar posiciones vacías. El jugador actual se almacena como un carácter 
 * ('X' o 'O').
 */
public class Gato {
    private char[][] tablero = new char[3][3]; ///< Tablero de juego de 3x3.
    private char jugadorActual = 'X'; ///< Jugador actual, inicia como 'X'.

    /**
     * @brief Constructor de la clase Gato.
     * @param tablero Matriz que representa el estado inicial del tablero.
     * @param jugadorActual Carácter que indica el jugador que inicia el juego.
     */
    public Gato(char[][] tablero, char jugadorActual) {
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
    }

    /**
     * @brief Establece un nuevo tablero.
     * @param tablero Nuevo estado del tablero.
     */
    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    /**
     * @brief Establece el jugador actual.
     * @param jugadorActual Carácter que indica el jugador actual.
     */
    public void setJugadorActual(char jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    /**
     * @brief Obtiene el estado actual del tablero.
     * @return Matriz de caracteres que representa el tablero.
     */
    public char[][] getTablero() {
        return tablero;
    }

    /**
     * @brief Obtiene el jugador actual.
     * @return Carácter que indica el jugador actual ('X' o 'O').
     */
    public char getJugadorActual() {
        return jugadorActual;
    }

    /**
     * @brief Llena el tablero con guiones bajos ('_') indicando posiciones vacías.
     */
    public void llenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = '_';
            }
        }
    }

    /**
     * @brief Imprime el estado actual del tablero en la consola.
     */
    public void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @brief Realiza un movimiento en el tablero.
     * @param fila Fila en la que el jugador desea colocar su ficha.
     * @param columna Columna en la que el jugador desea colocar su ficha.
     * @return true si el movimiento fue exitoso, false si la posición es inválida o está ocupada.
     */
    public boolean movimiento(int fila, int columna) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            System.out.println("Posición inválida. Intente de nuevo.");
            return false;
        }
        if (tablero[fila][columna] == '_') {
            tablero[fila][columna] = jugadorActual;
            return true;
        } else {
            System.out.println("Espacio ocupado");
            return false;
        }
    }

    /**
     * @brief Verifica si el tablero está lleno.
     * @return true si el tablero está lleno, false si hay espacios vacíos.
     */
    public boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @brief Verifica si hay un ganador.
     * @return true si el jugador actual ha ganado, false en caso contrario.
     */
    public boolean ganador() {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                return true;
            } else if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual) {
                return true;
            }
        }
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
            return true;
        } else if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
            return true;
        }
        return false;
    }

    /**
     * @brief Inicia el juego, solicitando movimientos a los jugadores.
     * @param controlador Controlador que gestiona la interacción con el usuario.
     */
    public void iniciarJuego(JuegoControlador controlador) {
        Scanner scanner = new Scanner(System.in);
        llenarTablero();
        imprimirTablero();

        while (true) {
            System.out.println("Jugador " + jugadorActual + ", ingrese la fila (1-3) y la columna (1-3) en la que desea poner su ficha: ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            if (movimiento(fila - 1, columna - 1)) {
                imprimirTablero();

                if (ganador()) {
                    System.out.println("¡Felicidades, " + jugadorActual + " ganó la partida!");
                    break;
                }

                if (tableroLleno()) {
                    System.out.println("El tablero está lleno. ¡Es un empate!");
                    break;
                }

                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
            }
        }

        // Pregunta si desea jugar de nuevo
        System.out.println("¿Desea volver a jugar? 1 = Sí   2 = No");
        int decision = scanner.nextInt();
        if (decision == 1) {
            controlador.mostrarMenu();
            controlador.seleccionarJuego();
        } else {
            System.out.println("Saliendo del juego de Gato...");
        }

        scanner.close();
    }
}
