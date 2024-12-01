public class ColaPersonas {

    // Nodo que representará un elemento de la cola
    private class Nodo {
        String nombre;
        Nodo siguiente;

        Nodo(String nombre) {
            this.nombre = nombre;
            this.siguiente = null;
        }
    }

    // Referencia al primer (frente) y último (final) nodo de la cola
    private Nodo frente;
    private Nodo finalDeCola;

    // Constructor: Crear una cola vacía
    public ColaPersonas() {
        frente = null;
        finalDeCola = null;
    }

    // Método vacía: Retorna true si la cola está vacía
    public boolean vacia() {
        return frente == null;
    }

    // Método agregar: Agrega el nombre al final de la cola
    public void agregar(String nombre) {
        Nodo nuevoNodo = new Nodo(nombre);

        // Si la cola está vacía, el nuevo nodo será el primero y el último
        if (finalDeCola == null) {
            frente = nuevoNodo;
            finalDeCola = nuevoNodo;
        } else {
            // De lo contrario, agregamos el nuevo nodo al final
            finalDeCola.siguiente = nuevoNodo;
            finalDeCola = nuevoNodo;
        }
    }

    // Método sacar: Saca el elemento que está de primero en la cola
    public String sacar() {
        if (vacia()) {
            return "La cola está vacía";
        } else {
            // Guardamos el nombre del primer nodo
            String nombre = frente.nombre;
            // Movemos el frente al siguiente nodo
            frente = frente.siguiente;

            // Si la cola quedó vacía, también se debe actualizar el último nodo
            if (frente == null) {
                finalDeCola = null;
            }

            return nombre;
        }
    }

    // Método main para probar la funcionalidad
    public static void main(String[] args) {
        ColaPersonas cola = new ColaPersonas();

        cola.agregar("Juan");
        cola.agregar("María");
        cola.agregar("Pedro");

        System.out.println(cola.sacar()); // Debería imprimir "Juan"
        System.out.println(cola.sacar()); // Debería imprimir "María"
        System.out.println(cola.sacar()); // Debería imprimir "Pedro"
        System.out.println(cola.sacar()); // Debería imprimir "La cola está vacía"
    }
}

