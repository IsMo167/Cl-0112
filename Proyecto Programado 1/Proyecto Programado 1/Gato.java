import java.util.Scanner;
public class Gato{
     char [] [] tablero = new char[3][3];
     char jugadorActual;

    //recorre el tablero vacio y lo llena con "_", para mostrarlo al usuario
     public void llenarTablero(){
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j<tablero[0].length; j++){
                tablero[i][j]= '_';
            }
        }
     }
     //misma logica que llenarTablero, pero en este caso lo imprime
     public void imprimirTablero(){
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j<tablero[0].length; j++){
                System.out.print(tablero[i][j] + " ");;
            }
            System.out.println();
        }
     }
     //recibe la fila y la columna y sustituye ese espacio por el char del jugador
     public void movimiento(int fila, int columna){
        if(tablero[fila][columna] == '_'){
            tablero[fila][columna] = 'X';
            imprimirTablero();
        } else {
            System.out.println("Espacio ocupado");
        }
     }

     //verifica si el tablero esta lleno viendo si queda algun '_'
     public boolean tableroLleno(){
        for(int i =0; i <tablero.length; i++){
            for(int j = 0; j < tablero[0].length; j++){
                if(tablero[i][j]=='_'){
                    return false;
                }
            }
        }
        return true;
     }

     public boolean ganador(){
        for(int i = 0; i<tablero.length; i++){
            if(tablero[i][0]=='X' && tablero[i][1]=='X' && tablero[i][2]=='X'){
                return true;
            }else if(tablero[0][i]=='X' && tablero[1][i]=='X' && tablero[2][i]=='X'){
                return true;
            }
        }
        if(tablero[0][0]=='X' && tablero[1][1]=='X' && tablero[2][2]=='X'){
            return true;
        } else if(tablero[0][2]=='X' && tablero[1][1]=='X' && tablero[2][0]=='X'){
            return true;
        }
        return false;
     }


     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gato gato1 = new Gato();
        boolean enJuego = true;
        gato1.llenarTablero();
        gato1.imprimirTablero();

        while(enJuego){
            System.out.println("Ingrese la fila y la columna en la que desea poner su ficha: ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
            gato1.movimiento(fila-1, columna-1);
            System.out.println("Desea seguir jugando? 1 = Si   2 = No");
            int desicion = scanner.nextInt();
            if (desicion==2 || gato1.tableroLleno()==true || gato1.ganador()== true) {
                enJuego = false;
            }
            if(gato1.ganador()== true){
                System.out.println("Felicidades gano la partida!");
            }
            
        }
        scanner.close();
     }

}