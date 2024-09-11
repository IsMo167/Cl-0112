import java.util.Scanner;

public class JuegoBatalla{
    public static void main (String []args){
        Scanner scanner = new Scanner (System.in);
        
        String nombreRobot;
        int puntosVidaRobot;
        int ataqueRobot;
        int defensaRobot;
        
        System.out.println ("Bienveni@s al juego Batalla de Robots");
        System.out.println ("Favor antes de empezar, selecciona las características de cada robot");
        System.out.println ("-----------------------------------------------------------------------");

        System.out.print ("Ingrese el nombre nombre del robot 1: ");
        nombreRobot = scanner.nextLine ();
        System.out.print ("Ingrese los puntos de vida del robot 1 (50-100): ");
        puntosVidaRobot = scanner.nextInt ();
        System.out.print ("Ingrese la fuerza del ataque del robot 1 (10-20): ");
        ataqueRobot = scanner.nextInt ();
        System.out.print ("Ingrese la defensa del robot 1 (1-10): ");
        defensaRobot = scanner.nextInt ();
        Robot robot1 = new Robot (nombreRobot,puntosVidaRobot,ataqueRobot,defensaRobot);
        System.out.println ("-----------------------------------------------------------------------");

        System.out.print ("Ingrese el nombre nombre del robot 2: ");
        nombreRobot = scanner.nextLine ();
        System.out.print ("Ingrese los puntos de vida del robot 2 (50-100): ");
        puntosVidaRobot = scanner.nextInt ();
        System.out.print ("Ingrese la fuerza del ataque del robot 2 (10-20): ");
        ataqueRobot = scanner.nextInt ();
        System.out.print ("Ingrese la defensa del robot 2 (1-10): ");
        defensaRobot = scanner.nextInt ();
        Robot robot2 = new Robot (nombreRobot,puntosVidaRobot,ataqueRobot,defensaRobot);
        System.out.println ("-----------------------------------------------------------------------");

        System.out.print ("Ingrese el nombre nombre del robot 3: ");
        nombreRobot = scanner.nextLine ();
        System.out.print ("Ingrese los puntos de vida del robot 3 (50-100): ");
        puntosVidaRobot = scanner.nextInt ();
        System.out.print ("Ingrese la fuerza del ataque del robot 3 (10-20): ");
        ataqueRobot = scanner.nextInt ();
        System.out.print ("Ingrese la defensa del robot 3 (1-10): ");
        defensaRobot = scanner.nextInt ();
        Robot robot3 = new Robot (nombreRobot,puntosVidaRobot,ataqueRobot,defensaRobot);
        System.out.println ("-----------------------------------------------------------------------");

        int opcion;
        do{
            System.out.print("------------Menú Batalla------------");
            System.out.print("1. Mostrar estado Robot");
            System.out.print("2. Atacar Robot");
            System.out.print("3. Defender Robot");
            System.out.print("4. Detener Juego");
            opcion = scanner.nextInt();
            
            switch (opcion){
                case 1:
                    mostrarEstadoRobot (seleccionarRobot (scanner, robot1, robot2,robot3));
                    break;
                case 2:
                    atacarRobot (scanner, seleccionarRobot (scanner, robot1, robot2,robot3));
                    break;
                //case 3:
                 //   defenderRobot (scanner, seleccionarRobot (scanner, robot1, robot2,robot3));
                   // break;
                case 4:
                    System.out.println ("Saliendo del Juego...");
                    break;
                default:
                    System.out.println ("Opción inválida. Por Favor selecciones una opción válida");
            }
        } while (opcion != 4);
    }
    
    private static Robot seleccionarRobot (Scanner scanner, Robot robot1, Robot robot2, Robot robot3){
        System.out.print ("Ingrese el número de robot (1-3)");
        int numRobot = scanner.nextInt ();
        scanner.nextLine();
        switch (numRobot){
            case 1:
                return robot1;
            case 2:
                return robot2;
            case 3:
                return robot3;
            default:
                System.out.println ("Número de robot inválido");
                return null;
        }
    }
    
    private static void mostrarEstadoRobot (Robot robot){
        if (robot != null){
            robot.EstadoRobot();
        }
    }
    public static void atacarRobot (Scanner scanner, Robot robot){
        if (robot != null){
            
        }
    }
}