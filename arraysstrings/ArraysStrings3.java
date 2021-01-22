package arraysstrings;

import java.util.Scanner;

public class ArraysStrings3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String datos[] = new String[3];

        insertarDatos(datos);

        mostrarCodigo(datos);

    }

    private static void insertarDatos(String[] datos) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < datos.length; i++) {
            System.out.print("Introduce datos (Nombre y Apellidos): ");
            datos[i] = sc.nextLine();
        }

    }

    private static void mostrarCodigo(String[] datos) {

        System.out.println("\nTu códido es el siguiente: ");

        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(datos[i].toUpperCase().charAt(j));
            }
        }

    }

}
