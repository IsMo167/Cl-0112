import java.util.Scanner;
import java.util.Random;
public class Vector{
    Random randomGenerador = new Random ();
    int [] vector;
    
    Scanner scanner = new Scanner (System.in);
        
        public Vector(int [] vector){
            this.vector = vector;
        }
    
        public void setVector (int [] vector){
            this.vector = vector;
        }
    
        public void imprimirVector (){
            System.out.print("Los valores del vector son: ");
            for (int i = 0; vector.length > i; i++){
                System.out.print(" " + vector [i] + " ");
            }
            System.out.println ("");
        }
    
        public void cambiarVector (){
            for (int i = 0; vector.length > i; i++){
                this.vector[i] = randomGenerador.nextInt(10);
            }
        }
        public void ordenarVector (){
            for (int i = 0; vector.length > i; i++){
                int posicionMenor = i;
                int valorMenor = vector [posicionMenor];
                for (int j = i; vector.length > j; j++){
                    if ( valorMenor > vector[j]){
                        posicionMenor = j;
                        valorMenor = vector [j];
                    }
                }
                int auxVector = vector[posicionMenor];
                if (posicionMenor != i){
                    vector[posicionMenor] = auxVector;
                    vector[posicionMenor] = vector [i];
                    vector [i] = auxVector;
                }
            }
        }
    
    
        public int busquedaSecuencial(int valorBuscar) {
            
            int indice = 0;
            System.out.println ("Ingrese el valor a buscar menor a 10");
            valorBuscar = scanner.nextInt (); 
        
            for (int i = 0;  i < vector.length; ++i){
                if (vector[i] == valorBuscar) {
                   indice = i;
                   i = vector.length;
                   System.out.println ("Sí se encontró el valor: " + valorBuscar + ", en la posición: " + indice);
                } 
            }
            return indice;
        }
        
        public void valoresParesImpares (){
            for (int i = 0;  i < vector.length; ++i){
                
            }
        }
    
    
}
