package escogercarta;

public class EscogerCarta {

    public static void main(String[] args) {

        int matriz[][] = new int[10][10];
        int tabla = 0;

        for (int i = 0; i < matriz.length; i++) {
            tabla++;
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[j][i] = tabla * j;
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Tabla de multiplicar " + (i + 1) + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("|" + matriz[j][i] + "| ");
            }
            System.out.println("");
        }

    }

}
