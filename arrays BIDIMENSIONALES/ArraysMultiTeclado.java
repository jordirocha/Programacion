package arrays;

import java.util.Scanner;

public class ArraysMultiTeclado {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cero = 0, menor = 0, mayor = 0;

        System.out.print("Introduce el número de filas: ");
        int filas = sc.nextInt();

        System.out.print("Introduce el número de columnas: ");
        int columnas = sc.nextInt();

        int matriz[][] = new int[filas][columnas];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Introduce valores: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > 0) {
                    mayor++;
                } else if (matriz[i][j] < 0) {
                    menor++;
                } else if (matriz[i][j] == 0) {
                    cero++;
                }
            }
        }

        System.out.println("\nValores mayores a cero " + mayor);
        System.out.println("Valores menores a cero " + menor);
        System.out.println("Valores iguales a cero " + cero);

    }

}
