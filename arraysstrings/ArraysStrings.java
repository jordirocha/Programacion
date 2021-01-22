package arraysstrings;

import java.util.Scanner;

public class ArraysStrings {

    public static void main(String[] args) {

        //String datos[] = new String[3];
        //insertarDatos(datos);
        String nombre, apellido1, apellido2;

        nombre = insertarDatos();
        apellido1 = insertarDatos();
        apellido2 = insertarDatos();

        mostrarCodigo(nombre, apellido1, apellido2);

    }

    private static String insertarDatos() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce datos: ");
        String datos = sc.nextLine();

        return datos;

    }

    private static void mostrarCodigo(String nombre, String apellido1, String apellido2) {

        for (int i = 0; i < nombre.length(); i++) {

            //System.out.println(" solo 3 posiciones" + nombre.toUpperCase().charAt(i));
            if (nombre.length() < 3) {
                System.out.println(nombre.toUpperCase().charAt(i));
            }

        }

    }

}
