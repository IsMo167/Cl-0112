

import java.util.Scanner;

public class JuegoControladorChatGPT {
    //private TicTacToe ticTacToe;
    private CuatroEnLineaChatGPT cuatroEnLineaChatGPT;
    private Object juegoActual;
    private Scanner scanner;

    public JuegoControladorChatGPT() {
        //ticTacToe = new TicTacToe();
        cuatroEnLineaChatGPT = new CuatroEnLineaChatGPT();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Seleccione un juego:");
        System.out.println("1. Tic Tac Toe");
        System.out.println("2. Cuatro en Línea");
    }

    public void seleccionarJuego() {
        mostrarMenu();
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            //juegoActual = ticTacToe;
            //jugarTicTacToe();
        } else if (opcion == 2) {
            juegoActual = cuatroEnLineaChatGPT;
            jugarCuatroEnLinea();
        } else {
            System.out.println("Opción no válida.");
        }
    }

    /*public void jugarTicTacToe() {
        TicTacToe juego = (TicTacToe) juegoActual;
        while (!juego.esJuegoTerminado()) {
            juego.mostrarTablero();
            System.out.println("Turno del jugador " + juego.getJugadorActual());
            System.out.print("Ingrese fila y columna (0-2): ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
            juego.hacerMovimiento(fila, columna);
            if (!juego.esJuegoTerminado()) {
                juego.cambiarJugador();
            }
        }
        juego.mostrarTablero();
        if (juego.esGanador()) {
            System.out.println("¡Jugador " + juego.getJugadorActual() + " gana!");
        } else {
            System.out.println("¡Empate!");
        }
    }
    */
    public void jugarCuatroEnLinea() {
        CuatroEnLineaChatGPT juego = (CuatroEnLineaChatGPT) juegoActual;
        while (!juego.esJuegoTerminado()) {
            juego.mostrarTablero();
            System.out.println("Turno del jugador " + juego.getJugadorActual());
            System.out.print("Ingrese columna (0-6): ");
            int columna = scanner.nextInt();
            juego.hacerMovimiento(columna);
            if (!juego.esJuegoTerminado()) {
                juego.cambiarJugador();
            }
        }
        juego.mostrarTablero();
        if (juego.esGanador()) {
            System.out.println("¡Jugador " + juego.getJugadorActual() + " gana!");
        } else {
            System.out.println("¡Empate!");
        }
    }

    public static void main(String[] args) {
        JuegoControladorChatGPT controlador = new JuegoControladorChatGPT();
        controlador.seleccionarJuego();
    }
}

