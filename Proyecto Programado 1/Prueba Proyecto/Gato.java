import java.util.Scanner;

public class Gato {
    private char[][] tablero = new char[3][3];
    private char jugadorActual = 'X';

    public void setTablero(char tablero [][]){
        this.tablero= tablero;
     }

    public void setJugadorActual(char jugadorActual){
        this.jugadorActual = jugadorActual;
    }

    public char [][] getTablero(){
        return tablero;
    }

    public char getJugadorActual(){
        return jugadorActual;
    }
    
    public Gato(char [][] tablero, char jugadorActual){
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
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
        if (tablero[fila][columna] == '_') {
            tablero[fila][columna] = jugadorActual;
            imprimirTablero();
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X'; // Alterna el jugador
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

    // Verifica si hay un ganador
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
        boolean enJuego = true;
        llenarTablero();
        imprimirTablero();

        while (enJuego) {
            System.out.println("Ingrese la fila (1-3) y la columna (1-3) en la que desea poner su ficha: ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
            movimiento(fila - 1, columna - 1); // Ajusta la entrada del usuario

            if (ganador()) {
                System.out.println("Felicidades, ganó la partida!");
                break;
            } else if (tableroLleno()) {
                System.out.println("El tablero está lleno. Fin del juego.");
                break;
            }

            }
        
        System.out.println("Desea seguir jugando? 1 = Sí   2 = No");
        int decision = scanner.nextInt();
        if (decision == 2) {
            enJuego = false;
        }
        
        scanner.close();
    }
}
