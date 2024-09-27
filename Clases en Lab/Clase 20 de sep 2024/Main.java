public class Main{
    
    public static void main (String [] args){
        
        int [] VectorArreglo = {4,6,2};
        
        
        
        Vector vector1 = new Vector (VectorArreglo);
        
        vector1.imprimirVector();
        vector1.cambiarVector();
        vector1.imprimirVector();
    }
}