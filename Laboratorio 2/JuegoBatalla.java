import java.util.Scanner;

public class JuegoBatalla {
    private static Robot[] robotArray;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println ("---------Bienvenid@s al Juego de los Robots---------");
        int opcion;
        do {
            System.out.println("------------Menú Batalla------------");
            System.out.println("1. Iniciar Batalla Robot");
            System.out.println("2. Mostrar Ganador");
            System.out.println("3. Detener Juego");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    iniciarBatalla();
                    break;
                case 2:
                    mostrarGanador();
                    break;
                case 3:
                    System.out.println("Saliendo del Juego...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione una opción válida");
            }
        } while (opcion != 3);
        
        scanner.close();
    }
    
    private static void iniciarBatalla() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de robots: ");
        int cantidadRobot = scanner.nextInt();
        scanner.nextLine();
        
        robotArray = new Robot[cantidadRobot];
        
        for (int i = 0; i < cantidadRobot; i++) {
            System.out.print("Ingrese el nombre del robot: ");
            String nombreRobot = scanner.nextLine();
            System.out.print("Ingrese los puntos de vida: ");
            int puntosVidaRobot = scanner.nextInt();
            System.out.print("Ingrese un valor de ataque máximo (de 10 a 20): ");
            int ataqueMaxRobot = scanner.nextInt();
            while (ataqueMaxRobot < 10 || ataqueMaxRobot > 20) {
                System.out.print("VALOR INCORRECTO: Ingrese nuevamente el valor de ataque máximo (de 10 a 20): ");
                ataqueMaxRobot = scanner.nextInt();
            }
            scanner.nextLine();
            
            int ataqueRobot = (int)(Math.random() * (ataqueMaxRobot - 10 + 1)) + 10;
            System.out.println("El ataque del robot " + nombreRobot + " es: " + ataqueRobot);
            
            System.out.println("----------------------------------------------------------------------------");
            try {
                robotArray[i] = new Robot(nombreRobot, puntosVidaRobot, ataqueMaxRobot, ataqueRobot);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Batalla
        while (cantidadRobotsVivos() > 1) {
            for (int j = 0; j < robotArray.length; j++) {
                if (cantidadRobotsVivos() <= 1) {
                    break;
                }
                if (robotArray[j] != null && robotArray[j].estaVivo()) {
                    Robot atacante = robotArray[j];
                    Robot victima = obtenerVictimaAleatoria(j);
                    
                    if (victima != null) {
                        atacante.atacar(victima);
                        System.out.println("----------------------------------------------------------------------------");
                        System.out.println(atacante.getNombre() + " atacó a " + victima.getNombre());
                        System.out.println("----------------------------------------------------------------------------");
            
                        if (!victima.estaVivo()) {
                            System.out.println("----------------------------------------------------------------------------");
                            System.out.println(victima.getNombre() + " ha sido eliminado.");
                            System.out.println("----------------------------------------------------------------------------");
            
                        }
                    }
                }
            }
        }
        
        scanner.close();
    }
    
    private static Robot obtenerVictimaAleatoria(int atacante) {
        int victima;
        do {
            victima = (int)(Math.random() * robotArray.length);
        } while (victima == atacante || robotArray[victima] == null || !robotArray[victima].estaVivo());
        return robotArray[victima];
    }
    
    private static int cantidadRobotsVivos() {
        int contador = 0;
        for (int i = 0; i < robotArray.length; i++) {
            if (robotArray[i] != null && robotArray[i].estaVivo()) {
                contador++;
            }
        }
        return contador;
    }
    
    private static void mostrarGanador() {
        Robot ganador = null;
        for (int i = 0; i < robotArray.length; i++) {
            if (robotArray[i] != null && robotArray[i].estaVivo()) {
                if (ganador == null) {
                    ganador = robotArray[i];
                } else {
                    ganador = null;
                    break;
                }
            }
        }
        
        if (ganador != null) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("El ganador es: " + ganador.getNombre());
            System.out.println("----------------------------------------------------------------------------");
        } else {
            System.out.println("No hay ganador.");
        }
    }
}