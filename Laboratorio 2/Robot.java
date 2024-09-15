
import java.util.Scanner;

public class Robot{
    
    Scanner scanner = new Scanner (System.in);
    
    private String nombre;
    private int puntosVida;
    private int ataqueMax;
    private int ataque;
    private int defensa;
    
    public Robot (String nombre, int puntosVida, int ataqueMax, int ataque){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataqueMax = ataqueMax;
        this.ataque = ataque;
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
    public void setAtaque (int ataque){
        this.ataque = ataque;
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
    public int getAtaque (){
        return ataque;
    }
    
    public void atacar (Robot otroRobot){
        if (otroRobot != null && otroRobot.estaVivo()) {
        /*
        int daño = this.ataque - otroRobot.defensa;
        if (daño < 0){
            daño = 0;
        }
        otroRobot.setPuntosVida(puntosVida - daño);
        */
       otroRobot.setPuntosVida(getPuntosVida() - this.ataque);
        }
    }
    public boolean estaVivo (){
        if (puntosVida > 0){
            System.out.println ("Los puntos de vida del robot son: " + puntosVida);
            return true;
        }
        else {
            System.out.println ("El robot perdió");
            return false;
        }
    }
    
}