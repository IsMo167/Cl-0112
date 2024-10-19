import java.util.Scanner;

public class Gato {
    private char[][] tablero;
    private char jugadorActual;

    public Gato(char[][] tablero, char jugadorActual) {
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public void setJugadorActual(char jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public char getJugadorActual() {
        return jugadorActual;
    }

    // Recorre el tablero vacío y lo llena con "_", para mostrarlo al usuario
    public void llenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = '_';
            }
        }
    }

    // Imprime el estado actual del tablero
    public void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Realiza un movimiento en el tablero
    public void movimiento(int fila, int columna) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            System.out.println("Posición inválida. Intente de nuevo.");
            return;
        }
        if (tablero[fila][columna] == '_') {
            tablero[fila][columna] = jugadorActual;
            imprimirTablero();
        } else {
            System.out.println("Espacio ocupado");
        }
    }

    // Verifica si el tablero está lleno
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

    // Verifica si hay un ganador para el jugador actual
    public boolean ganador() {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                return true; // Ganador en fila
            } else if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual) {
                return true; // Ganador en columna
            }
        }
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
            return true; // Ganador en diagonal
        } else if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
            return true; // Ganador en la otra diagonal
        }
        return false;
    }

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        llenarTablero();
        imprimirTablero();
    
        while (true) {
            System.out.println("Jugador " + jugadorActual + ", ingrese la fila (1-3) y la columna (1-3) en la que desea poner su ficha: ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
    
            // Realizar el movimiento
            movimiento(fila - 1, columna - 1); // Ajusta la entrada del usuario
    
            // Verificar si el jugador actual ha ganado después del movimiento
            if (ganador()) {
                imprimirTablero(); // Mostrar el tablero final
                System.out.println("Felicidades           , " + jugadorActual + " ganó la partida");
                break;
            }
    
            // Verificar si el tablero está lleno
            if (tableroLleno()) {
                imprimirTablero(); // Mostrar el tablero final
                System.out.println("El tablero está lleno. Fin del juego.");
                break;
            }
    
            // Cambiar de jugador
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        }
    
        scanner.close();
    }
    
}

