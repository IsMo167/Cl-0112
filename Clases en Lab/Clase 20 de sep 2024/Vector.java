import java.util.Random;
public class Vector{
    Random randomGenerador = new Random ();
    int [] vector;

    
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
        int posicionMenor = 0;
        int valorMenor = vector [posicionMenor];
        
        for (int i = 0; vector.length > i; i++){
            for (int j = 0; vector.length > j; j++){
                if (> vector[i]  ){

                }
            }
            
            vector [posicion]
        }
    }
}
