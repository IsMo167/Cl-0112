public class Gato{
     char [] [] tablero = new char[3][3];

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

     }

     public static void main(String[] args) {
        Gato gato1 = new Gato();

        gato1.llenarTablero();
        gato1.imprimirTablero();
        


     }

}