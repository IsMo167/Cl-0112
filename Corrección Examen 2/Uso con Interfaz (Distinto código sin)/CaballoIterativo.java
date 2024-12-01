public class CaballoIterativo {

    private static final int[][] movimientosCaballo = {
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
        {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    public static String[][] resolverIterativoTablero() {
        int[][] tablero = new int[8][8];
        String[][] tableroString = new String[8][8];  // Este arreglo guardará la representación en String de cada casilla

        // Inicializamos el tablero
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = -1;
                tableroString[i][j] = "";  // Inicializamos con cadenas vacías
            }
        }

        // Definir la posición inicial
        int i = 0, j = 0;
        tablero[i][j] = 1;  // Empezamos con el primer movimiento
        tableroString[i][j] = "1";  // Representación de movimiento
        int movActual = 2;

        // Mantendremos un arreglo de movimientos disponibles para intentar explorar
        boolean[][] visitados = new boolean[8][8];
        visitados[i][j] = true;  // Marcamos la casilla inicial como visitada

        // Usamos un ciclo while para simular la recursión
        while (movActual <= 8 * 8) {
            int[][] movimientosPosibles = new int[8][2];
            int cantidadMovimientos = 0;

            // Guardamos los movimientos válidos en el arreglo
            for (int g = 0; g < 8; g++) {
                int nuevoI = i + movimientosCaballo[g][0];
                int nuevoJ = j + movimientosCaballo[g][1];

                if (esMovimientoValido(nuevoI, nuevoJ, tablero, visitados)) {
                    movimientosPosibles[cantidadMovimientos][0] = nuevoI;
                    movimientosPosibles[cantidadMovimientos][1] = nuevoJ;
                    cantidadMovimientos++;
                }
            }

            if (cantidadMovimientos == 0) {
                // Si no hay movimientos posibles, significa que llegamos a un punto muerto
                break;
            }

            // Ordenamos los movimientos por el número de movimientos posibles
            for (int a = 0; a < cantidadMovimientos; a++) {
                for (int b = a + 1; b < cantidadMovimientos; b++) {
                    int countA = contarMovimientosPosibles(movimientosPosibles[a][0], movimientosPosibles[a][1], tablero);
                    int countB = contarMovimientosPosibles(movimientosPosibles[b][0], movimientosPosibles[b][1], tablero);

                    if (countA > countB) {
                        // Intercambiar los movimientos
                        int[] temp = movimientosPosibles[a];
                        movimientosPosibles[a] = movimientosPosibles[b];
                        movimientosPosibles[b] = temp;
                    }
                }
            }

            // Realizamos el primer movimiento válido
            int nuevoI = movimientosPosibles[0][0];
            int nuevoJ = movimientosPosibles[0][1];

            tablero[nuevoI][nuevoJ] = movActual;
            tableroString[nuevoI][nuevoJ] = String.valueOf(movActual);
            visitados[nuevoI][nuevoJ] = true;  // Marcamos la nueva casilla como visitada

            // Actualizamos las posiciones para el siguiente movimiento
            i = nuevoI;
            j = nuevoJ;
            movActual++;
        }

        return tableroString;  // Devolvemos el tablero con la secuencia de movimientos
    }

    // Verificar si el movimiento es válido
    private static boolean esMovimientoValido(int i, int j, int[][] tablero, boolean[][] visitados) {
        return (i >= 0 && i < 8 && j >= 0 && j < 8 && tablero[i][j] == -1 && !visitados[i][j]);
    }

    // Contar cuántos movimientos posibles hay desde la casilla (i, j)
    private static int contarMovimientosPosibles(int i, int j, int[][] tablero) {
        int contador = 0;
        for (int g = 0; g < 8; g++) {
            int nuevoI = i + movimientosCaballo[g][0];
            int nuevoJ = j + movimientosCaballo[g][1];
            if (esMovimientoValido(nuevoI, nuevoJ, tablero, new boolean[8][8])) {
                contador++;
            }
        }
        return contador;
    }
}
