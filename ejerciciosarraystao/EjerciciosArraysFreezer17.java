package ejerciciosarraystao;

import java.util.Arrays;
import java.util.Scanner;

public class EjerciciosArraysFreezer17 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] vector = new int[10];
        int[] vector2 = new int[10];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = i/*(int) (Math.random() * 10)*/;
            System.out.println(vector[i] + " vector1 ");
        }

        for (int i = 0; i < vector2.length; i++) {
            vector2[i] = i/*(int) (Math.random() * 10)*/;
            System.out.println(vector2[i]);
        }

        if (Arrays.equals(vector, vector2)) {
            System.out.println("Son iguales.");
        } else {
            System.out.println("Distintas");
        }

    }

}
