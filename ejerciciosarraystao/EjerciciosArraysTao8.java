package ejerciciosarraystao;

import java.util.Scanner;

public class EjerciciosArraysTao8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int R = 0, countR = 0;

        int vector[] = new int[100];

        System.out.print("Inserta un número real: ");
        R = sc.nextInt();

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 100);
            System.out.print(vector[i] + " | ");
            if (R >= vector[i]) {
                countR++;
            }
        }

        System.out.println("\nTú número " + R + " es mayor o igual que " + countR + " numeros.");
    }

}
