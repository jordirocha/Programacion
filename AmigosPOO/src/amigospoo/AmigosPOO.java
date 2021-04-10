package amigospoo;

import java.util.ArrayList;
import java.util.Scanner;

public class AmigosPOO {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Persona> personas = new ArrayList();
        int opcion;

        do {

            recienAñadida(personas); // Simplemente para mostrar información de nuestra lista

            opcion = menu(sc);

            System.out.println(""); // Para separar los mensajes
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    añadirPersona(personas, sc);
                    break;
                case 2:
                    mostrarDatosPersonas(personas, sc);
                    break;
                case 3:
                    eliminarPersona(personas, sc);
                    break;
                case 4:
                    cambiarEdadPersona(personas, sc);
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación.");
            }

        } while (opcion != 0);

    }

    private static int menu(Scanner sc) {

        int opcion;

        do {
            System.out.println("1.- Añadir persona");
            System.out.println("2.- Mostrar datos persona buscando por nombre");
            System.out.println("3.- Eliminar persona");
            System.out.println("4.- Canviar edad persona");
            System.out.println("0.- Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 4);

        return opcion;

    }

    private static void añadirPersona(ArrayList<Persona> personas, Scanner sc) {

        Persona p = datosPersona(sc); // Devolvemos un objeto persona

        if (personas.contains(p)) {
            System.out.println("\nYa tienes agregado a " + p.getNombre());
        } else {
            personas.add(p);
            System.out.println("\n" + p.getNombre() + " añadido.");
        }

    }

    private static Persona datosPersona(Scanner sc) {

        Persona nueva = new Persona();

        System.out.print("Nombre de la nueva persona: ");
        String nombre = sc.nextLine();

        System.out.print("Edad de la persona: ");
        int edad = sc.nextInt();

        System.out.print("Sexo de la nueva persona: ");
        char sexo = sc.next().charAt(0);

        nueva.setNombre(nombre);
        nueva.setEdad(edad);
        nueva.setSexo(sexo);

        return nueva; // Devolvemos una persona que despues será añadida

    }

    private static void recienAñadida(ArrayList<Persona> personas) {

        if (personas.size() > 0) { // Simplemente es para mostrar datos de la lista
            System.out.println("\nÚltima persona añadida: " + personas.get(personas.size() - 1).getNombre());
            System.out.println("Total de personas: " + personas.size());
        }

    }

    private static void mostrarDatosPersonas(ArrayList<Persona> personas, Scanner sc) {

        System.out.print("Nombre de la persona: ");
        String nombre = sc.nextLine();

        Persona buscar = new Persona(nombre); // Guardamos el nombre en un objeto nuevo

        if (personas.contains(buscar)) { // Si existe mostraremos sus datos
            int indice = personas.indexOf(buscar); // Con este modo no necesitaría un bucle FOR
            if (indice != -1) {
                System.out.println(personas.get(indice).toString());
            }
        } else {
            System.out.println("\nNo existe " + buscar.getNombre() + " no existe.");
        }

    }

    private static void eliminarPersona(ArrayList<Persona> personas, Scanner sc) {

        System.out.print("¿Qué persona quieres borrar? ");
        String nombre = sc.nextLine();

        Persona eliminar = new Persona(nombre); // Guardamos el nombre en un objeto nuevo

        if (personas.contains(eliminar)) { // Si existe lo eliminaremos esta persona
            int indice = personas.indexOf(eliminar); // Con este modo no necesitaría un bucle FOR
            if (indice != -1) {
                personas.remove(indice);
                System.out.println("\n" + nombre + " ha sido eliminado de tu lista.");
            }
        } else {
            System.out.println("\n" + eliminar.getNombre() + " no existe en tu lista de amigos.");
        }

    }

    private static void cambiarEdadPersona(ArrayList<Persona> personas, Scanner sc) {

        System.out.print("¿Nombre de la persona a cambiar edad? ");
        String nombre = sc.nextLine();

        System.out.print("¿Nuevo edad? ");
        int edad = sc.nextInt();

        Persona nuevo = new Persona(nombre); // Guardamos el nombre en un objeto nuevo
        nuevo.setEdad(edad); // La edad la añadimos al objeto

        if (personas.contains(nuevo)) { // Si existe lo cambiaremos la edad
            int indice = personas.indexOf(nuevo); // Con este modo no necesitaría un bucle FOR
            if (indice != -1) { 
                System.out.println("\n" + nombre + " su edad cambiada a: " + nuevo.getEdad());
                personas.get(indice).setEdad(nuevo.getEdad());

            }
        } else {
            System.out.println("\n" + nombre + " no existe.");
        }

    }

}
