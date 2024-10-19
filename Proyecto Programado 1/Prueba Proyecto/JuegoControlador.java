import java.util.Scanner;
//Clase Controlador
public class JuegoControlador {
    private Gato gato;
    private CuatroEnLinea cuatroEnLinea;
    private Object juegoActual; // Puede ser Gato o CuatroEnLinea
    
    //Método que instacia un nuevo juego de Gato y Cuatro en Linea
    public JuegoControlador(char[][] tablero, char jugadorActual) {
        gato = new Gato(tablero, jugadorActual);
        cuatroEnLinea = new CuatroEnLinea();
    }

    //Muestra el menú con las opciones de lo que el usuario quiera elegir
    public void mostrarMenu() {
        System.out.println("Seleccione el juego:");
        System.out.println("1. Gato");
        System.out.println("2. Cuatro en Línea");
        System.out.println("3. Salir");
    }

    //Segun la opción que eligió el usuario, por medio del switch según la opción hace acciones específicas
    public void seleccionarJuego() {
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                juegoActual = gato;
                gato.iniciarJuego();
                break;
            case 2:
                juegoActual = cuatroEnLinea;
                jugarCuatroEnLinea();
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                seleccionarJuego();
        }
    }

    /*Si el usuario eligió el número 2, se jugará Cuatro en Linea, si el juego no ha terminado, entonces
     * se ejecuta el ciclo while, del cual muestra el tablero y luego cual jugador inicia, y le pregunta al usuario 
     * la columna de 0 a 6 que desea poner la ficha, lo que procede a hacer el movimiento y si el juego terminó muestra
     * el ganador y si el movimiento es inválito imprime que es inválito e intentarlo nuevamente
     */
    private void jugarCuatroEnLinea() {
        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            cuatroEnLinea.mostrarTablero();
            System.out.println("Jugador " + cuatroEnLinea.getJugadorActual() + ", elige una columna (0-6): ");
            int columna = scanner.nextInt();

            if (cuatroEnLinea.hacerMovimiento(columna)) {
                if (cuatroEnLinea.esJuegoTerminado()) {
                    cuatroEnLinea.mostrarTablero();
                    System.out.println("¡Jugador " + cuatroEnLinea.getJugadorActual() + " gana!");
                    juegoTerminado = true;
                } 
                else {
                    cuatroEnLinea.cambiarJugador(); // Cambiar turno
                }
            } else {
                System.out.println("Movimiento inválido, intenta de nuevo.");
            }
        }
        
        System.out.println("Desea seguir jugando? 1 = Sí   2 = No");
        int decision = scanner.nextInt();
        if (decision ==1){
            mostrarMenu ();
            seleccionarJuego ();
        }
        if (decision == 2) {
            juegoTerminado = true;
        }
        
    }
    
    //Método Main, inicializa el programa, creando un nuevo juego...
    public static void main(String[] args) {
        // Inicializar el tablero vacío y el jugador inicial
        char[][] tableroInicial = new char[3][3]; // Tablero vacío
        char jugadorInicial = 'X'; // Jugador inicial

        // Crear el controlador pasando el tablero y el jugador
        JuegoControlador controlador = new JuegoControlador(tableroInicial, jugadorInicial);
        controlador.mostrarMenu();
        controlador.seleccionarJuego();
    }
}



