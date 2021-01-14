package ejerciciosarraystao;

import java.util.Arrays;
import java.util.Scanner;

public class EjerciciosArraysFreezer20 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] enteros = new int[100];
        int equivalencia = 0;
        boolean comprobacion = false;

        for (int i = 0; i < enteros.length; i++) { // Para añadir datos al array
            enteros[i] = (int) (Math.random() * 100);
            System.out.print(enteros[i] + " | ");
        }

        System.out.print("\n\nIntroduce un valor (0 a 99): ");
        int valor = sc.nextInt();

        for (int i = 0; i < enteros.length; i++) {
            if (valor == enteros[i]) {
                comprobacion = true;
                equivalencia++;
            }
        }

        if (comprobacion) {
            System.out.println("\nTu número se encuentra en la lista");
            System.out.println("Las veces que se repite son de: " + equivalencia + " veces.");
        } else {
            System.out.println("\nTu " + valor + " no está en la lista.");
        }

    }

}
