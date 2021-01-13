package ejerciciosarraystao;

import java.util.Scanner;

public class EjerciciosArraysTao12 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sb = new Scanner(System.in);

        int vector[] = new int[10];
        char opcion = ' ';

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 10);
            System.out.println(vector[i]);
        }

        do {
            System.out.println("\na. Mostrar valores.\nb. Introducir valor.\nc. Salir.");
            System.out.print("Escoge opcion: ");
            opcion = sb.nextLine().charAt(0);

            switch (opcion) {
                case 'a':
                    for (int i = 0; i < vector.length; i++) {
                        System.out.println(vector[i]);
                    }
                    break;
                case 'b':
                    System.out.print("\n¿Qué número quieres añadir? ");
                    int valor = sc.nextInt();
                    System.out.print("¿Qué posición quieres cambiar (0 a 10)? ");
                    int posicion = sc.nextInt();

                    vector[posicion] = valor;
                    break;
                case 'c':
                    System.out.println("Programa terminado.");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != 'c');

    }

}
