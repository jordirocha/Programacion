package conecta4v2;

import java.util.Scanner;

public class Conecta4V2 {

    public static void main(String[] args) {

        int filas = 7, columnas = 7;
        int conecta[][] = new int[filas][columnas];

        Boolean ganador = false;

        String jugador1 = "jordi";
        String jugador2 = "rocha";

        int iniciar = quienEmpieza(jugador1, jugador2);

        do {
            if (iniciar == 1) {
                System.out.println("Es el turno de " + jugador1.toUpperCase() + ", tu símbolo es la J.");
            } else if (iniciar == 2) {
                System.out.println("Es el turno de " + jugador2.toUpperCase() + ", tu símbolo es la R.");
            }

            mostrarTablero(conecta);

            tirada(conecta, iniciar);

            ganador = conecta4(conecta, iniciar, jugador1, jugador2);

            if (iniciar == 1) {
                iniciar = 2;
            } else {
                iniciar = 1;
            }

        } while (!taulerPle(conecta) && !ganador);

    }

    private static String introducirNombres() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        return nombre;

    }

    private static int quienEmpieza(String jugador1, String jugador2) {

        int aletorio = (int) (Math.random() * 2 + 1);

        if (aletorio == 0) {
            System.out.println("Empieza el jugador: " + jugador1);
        } else {
            System.out.println("Empieza el jugador: " + jugador2);
        }

        return aletorio;

    }

    private static void mostrarTablero(int[][] conecta) {

        for (int i = 0; i < conecta.length; i++) {
            for (int j = 0; j < conecta[i].length; j++) {
                System.out.print(mostrarCasillasUsuario(conecta, i, j) + ANSI_RED + " | ");
            }
            System.out.println("");
        }

    }

    private static void tirada(int[][] conecta, int iniciar) {
        Scanner sc = new Scanner(System.in);

        int columna;

        do {
            System.out.print("¿A qué columna quieres colocar la modena jugador " + iniciar + "? ");
            columna = sc.nextInt();
        } while (columna < 0 || columna > conecta.length || columnaCompleta(conecta, columna));

        for (int i = conecta.length - 1; i >= 0; i--) {
            if (conecta[i][columna - 1] == 0) {
                conecta[i][columna - 1] = iniciar;
                break;
            }
        }
    }

    private static boolean taulerPle(int[][] conecta) {
        for (int i = 0; i < conecta.length; i++) {
            for (int j = 0; j < conecta[i].length; j++) {
                if (conecta[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static String mostrarCasillasUsuario(int[][] conecta, int filas, int columnas) {

        if (conecta[filas][columnas] == 0) {
            return ANSI_CYAN + " _ ";
        } else if (conecta[filas][columnas] == 1) {
            return ANSI_YELLOW + " J ";
        } else if (conecta[filas][columnas] == 2) {
            return ANSI_WHITE + " R ";
        }

        return null;
    }

    private static Boolean conecta4(int[][] conecta, int iniciar, String jugador1, String jugador2) {

        int enLinea = 0;

        int colum = conecta[0].length - 1;

        do { // En modo columna
            for (int i = 0; i < conecta.length; i++) {
                if (conecta[i][colum] == iniciar) {
                    enLinea++;
                    if (enLinea == 4) {
                        winner(iniciar, jugador1, jugador2);
                        return true;
                    }
                } else {
                    enLinea = 0;
                }
            }
            colum--;
        } while (colum >= 0);

        for (int i = 0; i < conecta.length; i++) { // Comprobración a nivel de fila
            for (int j = 0; j < conecta[i].length; j++) {
                if (conecta[i][j] == iniciar) {
                    enLinea++;
                    if (enLinea == 4) {
                        winner(iniciar, jugador1, jugador2);
                        return true;
                    }
                } else {
                    enLinea = 0; // Si no se acumula la suma
                }
            }
        }

        return false;
    }

    private static boolean columnaCompleta(int[][] conecta, int columna) {

        for (int i = conecta.length - 1; i >= 0; i--) {
            if (conecta[i][columna - 1] == 0) {
                return false;
            }
        }

        return true;

    }

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static void winner(int iniciar, String jugador1, String jugador2) {
        if (iniciar == 1) {
            System.out.println("Ha  ganado el jugador: " + jugador1);
        } else {
            System.out.println("ha ganado el jugador:" + jugador2);
        }
    }

}
