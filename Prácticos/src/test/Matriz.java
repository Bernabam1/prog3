package test;

public class Matriz {
    public static void main(String[] args) {
        // Crear una matriz de 5x5
        int[][] matriz = new int[5][5];

        // Llenar la matriz con valores
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = i + j;
            }
        }

        // Imprimir la matriz
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] matrizAdyacencia = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0}
            };

            // Imprimir matriz de adyacencia
            for (int i = 0; i < matrizAdyacencia.length; i++) {
                for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                    System.out.print(matrizAdyacencia[i][j] + " ");
                }
                System.out.println();
            }
        
    }
}
