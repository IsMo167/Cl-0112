

public class TicTacToe {
    private char[][] tablero;
    private char jugadorActual;

    public TicTacToe() {
        iniciarJuego();
    }

    public void iniciarJuego() {
        tablero = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
        jugadorActual = 'X';
    }

    public void hacerMovimiento(int fila, int columna) {
        if (tablero[fila][columna] == '-') {
            tablero[fila][columna] = jugadorActual;
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean esJuegoTerminado() {
        return esGanador() || esEmpate();
    }

    public boolean esGanador() {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) ||
                (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)) {
                return true;
            }
        }
        return (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) ||
               (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual);
    }

    public boolean esEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    return false;
                }
            }
        }
        return !esGanador();
    }

    public void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    public char getJugadorActual() {
        return jugadorActual;
    }
}
