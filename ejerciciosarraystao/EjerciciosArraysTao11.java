package ejerciciosarraystao;

import java.util.Scanner;

public class EjerciciosArraysTao11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v1[] = new int[100], v2[] = new int[100];

        for (int i = 0; i < v1.length; i++) {
            v1[i] = (int) (Math.random() * 100);
            System.out.print(v1[i] + "|");
        }

        System.out.println("\nValores a la inversa\n");

        for (int i = v1.length - 1; i >= 0; i--) {
            v2[i] = v1[i];
            System.out.print(v2[i] + "|");
        }
        
    }
    
}
