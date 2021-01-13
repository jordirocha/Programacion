package ejerciciosarraystao;

import java.util.Scanner;

public class EjercicioArraysPilaf7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Inserta un número: ");
        int P = sc.nextInt();

        System.out.print("Inserta otro número: ");
        int Q = sc.nextInt();

        int vector[] = new int[(Q - P) + 1];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = P + i;
            System.out.print(vector[i] + " | ");
        }

    }

}
