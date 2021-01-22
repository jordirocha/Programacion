package arraysstrings;

import java.util.Scanner;

public class ArraysStrings4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introducir frase: ");
        String frase = sc.nextLine();

        Vocales(frase);

    }

    private static void Vocales(String frase) {

        frase.toLowerCase();
        
        int a = 0, e = 0, i = 0, o = 0, u = 0;

        for (int j = 0; j < frase.length(); j++) {
            if (frase.charAt(j) == 'a') {
                a++;
            } else if (frase.charAt(j) == 'e') {
                e++;
            } else if (frase.charAt(j) == 'i') {
                i++;
            } else if (frase.charAt(j) == 'o') {
                o++;
            } else if (frase.charAt(j) == 'u') {
                u++;
            }
        }

        System.out.println("Nº de A's: " + a + "\nNº de E's: " + e + "\nNº de I's: " + i + "\nNº de E's: " + o + "\nNº de U's: " + u);

    }

}
