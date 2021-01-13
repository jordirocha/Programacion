package ejerciciosarraystao;

import java.util.Scanner;

public class EjerciciosArraysTao9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = 0, posicion = 0;

        int vector[] = new int[100];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 10 + 1);
            System.out.print(vector[i] + " | ");
        }

        System.out.print("\nInserta un número (1 a 10): ");
        N = sc.nextInt();

        for (int i = 0; i < vector.length; i++) {
            if (N == vector[i]) {
                posicion = i;
                System.out.println("Tú número " + N + ", se encuentra en la posición " + posicion);
            }
        }

    }

}
