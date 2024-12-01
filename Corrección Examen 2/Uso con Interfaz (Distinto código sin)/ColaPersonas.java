public class ColaPersonas {

    private class Nodo {
        String nombre;
        Nodo siguiente;

        Nodo(String nombre) {
            this.nombre = nombre;
            this.siguiente = null;
        }
    }

    private Nodo frente;
    private Nodo finalDeCola;
    private FilaDePersonas filaInterfaz; // Referencia a la interfaz

    public ColaPersonas(FilaDePersonas filaInterfaz) {
        frente = null;
        finalDeCola = null;
        this.filaInterfaz = filaInterfaz;
    }

    public boolean vacia() {
        return frente == null;
    }

    public void agregar(String nombre, String rutaImagen) {
        Nodo nuevoNodo = new Nodo(nombre);

        if (finalDeCola == null) {
            frente = nuevoNodo;
            finalDeCola = nuevoNodo;
        } else {
            finalDeCola.siguiente = nuevoNodo;
            finalDeCola = nuevoNodo;
        }

        
    }

    public String sacar() {
        if (vacia()) {
            return "La cola está vacía";
        } else {
            String nombre = frente.nombre;
            frente = frente.siguiente;

            if (frente == null) {
                finalDeCola = null;
            }

            return nombre;
        }
    }
}


