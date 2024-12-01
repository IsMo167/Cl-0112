import java.util.Random;

public class CaballoRecursivo {

    private static final int[][] movimientosCaballo = {
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
        {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    public static String[][] resolverRecursivoTablero() {
        int[][] tablero = new int[8][8];
        String[][] tableroString = new String[8][8];  // Este arreglo guardará la representación en String de cada casilla

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = -1;
                tableroString[i][j] = "";  // Inicializamos con cadenas vacías
            }
        }

        Random random = new Random();
        int iniciarI = random.nextInt(8);
        int iniciarJ = random.nextInt(8);
        tablero[iniciarI][iniciarJ] = 1;
        tableroString[iniciarI][iniciarJ] = "1";  // Empezamos con el primer movimiento

        if (resolverRecorridoRecursivo(iniciarI, iniciarJ, 2, tablero, tableroString)) {
            return tableroString;  // Devolvemos el tablero como matriz de Strings
        } else {
            return new String[8][8];  // Retornamos una matriz vacía si no se encuentra solución
        }
    }

    private static boolean resolverRecorridoRecursivo(int i, int j, int movActual, int[][] tablero, String[][] tableroString) {
        if (movActual > 8 * 8) {
            return true;
        }

        int[][] movimientosPosibles = new int[8][2];
        int cantidadMovimientos = 0;

        for (int g = 0; g < 8; g++) {
            int nuevoI = i + movimientosCaballo[g][0];
            int nuevoJ = j + movimientosCaballo[g][1];

            if (esMovimientoValido(nuevoI, nuevoJ, tablero)) {
                movimientosPosibles[cantidadMovimientos][0] = nuevoI;
                movimientosPosibles[cantidadMovimientos][1] = nuevoJ;
                cantidadMovimientos++;
            }
        }

        for (int a = 0; a < cantidadMovimientos; a++) {
            for (int b = a + 1; b < cantidadMovimientos; b++) {
                int countA = contarMovimientosPosibles(movimientosPosibles[a][0], movimientosPosibles[a][1], tablero);
                int countB = contarMovimientosPosibles(movimientosPosibles[b][0], movimientosPosibles[b][1], tablero);

                if (countA > countB) {
                    int[] temp = movimientosPosibles[a];
                    movimientosPosibles[a] = movimientosPosibles[b];
                    movimientosPosibles[b] = temp;
                }
            }
        }

        for (int a = 0; a < cantidadMovimientos; a++) {
            int nuevoI = movimientosPosibles[a][0];
            int nuevoJ = movimientosPosibles[a][1];

            tablero[nuevoI][nuevoJ] = movActual;
            tableroString[nuevoI][nuevoJ] = String.valueOf(movActual);  // Guardamos el número del movimiento en el tableroString
            if (resolverRecorridoRecursivo(nuevoI, nuevoJ, movActual + 1, tablero, tableroString)) {
                return true;
            } else {
                tablero[nuevoI][nuevoJ] = -1;
                tableroString[nuevoI][nuevoJ] = "";  // Limpiamos si no fue un movimiento válido
            }
        }
        return false;
    }

    private static boolean esMovimientoValido(int i, int j, int[][] tablero) {
        return (i >= 0 && i < 8 && j >= 0 && j < 8 && tablero[i][j] == -1);
    }

    private static int contarMovimientosPosibles(int i, int j, int[][] tablero) {
        int contador = 0;
        for (int g = 0; g < 8; g++) {
            int nuevoI = i + movimientosCaballo[g][0];
            int nuevoJ = j + movimientosCaballo[g][1];
            if (esMovimientoValido(nuevoI, nuevoJ, tablero)) {
                contador++;
            }
        }
        return contador;
    }
}

