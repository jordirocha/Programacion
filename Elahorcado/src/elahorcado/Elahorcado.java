package elahorcado;

import java.util.Arrays;
import java.util.Scanner;

public class Elahorcado {

    public static void main(String[] args) {

        int ahorcado = 6;

        String palabra = fraseUsuario();

        char[] guiones = new char[palabra.length()];

        rellenarGuiones(guiones);

        char c[] = palabra.toCharArray(); // Se me ha ocurrido almacenar la frase en otro array y en el while compararlas

        do {
            guionesArray(guiones); // Mostramos los valores Arrays

            char letra = pedirLetra();

            if (encontrarLetra(palabra, letra, guiones)) {
                ganar();
            } else {
                munyeco(ahorcado);
                perder(letra, ahorcado);
                ahorcado--;
            }

        } while (ahorcado >= 0 && !Arrays.equals(c, guiones));

        resultado(ahorcado);

    }

    private static String fraseUsuario() {

        Scanner sc = new Scanner(System.in);

        String frase;

        do {
            System.out.print("¿Palabra a adivinar?: ");
            frase = sc.nextLine();
        } while (frase.length() <= 0);

        return frase;

    }

    private static void rellenarGuiones(char[] guiones) {
        Arrays.fill(guiones, '_');
    }

    private static void guionesArray(char[] guiones) {

        System.out.print("Palabra a adivinar: ");

        for (char i : guiones) {
            System.out.print(ANSI_CYAN + i + " | " + ANSI_RESET);
        }

    }

    private static char pedirLetra() {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nIntroduce letra: ");
        char letra = sc.nextLine().charAt(0);

        return letra;

    }

    private static boolean encontrarLetra(String palabra, char letra, char[] guiones) {

        boolean encontrado = false;

        for (int i = 0; i < guiones.length; i++) {
            if (palabra.toLowerCase().charAt(i) == letra) {
                guiones[i] = letra;
                encontrado = true; // Si tengo hoooola y solo pongo "return true;" solo me rellena la primera o, las otras 3 no: -o----- 
            }
        }

        return encontrado;

    }

    private static void ganar() {

        System.out.println(ANSI_GREEN + "Correcto se ha encontrado." + ANSI_RESET);

    }

    private static void perder(char letra, int ahorcado) {

        System.out.println(ANSI_RED + "¡Fallo, no existe la letra " + letra + "! Te quedan " + ahorcado + " intentos " + ANSI_RESET);

    }

    private static void resultado(int ahorcado) {

        if (ahorcado <= 6) {
            System.out.println("Has acertado la palabra");
        } else {
            System.out.println("Has perdido, has gastado todos los intentos.");
        }

    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private static void munyeco(int ahorcado) {

        switch (ahorcado) {
            case 6:
                System.out.println(" ---------------------");
                for (int j = 0; j < 15; j++) {
                    System.out.println(" |");
                }
                System.out.println("__________");
                break;
            case 5:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                for (int j = 0; j < 10; j++) {
                    System.out.println(" |");
                }
                System.out.println("__________");
                break;
            case 4:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                for (int j = 0; j < 5; j++) {
                    System.out.println(" |");
                }
                System.out.println("__________");
                break;
            case 3:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / |   ");
                System.out.println(" |                 /   |   ");
                System.out.println(" |                /    |   ");
                System.out.println(" |                     |   ");
                for (int j = 0; j < 5; j++) {
                    System.out.println(" |");
                }
                System.out.println("__________");

                break;
            case 2:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / | \\ ");
                System.out.println(" |                  /  |   \\ ");
                System.out.println(" |                 /   |     \\ ");
                System.out.println(" |                     |   ");
                for (int j = 0; j < 5; j++) {
                    System.out.println(" |");

                }
                System.out.println("__________");
                break;
            case 1:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / | \\ ");
                System.out.println(" |                  /  |   \\ ");
                System.out.println(" |                 /   |     \\ ");
                System.out.println(" |                     |   ");
                System.out.println(" |                    /  ");
                System.out.println(" |                   /      ");
                System.out.println(" |                  /       ");
                for (int j = 0; j < 2; j++) {
                    System.out.println(" |");

                }
                System.out.println("__________");
                break;
            case 0:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | X  X  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / | \\ ");
                System.out.println(" |                  /  |   \\ ");
                System.out.println(" |                 /   |     \\ ");
                System.out.println(" |                     |   ");
                System.out.println(" |                    / \\");
                System.out.println(" |                   /   \\  ");
                System.out.println(" |                  /     \\ ");
                for (int j = 0; j < 2; j++) {
                    System.out.println(" |");

                }
                System.out.println("__________");
                System.out.println("GAME OVER");
                break;
            default:
                throw new AssertionError();
        }

    }

}
