package coordenadas;

public class Coordenadas {

    public static void main(String[] args) {

        int filas = 4, columnas = 3;
        int conecta[][] = new int[filas][columnas];

        System.out.println("longitud de la fila" + conecta.length);

        // Boolean ceros = true;

        /* for (int i = 0; i < conecta.length; i++) {
            if (conecta[i][columna] == 0) {
                ceros = false;
            }
        }*/
        conecta[3][0] = 8;
        conecta[3][1] = 0;
        conecta[1][1] = 4;
        conecta[3][1] = 0;
        conecta[0][0] = 1;
        conecta[3][2] = 0;
        conecta[3][0] = 1;
        System.out.println("");

        for (int i = 0; i < conecta.length; i++) {
            for (int j = 0; j < conecta[i].length; j++) {
                System.out.print(conecta[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        int tieneConecta = 0;

        int misColum = conecta[0].length - 1;

        do {
            for (int i = 0; i < conecta.length; i++) {
                System.out.println(conecta[i][misColum] + " ");
                if (conecta[i][misColum] == 0) {
                    tieneConecta++;
                    if (tieneConecta == 4) {
                        System.out.println("hay conecta en vertical.");
                    }
                } else {
                    tieneConecta = 0;
                }
            }
            System.out.println("");
            misColum--;
        } while (misColum >= 0);

    }
}
