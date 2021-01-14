package ejerciciosarraystao;

import java.util.Arrays;
import java.util.Scanner;

public class EjerciciosArraysFreezer18 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char opcion = ' ';

        int[] vector = new int[10];

        for (int i = 0; i < vector.length; i++) { // Para añadir datos al array
            vector[i] = (int) (Math.random() * 10);
            System.out.print(vector[i] + " | ");
        }

        Arrays.sort(vector); // Método para ordenar

        System.out.print("\n¿Lo quieres en orden ascendente o descendente?\nElige opción: "); // Agregado mio
        opcion = sc.nextLine().charAt(0);
        
        switch (opcion) {
            case 'a':
                for (int i = 0; i < vector.length; i++) { // En orden ascendente
                    System.out.print(vector[i] + " | ");
                }
                break;
            case 'd':
                for (int i = vector.length - 1; i >= 0; i--) { // En orden descendente
                    System.out.print(vector[i] + " | ");
                }
                break;
            default:
                throw new AssertionError();
        }

    }

}
