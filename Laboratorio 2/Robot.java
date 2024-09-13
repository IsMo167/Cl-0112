
import java.util.Scanner;

public class Robot{
    
    Scanner scanner = new Scanner (System.in);
    
    private String nombre;
    private int puntosVida;
    private int ataqueMax;
    
    private int defensa;
    
    public Robot (String nombre, int puntosVida, int ataqueMax){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataqueMax = ataqueMax;
    }
    
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public void setPuntosVida (int puntosVida){
        this.puntosVida = puntosVida;
    }
    public void setAtaqueMax (int ataqueMax){
        this.ataqueMax = ataqueMax;
    }
    
    public void setDefensa (int defensa){
        this.defensa = defensa;
        
    }
    
    public String getNombre (){
        return nombre;
    }
    public int getPuntosVida (){
        return puntosVida;
    }
    public int getAtaqueMax (){
        return ataqueMax;
    }
    
    public void atacar (Robot otroRobot){
        
    }
    public boolean estaVivo (){
        if (puntosVida > 0){
            return true;
        }
        else {
            return false;
        }
    }
    
    public void EstadoRobot (){
        System.out.println ("-----------------------------------------------------------------------");
        System.out.println ("Nombre robot: " + nombre);
        System.out.println ("Puntos Vida del robot: " + puntosVida);
    }
}