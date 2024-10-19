import java.util.Scanner;
public class JuegoControlador{
    Scanner scanner = new Scanner (System.in);
    
    //private CuatroEnLinea cuatroEnLinea;
    private Object juegoActual;
    private char [] [] tableroGato = new char [3][3];
    private int [] [] tableroCuatro = new int [6][7];
    private Gato gato1 = new Gato(tableroGato, 'X');
    private CuatroEnLinea cuatroEnLinea1 = new CuatroEnLinea(tableroCuatro, 1);

    public void mostrarMenu(){
        System.out.println("Bienvenido, escoja un Juego");
        System.out.println("1. Cuatro en Linea");
        System.out.println("2. Gato");
        System.out.println("3. Salir");
    }

    public void seleccionarJuego(){
        int opcion = scanner.nextInt();
        switch(opcion){
            case 1:
                juegoActual = cuatroEnLinea1;
                break;
            case 2:
                juegoActual = gato1;
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }


    
    
    public static void main (String [] args){
        
        
    }

    private static void jugar (){
        
        
    }
    private static void procesarEntradaUsuario(){
        
        
    }
    
}