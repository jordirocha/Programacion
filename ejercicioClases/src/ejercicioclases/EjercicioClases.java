package ejercicioclases;

import java.util.Arrays;
import java.util.Scanner;

public class EjercicioClases {

    public static void main(String[] args) {

        Agenda[] contactos = new Agenda[10];

        int opcion, amigos = 0;
        Boolean correcte;

        inicializarAgenda(contactos);

        do {
            opcion = opciones();

            switch (opcion) {
                case 1:
                    listarContactos(contactos, amigos);
                    break;
                case 2:
                    amigos = afegirContactos(contactos, amigos);
                    break;
                case 3:
                    encontrarAmigo(contactos, amigos);
                    break;
                case 4:
                    amigos = borrarAmigo(contactos, amigos);
                    break;
                case 5:
                    actualizarTelPorNombre(contactos, amigos);
                    break;
                case 6:
                    buscarNombrePorTelefono(contactos, amigos);
                    break;
                case 7:
                    ordenadorPorTelefono(contactos, amigos);
                    break;
                default:
                    System.out.println("Adios");
            }
        } while (opcion != 0);

    }

    private static int opciones() {

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("1-listar amigos.");
            System.out.println("2-añadir amigos");
            System.out.println("3-encontrar amigos");
            System.out.println("4-eliminar amigos");
            System.out.println("5-Canviar telefon a partir del nom");
            System.out.println("6-Cercar nom a partir del telèfon");
            System.out.println("7-Ordenar per telèfon");
            System.out.print("opcion: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 7);

        return opcion;

    }

    private static void listarContactos(Agenda[] contactos, int amigos) {

        for (int i = 0; i < amigos; i++) {
            System.out.println((i + 1) + " Nombre: " + contactos[i].nombre + ", Email:" + contactos[i].email + ", Telefono: " + contactos[i].telefon);
        }

        System.out.println("amigos listados: " + amigos);

    }

    private static int afegirContactos(Agenda[] contactos, int amigos) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce nombre: ");
        contactos[amigos].nombre = sc.nextLine();
        System.out.print("Introduce email: ");
        contactos[amigos].email = sc.nextLine();
        System.out.print("Introduce número de telefono: ");
        contactos[amigos].telefon = sc.nextLong();
        amigos++;

        return amigos;

    }

    private static void inicializarAgenda(Agenda[] contactos) {

        for (int i = 0; i < contactos.length; i++) {
            contactos[i] = new Agenda();
        }

        // Arrays.fill(contactos, new Agenda());
    }

    private static void encontrarAmigo(Agenda[] contactos, int amigos) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce nombre del amigo, devolveré la posición: ");
        String encontrar = sc.nextLine();

        for (int i = 0; i < amigos; i++) {
            if (contactos[i].nombre.equalsIgnoreCase(encontrar)) {
                System.out.println("Tu amigo se encuentra en la posición:" + i);
            }
        }

    }

    private static int borrarAmigo(Agenda[] contactos, int amigos) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce nombre del amigo, se eliminará: ");
        String encontrar = sc.nextLine();

        for (int i = 0; i < amigos; i++) {
            if (contactos[i].nombre.equalsIgnoreCase(encontrar)) {
                for (int j = i; j < amigos - 1; j++) {
                    contactos[j].nombre = contactos[j + 1].nombre;
                    contactos[j].email = contactos[j + 1].email;
                    contactos[j].telefon = contactos[j + 1].telefon;
                }
                contactos[amigos - 1].nombre = "";
                contactos[amigos - 1].email = "";
                contactos[amigos - 1].telefon = 0;
                amigos--;
            }
        }

        return amigos;

    }

    private static void actualizarTelPorNombre(Agenda[] contactos, int amigos) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce amigo: ");
        String encontrar = sc.nextLine();

        System.out.print("Introduce nuevo telefono: ");
        long tel = sc.nextLong();

        for (int i = 0; i < amigos; i++) {
            if (contactos[i].nombre.equalsIgnoreCase(encontrar)) {
                System.out.println("Amigo encontrado, se ha cambiado el telefono.");
                contactos[i].telefon = tel;
            }
        }

    }

    private static void buscarNombrePorTelefono(Agenda[] contactos, int amigos) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce telefono del amigo: ");
        long encontrar = sc.nextLong();

        for (int i = 0; i < amigos; i++) {
            if (contactos[i].telefon == encontrar) {
                System.out.println("Amigo encontrado: " + contactos[i].nombre);
            }
        }

    }

    private static void ordenadorPorTelefono(Agenda[] contactos, int amigos) {

        long auxTel;
        String auxNombre;
        String auxEmail;

        for (int i = 0; i < amigos; i++) {
            for (int j = 0; j < (amigos - 1); j++) {
                if (contactos[j].telefon > contactos[j + 1].telefon) {
                    //Guardamos los valores que se van a reemplazar
                    auxTel = contactos[j].telefon;
                    auxNombre = contactos[j].nombre;
                    auxEmail = contactos[j].email;
                    // Hacemos el cambio 
                    contactos[j].telefon = contactos[j + 1].telefon;
                    contactos[j].nombre = contactos[j + 1].nombre;
                    contactos[j].email = contactos[j + 1].email;
                    // Hacemos el cambio para el valor machacado 
                    contactos[j + 1].telefon = auxTel;
                    contactos[j + 1].nombre = auxNombre;
                    contactos[j + 1].email = auxEmail;
                }
            }
        }

        System.out.print("Amigos ordenador por telefono.");

    }

}
