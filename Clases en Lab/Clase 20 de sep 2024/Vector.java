import java.util.Random;
public class Vector{
    Random randomGenerador = new Random ();
    int [] vector;
<<<<<<< HEAD

=======
    
>>>>>>> 374500e8e49a4c2bed3e0997007876c9d1e335a6
    
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
            this.vector[i] = randomGenerador.nextInt(101);
        }
    }
    public void ordenarVector (){
<<<<<<< HEAD
        int posicionMenor = 0;
        int valorMenor = vector [posicionMenor];
        
        for (int i = 0; vector.length > i; i++){
            for (int j = 0; vector.length > j; j++){
                if (> vector[i]  ){

                }
=======
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
>>>>>>> 374500e8e49a4c2bed3e0997007876c9d1e335a6
            }
            
            vector [posicion]
        }
    }
}
