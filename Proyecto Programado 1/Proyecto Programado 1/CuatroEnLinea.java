

public class CuatroEnLinea {
    private char[][] tablero;
    private int jugadorActual;

    public CuatroEnLinea() {
        iniciarJuego();
    }

    public void iniciarJuego() {
        tablero = new char[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tablero[i][j] = '-';
            }
        }
        jugadorActual = 1;
    }

    public void hacerMovimiento(int columna) {
        for (int i = 5; i >= 0; i--) {
            if (tablero[i][columna] == '-') {
                tablero[i][columna] = (jugadorActual == 1) ? 'X' : 'O';
                break;
            }
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean esJuegoTerminado() {
        return esGanador() || esEmpate();
    }

    public boolean esGanador() {
        // Verificar horizontal, vertical y diagonal
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                char current = (jugadorActual == 1) ? 'X' : 'O';
                if (j + 3 < 7 && tablero[i][j] == current && tablero[i][j + 1] == current && tablero[i][j + 2] == current && tablero[i][j + 3] == current) return true;
                if (i + 3 < 6 && tablero[i][j] == current && tablero[i + 1][j] == current && tablero[i + 2][j] == current && tablero[i + 3][j] == current) return true;
                if (i + 3 < 6 && j + 3 < 7 && tablero[i][j] == current && tablero[i + 1][j + 1] == current && tablero[i + 2][j + 2] == current && tablero[i + 3][j + 3] == current) return true;
                if (i - 3 >= 0 && j + 3 < 7 && tablero[i][j] == current && tablero[i - 1][j + 1] == current && tablero[i - 2][j + 2] == current && tablero[i - 3][j + 3] == current) return true;
            }
        }
        return false;
    }

    public boolean esEmpate() {
        for (int j = 0; j < 7; j++) {
            if (tablero[0][j] == '-') {
                return false;
            }
        }
        return !esGanador();
    }

    public void cambiarJugador() {
        jugadorActual = (jugadorActual == 1) ? 2 : 1;
    }

    public int getJugadorActual() {
        return jugadorActual;
    }
}
