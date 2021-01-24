package trileros;

import java.util.Arrays;
import java.util.Scanner;

public class Trileros {

    public static void main(String[] args) {

        int puntos = 0;
        int vaso;
        char trileros[] = new char[3];

        do {

            inicializarCubilete(trileros);

            mostrarCubiletes(trileros);

            cambiandoPosicion(trileros);

            vaso = escogerVaso(trileros);

            if (trileros[vaso] == 'O') {
                System.out.println("\nHas acertado.");
                puntos++;
            }

            for (int i = 0; i < trileros.length; i++) {
                System.out.println(trileros[i]);
            }

        } while (trileros[vaso] != 'X');

        puntaje(puntos);

    }

    private static void mostrarCubiletes(char[] trileros) {

        int O = (int) (Math.random() * 3);
        trileros[O] = 'O';

        System.out.println("Mostrando moneda:");
        for (int i = 0; i < trileros.length; i++) {
            System.out.print(trileros[i] + " | ");
        }

        System.out.println("\n");

    }

    private static void cambiandoPosicion(char[] trileros) {

        char aux;
        int valor1 = 0, valor2 = 0;

        for (int i = 0; i < 10; i++) {

            valor1 = (int) (Math.random() * 3);

            do {
                valor2 = (int) (Math.random() * 3);
            } while (valor1 == valor2);

            System.out.println("La posición " + (valor1 + 1) + " ha cambiado a la " + (valor2 + 1));

            aux = trileros[valor2];
            trileros[valor2] = trileros[valor1];
            trileros[valor1] = aux;

        }

    }

    private static int escogerVaso(char[] trileros) {

        Scanner sc = new Scanner(System.in);

        int vaso;

        do {
            System.out.print("\nEscoge vaso (1 a 3): ");
            vaso = sc.nextInt();
        } while (vaso < 1 || vaso > 3);

        return vaso - 1;

    }

    private static void puntaje(int puntos) {

        System.out.println("Has ganado " + puntos + " euros.");

    }

    private static void inicializarCubilete(char[] trileros) {

        Arrays.fill(trileros, 'X');

    }

}
