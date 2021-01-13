package ejerciciosarraystao;

import java.util.Scanner;

public class EjerciciosArraysTao13 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce número ");
        int V = sc.nextInt();

        System.out.print("Introduce el valor aritmetico: ");
        int I = sc.nextInt();

        System.out.print("¿De qué tamaño? ");
        int N = sc.nextInt();

        int aritmetica[] = new int[N];
        aritmetica[0] = V; // Le asigno a la posicion 0 el valor de V

        for (int i = 1; i < aritmetica.length; i++) { // Empiezo desde 1
            aritmetica[i] = aritmetica[i - 1] + I; // Aquí sumo una posicion anterior más I
            System.out.println(aritmetica[i]);
        }

    }

}
