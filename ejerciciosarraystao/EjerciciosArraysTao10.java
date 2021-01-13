package ejerciciosarraystao;

import java.util.Scanner;

public class EjerciciosArraysTao10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double suma = 0, media = 0;
        int mayorMedia = 0, menorMedia = 0;

        System.out.print("¿Cúantas alturas almacenarás? ");
        int N = sc.nextInt();
        // Arriba solo hay variables declaradas
        double alturas[] = new double[N];

        for (int i = 0; i < alturas.length; i++) {
            System.out.print("Introduce altura" + (i + 1) + " (metros): ");
            alturas[i] = sc.nextDouble();

            suma += alturas[i]; // Suma 
            media = suma / alturas.length; // Media
        }

        double max = alturas[0], min = alturas[0];

        for (int i = 0; i < alturas.length; i++) {
            if (alturas[i] > max) { // Máxima
                max = alturas[i];
            }

            if (alturas[i] < min) { // Mínima
                min = alturas[i];
            }

            if (alturas[i] > media) {
                mayorMedia++;
            } else {
                menorMedia++;
            }
        }

        System.out.println("\nLa altura media es: " + media);
        System.out.println("La altura máxima es: " + max);
        System.out.println("La altura mínima es: " + min);
        System.out.println("Medidas mayores a la media: " + mayorMedia);
        System.out.println("Medidas menores a la media: " + menorMedia);

    }
}
