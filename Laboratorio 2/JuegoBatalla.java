import java.util.Scanner;

public class JuegoBatalla{
    public static void main (String []args){
        Scanner scanner = new Scanner (System.in);
        
        String nombreRobot;
        int puntosVidaRobot;
        int ataqueMaxRobot;
        int defensaRobot;
         
        
        
        
        
        
        int opcion;
        do{
            System.out.println("------------Menú Batalla------------");
            System.out.println("1. Iniciar Batalla Robot");
            System.out.println("2. Atacar Robot");
            System.out.println("3. Defender Robot");
            System.out.println("4. Detener Juego");
            opcion = scanner.nextInt();
            
            switch (opcion){
                case 1:
                    iniciarBatalla();
                    break;
                /*case 2:
                    atacarRobot (scanner, seleccionarRobot (scanner, robot1, robot2,robot3));
                    break;
                //case 3:
                 //   defenderRobot (scanner, seleccionarRobot (scanner, robot1, robot2,robot3));
                   // break;
                case 4:
                    System.out.println ("Saliendo del Juego...");
                    break;*/
                default:
                    System.out.println ("Opción inválida. Por Favor selecciones una opción válida");
            }
        } while (opcion != 4);
    }
    private static void iniciarBatalla(){
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Ingrese la cantidad de robots: ");
        int cantidadRobot = scanner.nextInt ();
        scanner.nextLine();    
        
        Robot [] robotArray = new Robot [cantidadRobot];
        
        for (int i = 0; i <= cantidadRobot; i++){
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
            
            robotArray[i] = new Robot(nombreRobot,puntosVidaRobot, ataqueMaxRobot);
            
        }
        
    }
    /*
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
            
    }*/

}