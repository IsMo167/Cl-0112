import java.util.Scanner;

public class Gato {
    private char[][] tablero = new char[3][3];
    private char jugadorActual = 'X';

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

    public void llenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = '_';
            }
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

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
