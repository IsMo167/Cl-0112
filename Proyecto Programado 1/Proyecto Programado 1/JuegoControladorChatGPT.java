

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
    */
    public void jugarCuatroEnLinea() {
        CuatroEnLineaChatGPT juego = (CuatroEnLineaChatGPT) juegoActual;
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

<<<<<<< HEAD:Proyecto Programado 1/Proyecto Programado 1/JuegoControladorChatGPT.java
    public static void main(String[] args) {
        JuegoControladorChatGPT controlador = new JuegoControladorChatGPT();
=======
    /*public static void main(String[] args) {
        JuegoControlador controlador = new JuegoControlador();
>>>>>>> 24e1329f51b638d29327a43ff321cec7f9676dc3:Proyecto Programado 1/Proyecto Programado 1/JuegoControlador.java
        controlador.seleccionarJuego();
    }*/
}

