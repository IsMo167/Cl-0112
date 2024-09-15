public class Robot {
    
    private String nombre;
    private int puntosVida;
    private int ataqueMax;
    private int ataque;
    private int defensa;

    public Robot(String nombre, int puntosVida, int ataqueMax, int ataque, int defensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataqueMax = ataqueMax;
        this.ataque = ataque;
        this.defensa = defensa;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }
    
    public void setAtaqueMax(int ataqueMax) {
        this.ataqueMax = ataqueMax;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getPuntosVida() {
        return puntosVida;
    }
    
    public int getAtaqueMax() {
        return ataqueMax;
    }
    
    public int getAtaque() {
        return ataque;
    }
    
    public int getDefensa() {
        return defensa;
    }
    
    public void atacar(Robot otroRobot) {
        if (otroRobot != null && otroRobot.estaVivo()) {
            int daño = this.ataque - otroRobot.defensa;
            if (daño < 0) {
                daño = 0;
            }
            otroRobot.setPuntosVida(otroRobot.getPuntosVida() - daño);
        }
    }
    
    public boolean estaVivo() {
        if (puntosVida > 0){
            return true;
        }
        else{
        return false;
        }
    }
    
}