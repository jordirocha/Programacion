/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicagestordecançons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jordi
 */
public class CancionDAO {

    /**
     * En este menú inicialmente se le pedirá al usuario los campos CLAVES y se
     * comprobará si ya existe en el ArrayList de canciones. En el caso de que
     * ya exista, se informará al usuario mediante el mensaje “ERROR: La canción
     * ya existe.”
     */
    void insertarCancion(ArrayList<cancion> canciones) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la canción: ");
        String titulo = sc.nextLine();

        System.out.print("Nombre del autor: ");
        String autor = sc.nextLine();

        cancion nueva = new cancion(titulo, autor);
        int indice = canciones.indexOf(nueva);
        if (indice == -1) {
            System.out.print("Nombre del album: ");
            String album = sc.nextLine();

            System.out.print("Duración de la canción: ");
            double duracion = sc.nextDouble();

            nueva.setDuracion(duracion);
            nueva.setAlbum(titulo);
            canciones.add(nueva);
        } else {
            System.out.println("ERROR: La canción " + nueva.getTitulo() + " ya existe.");
        }

    }

    /**
     * En el caso de que se haya eliminado correctamente la canción del
     * ArrayList de canciones, se informará al usuario mediante el mensaje:
     * “Canción eliminada”. En el caso de que la canción a borrar no exista y
     * por lo tanto no se pueda borrar del ArrayList de canciones, se informará
     * al usuario mediante el mensaje: “Canción no encontrada”
     */
    void borrarCancion(ArrayList<cancion> canciones) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la canción: ");
        String titulo = sc.nextLine();
        sc.nextLine();
        System.out.print("Nombre del autor: ");
        String autor = sc.nextLine();

        cancion eliminar = new cancion(titulo, autor);
        int indice = canciones.indexOf(eliminar);

        if (indice != -1) {
            System.out.println("Canción " + eliminar.getTitulo() + " eliminada.");
            canciones.remove(indice);
        } else {
            System.out.println("Canción " + eliminar.getTitulo() + " no encontrada");
        }

    }

    /**
     * En este menú se imprimirá el listado de todas las canciones (la info de
     * cada canción) que existan en el ArrayList de canciones. Solo se mostrara
     * nombre, titulo y duración. Utilizar metodo visto en clase
     */
    void listarCanciones(ArrayList<cancion> canciones) {
        if (canciones.size() > 0) {
            System.out.println(canciones.toString());
        } else {
            System.out.println("ERROR: No hay canciones suficiente.");
        }
    }

    /**
     * Cargo canciones por defecto
     */
    void cargarCanciones(ArrayList<cancion> canciones) {
        canciones.add(new cancion("Don't Stay", "Linkin Park", "Meteora", 3.16));
        canciones.add(new cancion("Waiting for the End", "Linkin Park", "A Thousand Suns", 4.49));
        canciones.add(new cancion("The Diary Of Jane", "Breaking Benjamin", "Phobia", 3.01));
        canciones.add(new cancion("Evil Angel", "Breaking Benjamin", "Phobia", 4.04));
        canciones.add(new cancion("In the End", "Linkin Park", "Living Things", 3.41));
        canciones.add(new cancion("Papercut", "Linkin Park", "Hybrid Theory", 3.04));
        canciones.add(new cancion("Forgotten", "Linkin Park", "Hybrid Theory", 3.14));
    }

    /**
     * Preguntará el nombre del álbum y luego mostrará los datos de todas las
     * canciones pertenecientes a ese álbum.
     */
    void listarCancionesAlbum(ArrayList<cancion> canciones) {
        Scanner sc = new Scanner(System.in);
        boolean existe = false;
        if (canciones.size() > 0) {
            System.out.print("Nombre del album: ");
            String album = sc.nextLine();
            for (int i = 0; i < canciones.size(); i++) {
                if (canciones.get(i).getAlbum().equalsIgnoreCase(album)) {
                    existe = true;
                    System.out.print(canciones.get(i).toString());
                }
            }
            if (!existe) {
                System.out.println("El album " + album + " no existe.");
            }
        } else {
            System.out.println("ERROR: No hay canciones suficiente.");
        }
    }

    /**
     * En este método se muestran los disintos tipos de albums de nuestra
     * colección
     */
    void listarDiferentesAlbums(ArrayList<cancion> canciones) {
        String albums[] = new String[canciones.size()];
        Arrays.fill(albums, "");
        int posicion = 0;
        for (int i = 0; i < canciones.size(); i++) {
            if (!Arrays.asList(albums).contains(canciones.get(i).getAlbum())) {
                albums[posicion] = canciones.get(i).getAlbum();
                posicion++;
            }
        }
        for (int i = 0; i < albums.length; i++) {
            if (!albums[i].equals("")) {
                System.out.print(albums[i] + "\n");
            }
        }
    }

    /**
     * En este método se generará un nuevo ArrayList que contendrá la lista de
     * reproducción generada. En esta lista de reproducción, inserta 3 canciones
     * de manera aleatoria del total de ArrayList de canciones (de la biblioteca
     * de SpotProven).
     */
    void generarListaDinamica(ArrayList<cancion> canciones) {
        ArrayList<cancion> listaAletoria = new ArrayList<>();
        int posicion;
        if (canciones.size() > 2) {
            for (int i = 1; i <= 3; i++) {
                do {
                    posicion = (int) (Math.random() * canciones.size());
                } while (listaAletoria.contains(canciones.get(posicion)));
                listaAletoria.add(canciones.get(posicion));
            }
            System.out.println("Lista de canciones dinámica para reproducir: ");
            for (int i = 0; i < listaAletoria.size(); i++) {
                System.out.print(listaAletoria.get(i).toString());
            }
        } else {
            System.out.println("Cómo minimo 3 canciones.");
        }

    }

}
