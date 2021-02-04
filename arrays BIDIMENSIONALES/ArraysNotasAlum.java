package arrays;

import java.util.Scanner;

public class ArraysNotasAlum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int media = 0, sumaNotas = 0;

        int matriz[][] = new int[4][5];

        int minima = 999, maxima = 0;

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Notas del alumnno " + (i + 1));
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Introduce sus notas: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Notas del alumnno " + (i + 1) + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                sumaNotas += matriz[i][j];
                if (matriz[i][j] > maxima) {
                    maxima = matriz[i][j];
                }

                if (matriz[i][j] < minima) {
                    minima = matriz[i][j];
                }
                System.out.print(matriz[i][j] + " |");
            }
            System.out.println(" Nota máx: " + maxima + " Nota min: " + minima + " Media de sus notas: " + ((double) sumaNotas / matriz[1].length));
            minima = 999;
            maxima = 0;
            sumaNotas = 0;
        }

    }

}
