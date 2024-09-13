
import java.util.Scanner;

public class Robot{
    
    Scanner scanner = new Scanner (System.in);
    
    private String nombre;
    private int puntosVida;
    private int ataque;
    
    private int defensa;
    
    public Robot (String nombre, int puntosVida, int ataque, int defensa){
        this.nombre = nombre;
        if (puntosVida >= 50 && 100 >= puntosVida){
            this.puntosVida = puntosVida;
        }
        else if (puntosVida > 100) {
            this.puntosVida = 100;
        }
        else if (50 > puntosVida) {
            this.puntosVida = 50;
        }
        if (ataque >= 10 && 20 >= ataque){
            this.ataque = ataque;
        }
        else if (ataque > 20){
            this.ataque = 20;
        }
        else if (10 > ataque){
            this.ataque = 10;
        }
        if (10 >= defensa && defensa > 0){
            this.defensa = defensa;
        }
        else if (10 > defensa){
            this.defensa = 10;
        }
        else if (0 > defensa){
            this.defensa = 1;
        }
    }
    
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public void setPuntosVida (int puntosVida){
        if (puntosVida >= 50 && 100 >= puntosVida){
            this.puntosVida = puntosVida;
        }
        else if (puntosVida > 100) {
            this.puntosVida = 100;
        }
        else if (50 > puntosVida) {
            this.puntosVida = 50;
        }
    }
    public void setAtaque (int ataque){
        if (ataque >= 10 && 20 >= ataque){
            this.ataque = ataque;
        }
        else if (ataque > 20){
            this.ataque = 20;
        }
        else if (10 > ataque){
            this.ataque = 10;
        }
    }
    
    public void setDefensa (int defensa){
        if (10 >= defensa && defensa > 0){
            this.defensa = defensa;
        }
        else if (10 > defensa){
            this.defensa = 10;
        }
        else if (0 > defensa){
            this.defensa = 1;
        }
    }
    
    public String getNombre (){
        return nombre;
    }
    public int getPuntosVida (){
        return puntosVida;
    }
    public int getAtaque (){
        return ataque;
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