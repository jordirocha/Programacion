/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicagestordecançons;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jordi
 */
public class PracticaGestordecançons {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<cancion> canciones = new ArrayList();
        CancionDAO utils = new CancionDAO();
        int opcion;

        utils.cargarCanciones(canciones); // Cargo 4 canciones por defecto

        do {
            System.out.println("\nTotal de canciones dentro: " + canciones.size());
            opcion = menuOpciones();
            System.out.println("");
            switch (opcion) {
                case 1:
                    utils.insertarCancion(canciones);
                    break;
                case 2:
                    utils.borrarCancion(canciones);
                    break;
                case 3:
                    utils.listarCanciones(canciones);
                    break;
                case 4:
                    utils.generarListaDinamica(canciones);
                    break;
                case 5:
                    utils.listarCancionesAlbum(canciones);
                    break;
                case 6:
                    utils.listarDiferentesAlbums(canciones);
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación.");
                    break;
                default:
                    System.out.println("Error.");
            }

        } while (opcion != 0);

    }

    private static int menuOpciones() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Insertar Canción\n"
                    + "2. Borrar Canción\n"
                    + "3. Listar Canciones\n"
                    + "4. Generar Lista de canciones dinámica para reproducir\n"
                    + "5. Listar canciones de un album\n"
                    + "6. Listar diferentes albums\n"
                    + "0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 6);
        return opcion;
    }

}
