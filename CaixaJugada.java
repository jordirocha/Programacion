package caixajugada;

import java.util.Arrays;
import java.util.Scanner;

public class CaixaJugada {

    public static void main(String[] args) {

        int[] cartas = new int[9];
        int[] cartasElegidas = new int[9];
        int daus, numCartas;
        boolean checkSuma;

        inicializarCartas(cartas);

        do {
            daus = tiradaDados(cartas);
            System.out.println("Tirada de dados: " + daus);

            mostrarCartas(cartas);

            Arrays.fill(cartasElegidas, 0);

            numCartas = jugadaUsuario(cartas, cartasElegidas);
            System.out.println("Cartas usadas: " + numCartas);

            mostrarCartas(cartasElegidas);

            checkSuma = comprobarSuma(daus, cartasElegidas, numCartas);

               if (checkSuma) {
                marcarUtilizadas(cartas, cartasElegidas, numCartas);
            }
            
            marcarUtilizadas(cartas, cartasElegidas, numCartas);
        } while (checkSuma); // Mientras la suma sea correcta se repite el ciclo

        System.out.println("Te han quedado " + puntsFinales(cartas) + " puntos de las cartas.");

    }

    private static void inicializarCartas(int[] cartas) {

        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = (i + 1);
        }

    }

    private static void mostrarCartas(int[] cartas) {

        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != 0) {
                System.out.print(cartas[i] + " ");
            } else {
                System.out.print("X ");
            }
        }

        System.out.println("");

    }

    private static int tiradaDados(int[] cartas) {

        int dado = (int) (Math.random() * 6 + 1);
        int dado2 = (int) (Math.random() * 6 + 1);

        if (dosDados(cartas)) {
            return dado + dado2;
        } else {
            System.out.println("Tienes menos de 6 cartas para elegir, usarás 1 dado.");
            return dado;
        }

    }

    private static boolean dosDados(int[] cartas) {

        int ceros = 0;

        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] == 0) {
                ceros++;
                if (ceros > 6) {
                    return false;
                }
            }
        }

        return true;

    }

    private static int jugadaUsuario(int[] cartas, int[] cartasElegidas) {

        Scanner sc = new Scanner(System.in);
        int opcion, usadas = 0;

        do {
            System.out.print("Escoge cartes que sumin la suma dels daus (-1) para acabar: ");
            opcion = sc.nextInt();
            if (opcion != -1) {
                for (int i = 0; i < cartas.length; i++) {
                    if (opcion == cartas[i]) {
                        cartasElegidas[usadas] = opcion;
                        usadas++;
                    }
                }
            }
        } while (opcion != -1);

        return usadas;

    }

    private static boolean comprobarSuma(int daus, int[] cartasElegidas, int numCartas) {

        int sumaElegidas = 0;

        for (int i = 0; i < numCartas; i++) {
            sumaElegidas += cartasElegidas[i];
        }

        System.out.println("Suma de sus elegidas: " + sumaElegidas);

        if (sumaElegidas != daus) {
            return false;
        }

        return true;

    }

    private static void marcarUtilizadas(int[] cartas, int[] cartasElegidas, int numCartas) {

        for (int i = 0; i < numCartas; i++) { // Conteo de mis cartas elegidas
            for (int j = 0; j < cartas.length; j++) { // Comparar cada elegida con la matriz total
                if (cartasElegidas[i] == cartas[j]) {
                    cartas[j] = 0;
                }
            }
        }

    }

    private static int puntsFinales(int[] puntuacion) {

        int puntos = 0;

        for (int i = 0; i < puntuacion.length; i++) {
            if (puntuacion[i] != 0) {
                puntos += puntuacion[i];
            }
        }

        return puntos;

    }

}
