package exercicisdetrileros;

import java.util.Scanner;

public class Exercicisdetrileros {

    public static void main(String[] args) {

        int puntos = 0;
        char opcion = ' ';

        char trileros[] = new char[3]; // Declaración del array

        do {

            vasos(trileros);

            intercambiarVasos(trileros);

            opcion = escogerVaso(trileros);

            if (opcion != 'X') {
                puntos++;
                puntos(puntos);
                ganador(trileros, opcion);
            }

        } while (opcion != 'X');

        

    }

    private static void vasos(char[] trileros) {

        for (int i = 0; i < trileros.length; i++) {
            trileros[i] = 'X';
        }

        int boleta = (int) (Math.random() * 3);

        trileros[boleta] = 'O';

        System.out.println("Mostrando los vasos: ");

        for (int i = 0; i < trileros.length; i++) {
            System.out.print(trileros[i] + " | ");
        }

    }

    private static void intercambiarVasos(char[] trileros) {

        char aux;
        int valor1, valor2;

        for (int i = 0; i < 10; i++) {

            valor1 = (int) (Math.random() * 3);

            do {
                valor2 = (int) (Math.random() * 3);
            } while (valor1 == valor2);

            aux = trileros[valor1];
            trileros[valor1] = trileros[valor2];
            trileros[valor2] = aux;

            System.out.println("Se ha cambiado de la posicion " + valor1 + " a la posición " + valor2);

        }

    }

    private static void puntos(int puntos) {

        System.out.println("\nPuntos obtenidos : " + puntos);

    }

    private static char escogerVaso(char[] trileros) {

        Scanner sc = new Scanner(System.in);
        int vaso;

        do {
            System.out.println("Escoge uno de los 3 vasos: ");
            vaso = sc.nextInt();
        } while (vaso < 1 || vaso > 3);

        return trileros[vaso - 1];

    }

    private static void ganador(char[] trileros, char opcion) {
        if (trileros[opcion] == 'O') {
            System.out.println("Has escogido " + trileros[opcion]);
        } else {
            System.out.println("Has perdido has escogido " + trileros[opcion]);
        }
    }

}
