/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headball;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author jordy
 */
public class HeadBall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int valor[] = new int[4];
        int monedas = 0, ganancia = 0;

        String respuesta = "";
        Scanner sc = new Scanner(System.in);

        do {
            inicializacion_cartes(valor);
            poner_tarja_roja(valor);
            int eleccion = pedir_posicion();
            monedas = premio(valor, eleccion);
            
            resultadoCartas(valor, monedas);
            
            if (monedas != -1)/*si no has perdido*/ {
                ganancia = ganancia + monedas;
                System.out.println("\nMostrando resultados de las cartas:");
                mostrar_ganancia(ganancia, monedas);
                System.out.print("quieres plantarte(SI/NO) ");
                respuesta = sc.next();
            }

        } while (monedas != -1 && !respuesta.equalsIgnoreCase("si"));

        System.out.println("Has ganado: " + ganancia);

    }

    /*
    pongo monedas a todas las cartas
     */
    public static void inicializacion_cartes(int valor[]) {
        for (int i = 0; i < valor.length; i++) {
            valor[i] = (int) (Math.random() * 100) + 1;
        }
    }

    /*
    elijo una posición para la tarjeta roja (-1)
     */
    public static void poner_tarja_roja(int valor[]) {
        int pos = (int) (Math.random() * 4);
        valor[pos] = -1;
    }

    public static int pedir_posicion() {
        Scanner sc = new Scanner(System.in);
        int eleccion = 0;
        do {
            System.out.print("Elige una carta del 1 al 4: ");
            eleccion = sc.nextInt();
        } while (eleccion < 1 || eleccion > 4);
        return (eleccion - 1);
    }

    public static int premio(int valor[], int eleccion) {
        return valor[eleccion];
    }

    private static void mostrar_ganancia(int ganancia, int monedas) {
        System.out.println(ANSI_RESET + "has ganado " + monedas + " acumulado " + ganancia);
    }

    public static final String ANSI_YELLOW = "\u001B[33m"; // Tú carta elegida
    public static final String ANSI_RED = "\u001B[31m"; // La carta roja
    public static final String ANSI_RESET = "\u001B[0m"; // Reset color

    private static void resultadoCartas(int[] valor, int monedas) {
        for (int i = 0; i < valor.length; i++) {
            if (valor[i] == monedas) {
                System.out.print(ANSI_YELLOW + valor[i] + " | " + ANSI_RESET);
            } else if (valor[i] == -1) {
                System.out.print(ANSI_RED + valor[i] + " | " + ANSI_RESET);
            } else {
                System.out.print(valor[i] + " | ");
            }
        }
    }

}
