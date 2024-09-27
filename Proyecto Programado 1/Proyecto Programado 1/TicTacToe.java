

public class TicTacToe{
    private char [][] tablero;
    private char jugadorActual;
    
    
    public void setTablero (char [][] tablero){
        this.tablero = tablero;
    }
    public void setJugadorActual (char jugadorActual){
        this.jugadorActual = jugadorActual;
    }
    
    public char [][] getTablero(){
        return tablero;
    }
    public char getJugadorActual (){
        return jugadorActual;
    }
    
    
}