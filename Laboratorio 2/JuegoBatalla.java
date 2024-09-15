import java.util.Scanner;

public class JuegoBatalla{
    private static Robot[] robotArray;
    public static void main (String []args){
        Scanner scanner = new Scanner (System.in);
        
        String nombreRobot;
        int puntosVidaRobot;
        int ataqueMaxRobot;
        int defensaRobot;
        int ataqueRobot;
        Robot [] robotArray;
                
        int opcion;
        do{
            System.out.println("------------Menú Batalla------------");
            System.out.println("1. Iniciar Batalla Robot");
            System.out.println("2. Mostrar Ganador");
            System.out.println("3. Detener Juego");
            opcion = scanner.nextInt();
            
            switch (opcion){
                case 1:
                    iniciarBatalla();
                    break;
                case 2:
                    mostrarGanador();
                    break;
                case 3:
                    System.out.println ("Saliendo del Juego...");
                    break;
                default:
                    System.out.println ("Opción inválida. Por Favor selecciones una opción válida");
            }
        } while (opcion != 3);
    }
    
    private static void iniciarBatalla(){
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Ingrese la cantidad de robots: ");
        int cantidadRobot = scanner.nextInt ();
        scanner.nextLine();    
        robotArray = new Robot [cantidadRobot];
        
        for (int i = 0; i < cantidadRobot; i++){
            System.out.print ("Ingrese el nombre del robot: ");
            String nombreRobot = scanner.nextLine (); 
            System.out.print ("Ingrese los puntos de vida: ");
            int puntosVidaRobot = scanner.nextInt ();
            System.out.print ("Ingrese un valor de ataque máximo (de 10 a 20): ");
            int ataqueMaxRobot = scanner.nextInt ();
            while (ataqueMaxRobot < 10 || 20 < ataqueMaxRobot) {    
            System.out.print ("VALOR INCORRECTO: Ingrese nuevamente el valor de ataque máximo (de 10 a 20): ");
            ataqueMaxRobot = scanner.nextInt ();      
            }
            scanner.nextLine();
            
            int ataqueRobot = (int)(Math.random()*(ataqueMaxRobot - 10 + 1)) + 10;
            System.out.println ("El ataque del robot " + nombreRobot + " es: " + ataqueRobot);
            
            System.out.println ("----------------------------------------------------------------------------");
            try{
                robotArray[i] = new Robot(nombreRobot,puntosVidaRobot, ataqueMaxRobot, ataqueRobot);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            while (cantidadRobotsVivos() > 1) {
                int j = 0;
                while (j < robotArray.length) {
                    if (cantidadRobotsVivos() <= 1) {
                        break;
                    }

                    if (robotArray[j] != null && robotArray[j].estaVivo()) {
                        Robot atacante = robotArray[j];
                        Robot victima = obtenerVictimaAleatoria(j);

                        if (victima != null) {
                            atacante.atacar(victima);
                            System.out.println(atacante.getNombre() + " atacó a " + victima.getNombre());
                        
                            if (!victima.estaVivo()) {
                                System.out.println(victima.getNombre() + " ha sido eliminado.");
                            }
                        }
                    }
                    j = j + 1; // Incrementar el índice de manera explícita
                }
            }
        }
    }
    
    private static Robot obtenerVictimaAleatoria (int atacante) {
        Scanner scanner = new Scanner(System.in);
        int victima;
        do {
            victima = (int)(Math.random()*(0 - (robotArray.length - 1) +1) + (robotArray.length - 1));
        } while (victima == atacante || victima < 0 || victima >= robotArray.length || robotArray[victima] == null || !robotArray[victima].estaVivo());
        return robotArray[victima];
    }
    
    private static int cantidadRobotsVivos() {
        int contador = 0;
        int i = 0;
        while (i < robotArray.length) {
            if (robotArray[i] != null && robotArray[i].estaVivo()) {
                contador = contador ++;
            }
            else{
                System.out.println ("No se puede ejecutar porque la cantidad de robots es nula o el robot no está vivo");
            }
            i = i ++;
        }
        return contador;
    }
    
    private static void mostrarGanador(){
        Robot ganador = null;
        int i = 0;
        while (i < robotArray.length) {
            if (robotArray[i] != null && robotArray[i].estaVivo()) {
                if (ganador == null) {
                    ganador = robotArray[i];
                } else {
                    ganador = null;
                    break;
                }
            }
            i = i + 1;
        }
        
        if (ganador != null) {
            System.out.println("El ganador es: " + ganador.getNombre());
        } else {
            System.out.println("No hay ganador.");
        }
    }
}