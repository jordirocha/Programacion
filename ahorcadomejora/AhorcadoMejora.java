package ahorcadomejora;

import java.util.Arrays;
import java.util.Scanner;

public class AhorcadoMejora {

    public static void main(String[] args) throws InterruptedException {

        int intentos = 7;

        String frase = fraseUsuario();

        char palabras[] = new char[frase.length()];

        arrayGuiones(palabras);

        do {
            mostrarArray(palabras);

            char palabra = preguntarLetra();

            if (verificarLetra(palabra, frase, palabras)) {
                acierto();
            } else {
                intentos--;
                munyeco(intentos);
                fallo(intentos);
            }

        } while (intentos > 0 && !comprobarGuiones(palabras, frase));

        ganar(intentos, frase);

    }

    private static String fraseUsuario() {

        Scanner sc = new Scanner(System.in);

        String frase;

        do {
            System.out.print("Introduce frase: ");
            frase = sc.nextLine();
        } while (frase.length() <= 0 || frase.contains(" ")); // Por si me ponen espacio

        return frase;

    }

    private static void arrayGuiones(char[] palabra) {

        Arrays.fill(palabra, '■');

    }

    private static void mostrarArray(char[] palabra) throws InterruptedException {

        System.out.print("Palabra a adivinar: ");

        for (char c : palabra) {
            System.out.print(ANSI_YELLOW + "| " + c + " | " + ANSI_RESET);
        }

    }

    private static char preguntarLetra() {

        Scanner sc = new Scanner(System.in);

        char palabra;

        System.out.print("\nIntroduce letra: ");
        palabra = sc.nextLine().charAt(0);

        return palabra;

    }

    private static boolean verificarLetra(char palabra, String frase, char[] palabras) {

        boolean check = false;

        for (int i = 0; i < palabras.length; i++) {
            if (palabra == frase.toLowerCase().charAt(i)) {
                palabras[i] = palabra;
                check = true;
            }
        }

        return check;

    }

    private static boolean comprobarGuiones(char[] palabras, String frase) {
        // char c[] = frase.toCharArray();
        return Arrays.equals(frase.toCharArray(), palabras); // La paso a char desde aquí comparamos

    }

    private static void fallo(int intentos) {

        System.out.println(ANSI_RED + "!Has fallado! Te quedan " + intentos + " intentos." + ANSI_RESET);

    }

    private static void acierto() {

        System.out.println(ANSI_GREEN + "Has acertado." + ANSI_RESET);

    }

    private static void ganar(int intentos, String frase) {

        if (intentos == 0) {
            System.out.println("Has perdido.La palabra era: " + frase);
        } else {
            System.out.println("¡Has ganado! La palabra era: " + frase);
        }

    }

    private static void munyeco(int intentos) {

        switch (intentos) {
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
                System.out.println("             ___     -._\n"
                        + "            `-. \"\"\"--._ `-.\n"
                        + "               `.      \"-. `.\n"
                        + " _____           `.       `. \\       PERDEDOR\n"
                        + "`-.   \"\"\"---.._    \\        `.\\\n"
                        + "   `-.         \"-.  \\         `\\\n"
                        + "      `.          `-.\\          \\_.-\"\"\"\"\"\"\"\"--._\n"
                        + "        `.           `                          \"-.\n"
                        + "          `.                                       `.    __....-------...\n"
                        + "--..._      \\                                       `--\"\"\"\"\"\"\"\"\"\"\"---..._\n"
                        + "__...._\"_-.. \\                       _,                             _..-\"\"\n"
                        + "`-.      \"\"\"--`           /       ,-'/|     ,                   _.-\"\n"
                        + "   `-.                 , /|     ,'  / |   ,'|    ,|        _..-\"\n"
                        + "      `.              /|| |    /   / |  ,'  |  ,' /        ----\"\"\"\"\"\"\"\"\"_`-\n"
                        + "        `.            ( \\  \\      |  | /   | ,'  //                 _.-\"\n"
                        + "          `.        .'-\\/'\"\"\\ |  '  | /  .-/'\"`\\' //            _.-\"\n"
                        + "    /'`.____`-.  ,'\"\\  ''''?-.V`.   |/ .'..-P''''  /\"`.     _.-\"\n"
                        + "   '(   `.-._\"\"  ||(?|    /'   >.\\  ' /.<   `\\    |P)||_..-\"___.....---\n"
                        + "     `.   `. \"-._ \\ ('   |     `8      8'     |   `) /\"\"\"\"\"    _\".\"\"\n"
                        + "       `.   `.   `.`.b|   `.__            __.'   |d.'  __...--\"\"\n"
                        + "         `.   `.   \".`-  .---      ,-.     ---.  -'.-\"\"\n"
                        + "           `.   `.   \"\"|      -._      _.-      |\"\"\n"
                        + "             `.  .-\"`.  `.       `\"\"\"\"'       ,'\n"
                        + "               `/     `.. \"\"--..__    __..--\"\"\n"
                        + "                `.      /7.--|    \"\"\"\"    |--.__\n"
                        + "                  ..--\"| (  /'            `\\  ` \"\"--..\n"
                        + "               .-\"      \\\\  |\"\"--.    .--\"\"|          \"-.\n"
                        + "              <.         \\\\  `.    -.    ,'       ,'     >\n"
                        + "             (P'`.        `%,  `.      ,'        /,' .-\"'?)\n"
                        + "             P    `. \\      `%,  `.  ,'         /' .'     \\\n"
                        + "            | --\"  _\\||       `%,  `'          /.-'   .    )\n"
                        + "            |       `-.\"\"--..   `%..--\"\"\"\\\\\"--.'       \"-  |\n"
                        + " _Seal_     \\          `.  .--\"\"\"  \"\\.\\.\\ \\\\.'       )     |");
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

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

}
