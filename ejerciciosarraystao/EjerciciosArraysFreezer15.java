package ejerciciosarraystao;

import java.util.Arrays;
import java.util.Scanner;

public class EjerciciosArraysFreezer15 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce tamaño array: ");
        int N = sc.nextInt();

        System.out.print("Introduce número: ");
        int M = sc.nextInt();

        int[] vector = new int[N];

        Arrays.fill(vector, M); // Método para reemplazar una posición

        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " | ");
        }

    }

}
