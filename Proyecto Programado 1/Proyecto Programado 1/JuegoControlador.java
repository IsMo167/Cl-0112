

import java.util.Scanner;

public class JuegoControlador {
    private TicTacToe ticTacToe;
    private CuatroEnLinea cuatroEnLinea;
    private Object juegoActual;
    private Scanner scanner;

    public JuegoControlador() {
        ticTacToe = new TicTacToe();
        cuatroEnLinea = new CuatroEnLinea();
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
            juegoActual = ticTacToe;
            jugarTicTacToe();
        } else if (opcion == 2) {
            juegoActual = cuatroEnLinea;
            jugarCuatroEnLinea();
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public void jugarTicTacToe() {
        TicTacToe juego = (TicTacToe) juegoActual;
        while (!juego.esJuegoTerminado()) {
            juego.mostrarTablero();
            System.out.println("Turno del jugador " + juego.getJugadorActual());
            System.out.print("Ingrese fila y columna (1-3): ");
            int fila = scanner.nextInt()-1;
            int columna = scanner.nextInt()-1;
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

    public void jugarCuatroEnLinea() {
        CuatroEnLinea juego = (CuatroEnLinea) juegoActual;
        while (!juego.esJuegoTerminado()) {
            juego.mostrarTablero();
            System.out.println("Turno del jugador " + juego.getJugadorActual());
            System.out.print("Ingrese columna (1-7): ");
            int columna = scanner.nextInt()-1;
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

    /*public static void main(String[] args) {
        JuegoControlador controlador = new JuegoControlador();
        controlador.seleccionarJuego();
    }*/
}

