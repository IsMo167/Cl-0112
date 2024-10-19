import java.util.Scanner;

public class CuatroEnLinea {
    private int[][] tablero;
    private int jugadorActual;

    public CuatroEnLinea() {
        iniciarJuego();
    }

    public void iniciarJuego() {
        // Inicializa el tablero de 6 filas y 7 columnas
        tablero = new int[6][7];
        // Llenar el tablero con ceros
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tablero[i][j] = 0;
            }
        }

        // Establecer el jugador actual (1 o 2)
        jugadorActual = 1; // Jugador 1 inicia el juego
    }

    public boolean hacerMovimiento(int columna) {
        // Verificar si la columna está dentro de los límites
        if (columna < 0 || columna >= 7) {
            return false; // Columna inválida
        }

        // Buscar la primera fila vacía en la columna especificada
        for (int fila = 5; fila >= 0; fila--) {
            if (tablero[fila][columna] == 0) {
                // Colocar el disco del jugador actual en la celda
                tablero[fila][columna] = jugadorActual;
                return true; // Movimiento realizado con éxito
            }
        }

        return false; // La columna está llena
    }

    public void mostrarTablero() {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
        System.out.println(); // Espacio adicional después de mostrar el tablero
    }

    public boolean esJuegoTerminado() {
        // Verificar filas, columnas y diagonales para 4 en línea
        return verificarFilas() || verificarColumnas() || verificarDiagonales();
    }

    private boolean verificarFilas() {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                if (tablero[fila][columna] != 0 &&
                    tablero[fila][columna] == tablero[fila][columna + 1] &&
                    tablero[fila][columna] == tablero[fila][columna + 2] &&
                    tablero[fila][columna] == tablero[fila][columna + 3]) {
                    return true; // Se encontró una fila ganadora
                }
            }
        }
        return false; // No se encontró ninguna fila ganadora
    }

    private boolean verificarColumnas() {
        for (int columna = 0; columna < 7; columna++) {
            for (int fila = 0; fila < 3; fila++) {
                if (tablero[fila][columna] != 0 &&
                    tablero[fila][columna] == tablero[fila + 1][columna] &&
                    tablero[fila][columna] == tablero[fila + 2][columna] &&
                    tablero[fila][columna] == tablero[fila + 3][columna]) {
                    return true; // Se encontró una columna ganadora
                }
            }
        }
        return false; // No se encontró ninguna columna ganadora
    }

    private boolean verificarDiagonales() {
        // Verificar diagonales de izquierda a derecha
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                if (tablero[fila][columna] != 0 &&
                    tablero[fila][columna] == tablero[fila + 1][columna + 1] &&
                    tablero[fila][columna] == tablero[fila + 2][columna + 2] &&
                    tablero[fila][columna] == tablero[fila + 3][columna + 3]) {
                    return true; // Se encontró una diagonal ganadora (izquierda a derecha)
                }
            }
        }

        // Verificar diagonales de derecha a izquierda
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 3; columna < 7; columna++) {
                if (tablero[fila][columna] != 0 &&
                    tablero[fila][columna] == tablero[fila + 1][columna - 1] &&
                    tablero[fila][columna] == tablero[fila + 2][columna - 2] &&
                    tablero[fila][columna] == tablero[fila + 3][columna - 3]) {
                    return true; // Se encontró una diagonal ganadora (derecha a izquierda)
                }
            }
        }

        return false; // No se encontró ninguna línea ganadora
    }

    public int getJugadorActual() {
        return jugadorActual;
    }

    public void cambiarJugador() {
        // Cambiar al jugador actual entre 1 y 2
        jugadorActual = (jugadorActual == 1) ? 2 : 1;
    }
}