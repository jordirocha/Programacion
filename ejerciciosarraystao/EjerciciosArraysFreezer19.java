package ejerciciosarraystao;

import java.util.Arrays;
import java.util.Scanner;

public class EjerciciosArraysFreezer19 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char opcion = ' ';

        int[] puntuaciones = new int[8];

        for (int i = 0; i < puntuaciones.length; i++) { // Para añadir datos al array
            puntuaciones[i] = (int) (Math.random() * (2800 - 1000 + 1) + 1000);
            System.out.print(puntuaciones[i] + " | ");
        }

        Arrays.sort(puntuaciones); // Método para ordenar

        System.out.print("\n¿Quieres las puntuaciones en orden (a)scendente o (d)escendente?\nElige opción: "); // Agregado mio
        opcion = sc.nextLine().charAt(0);

        switch (opcion) {
            case 'a':
                for (int i = 0; i < puntuaciones.length; i++) { // En orden ascendente
                    System.out.print(puntuaciones[i] + " | ");
                }
                break;
            case 'd':
                for (int i = puntuaciones.length - 1; i >= 0; i--) { // En orden descendente
                    System.out.print(puntuaciones[i] + " | ");
                }
                break;
            default:
                throw new AssertionError();
        }

    }

}
