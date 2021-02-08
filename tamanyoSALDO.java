package ejercicios2d;

import java.util.Scanner;

public class tamanyoSALDO {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Cuántos empleados tienes: ");
        int empleados = sc.nextInt();

        int h = 0, m = 0, salH = 0, salM = 0, genero = 0, saldo = 0;

        int salarios[][] = new int[2][empleados];

        for (int i = 0; i < salarios.length; i++) {
            for (int j = 0; j < salarios[i].length; j++) {
                if (empleados > 0) {
                    System.out.print("Sexo del empleado hombre (0) - mujer (1)? ");
                    genero = sc.nextInt();

                    System.out.print("Cuánto cobra? ");
                    saldo = sc.nextInt();

                    if (genero == 0) {
                        salarios[genero][h] = saldo;
                        salH += salarios[genero][h];
                        h++;
                    }

                    if (genero == 1) {
                        salarios[genero][m] = saldo;
                        salM += salarios[genero][m];
                        m++;
                    }
                    empleados--;
                }
            }
        }

        imprimirArray(salarios, m, h);
        conclusiones(h, salH, m, salM);

    }

    private static void imprimirArray(int[][] salarios, int m, int h) {

        System.out.println("Salarios de hombres: ");
        
        for (int j = 0; j < h; j++) {
            System.out.print(salarios[0][j] + " | ");
        }

        System.out.println("\nSalarios de mujeres: ");

        for (int j = 0; j < m; j++) {
            System.out.print(salarios[1][j] + " | ");
        }

    }

    private static void conclusiones(int h, int salH, int m, int salM) {

        System.out.println("\nHay un total de hombres con salario: " + h);
        System.out.println("El total dinero de los hombres es de: " + salH);
        System.out.println("Hay un total de mujeres con salario: " + m);
        System.out.println("El total dinero de las muejeres es de: " + salM);
        System.out.println("La media de los hombres es de " + ((double) salH / h) + " y de las mujeres " + ((double) salM / m));

        if (((double) salH / h) != ((double) salM / m)) {
            System.out.println("Hay brecha salarial.");
        }

    }

}
