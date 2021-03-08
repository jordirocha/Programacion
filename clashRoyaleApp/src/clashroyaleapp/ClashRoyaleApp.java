package clashroyaleapp;

import java.util.Scanner;

public class ClashRoyaleApp {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        Cartas disponibles[] = new Cartas[5];
        Jugadores usuarios[] = new Jugadores[4];
        int cartasTuyas[] = new int[usuarios.length];
        int numJugadores = 0, posicionJugador = 0, opcion;
        String cuenta;

        incializarDisponibles(disponibles);

        System.out.println("Pulse Enter para entrar al juego");
        cuenta = nuevoUsuario(sc);

        numJugadores = incializarJugador(cuenta, numJugadores, usuarios, disponibles);

        do {
            System.out.println("\nConectado con el jugador: " + usuarios[posicionJugador].nom);
            System.out.println("ID del jugador: " + (posicionJugador + 1));
            opcion = menu(sc);
            System.out.println("");
            switch (opcion) {
                case 1:
                    mostrarDisponibles(disponibles);
                    break;
                case 2:
                    int monedas = obtenerAleatorio(50, 500);
                    System.out.println("Has obtenido " + monedas + " monedas."); // Lo pongo aquí por que quiero aprovechar la función: obtenerAleatorio
                    usuarios[posicionJugador].monedes += monedas;
                    cartasTuyas[posicionJugador] = obrirCofre(disponibles, posicionJugador, usuarios, cartasTuyas);
                    break;
                case 3:
                    mostrarCartes(usuarios, posicionJugador, cartasTuyas, disponibles);
                    break;
                case 5:
                    consultarMonedas(usuarios, posicionJugador);
                    break;
                case 6:
                    usuarios[posicionJugador].monedes = subirNivelCarta(cartasTuyas, usuarios, posicionJugador, sc);
                    break;
                case 7:
                    cuenta = nuevoUsuario(sc);
                    if (existeJugador(cuenta, numJugadores, usuarios)) {
                        System.out.println("Cambiando a jugador " + cuenta + ".");
                        posicionJugador = cambiarPosicion(cuenta, usuarios, numJugadores, posicionJugador);
                    } else {
                        if (numJugadores < 4) {
                            System.out.println("La cuenta " + cuenta + " no existe se creará nueva cuenta.");
                            numJugadores = incializarJugador(cuenta, numJugadores, usuarios, disponibles);
                            posicionJugador = cambiarPosicion(cuenta, usuarios, numJugadores, posicionJugador);
                        } else {
                            System.out.println("No puedes tener más de " + usuarios.length + " cuentas conectadas.");
                        }
                    }
                    break;
                case 8:
                    transferirCartas(posicionJugador, usuarios, cartasTuyas, sc, numJugadores);
                    break;
                case 9:
                    int tipo = tipoOrden(sc);
                    ordenarPorCriterios(usuarios, posicionJugador, cartasTuyas, sc, tipo);
                    break;
                default:
                    System.out.println("Has salido de la aplicación.");
            }
        } while (opcion != 0);

    }

    private static void incializarDisponibles(Cartas[] disponibles) {

        for (int i = 0; i < disponibles.length; i++) {
            disponibles[i] = new Cartas();
            disponibles[i].elixir = (int) (Math.random() * (7 - 2)) + 2;
        }

        disponibles[0].nom = "Ejercito de esqueletos";
        disponibles[1].nom = "Descarga";
        disponibles[2].nom = "Tronco";
        disponibles[3].nom = "Esqueletos";
        disponibles[4].nom = "Valquiria";
        /*disponibles[5].nom = "Bola de nieve";
        disponibles[6].nom = "Bola de fuego";
        disponibles[7].nom = "Flechas";
        disponibles[8].nom = "P.E.K.K.A";
        disponibles[9].nom = "Dragones esqueleto";
        disponibles[10].nom = "Lanzafuegos";
        disponibles[11].nom = "Bruja";
        disponibles[12].nom = "Megaesbirro";
        disponibles[13].nom = "Caballero";
        disponibles[14].nom = "Barril de esqueletos";*/

    }

    private static String nuevoUsuario(Scanner sc) {

        sc.nextLine(); // Limpieza de buffer
        System.out.print("Introduce cuenta de Clash Royale: ");
        String usuario = sc.nextLine();

        return usuario;

    }

    private static int incializarJugador(String usuario, int numJugadores, Jugadores[] usuarios, Cartas[] disponibles) {

        usuarios[numJugadores] = new Jugadores();
        usuarios[numJugadores].nom = usuario;
        usuarios[numJugadores].baralla = new Cartas[disponibles.length];

        return ++numJugadores;

    }

    private static int menu(Scanner sc) {

        int opcion;

        do {
            System.out.println("1-Mostrar totes les cartes disponibles del joc\n"
                    + "2-Obrir Cofre\n"
                    + "3-Mostrar totes les teves cartes\n"
                    + "4-Buscar Carta\n"
                    + "5-Consulta saldo monedes\n"
                    + "6-Pujar nivell carta\n"
                    + "7-Canviar de compte de jugador\n"
                    + "8-Transferir carta a un company clan\n"
                    + "9-Ordenació per criteris\n"
                    + "0-Salir");
            System.out.print("Escoge opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 9);

        return opcion;

    }

    private static void mostrarDisponibles(Cartas[] disponibles) {

        for (Cartas disponible : disponibles) {
            System.out.println("Carta: " + disponible.nom + " Elixir: " + disponible.elixir);
        }

    }

    private static int obtenerAleatorio(int min, int max) {

        return (int) (Math.random() * max) + min;

    }

    private static int obrirCofre(Cartas[] disponibles, int posicionJugador, Jugadores[] usuarios, int[] cartasTuyas) {

        Cartas nuevaCarta = new Cartas();

        for (int i = 0; i < 2; i++) {
            nuevaCarta = cartaAleatoria(disponibles);
            if (laTienes(nuevaCarta, cartasTuyas, posicionJugador, usuarios)) {
                System.out.println("Ya tienes la carta " + nuevaCarta.nom.toUpperCase() + " se acumularán los " + nuevaCarta.punts + " puntos.");
            } else {
                System.out.println("Nueva carta " + nuevaCarta.nom.toUpperCase() + " con " + nuevaCarta.punts + " puntos.");
                usuarios[posicionJugador].baralla[cartasTuyas[posicionJugador]] = nuevaCarta;
                cartasTuyas[posicionJugador]++;
            }
        }

        return cartasTuyas[posicionJugador];
    }

    private static Cartas cartaAleatoria(Cartas[] disponibles) {

        Cartas escogida = new Cartas();

        int aleatoria = obtenerAleatorio(0, disponibles.length); //(int) (Math.random() * disponibles.length);   
        int puntos = obtenerAleatorio(1, 20);

        escogida.nom = disponibles[aleatoria].nom;
        escogida.elixir = disponibles[aleatoria].elixir;
        escogida.nivell = disponibles[aleatoria].nivell;
        escogida.punts = puntos;

        return escogida;
    }

    private static boolean laTienes(Cartas nuevaCarta, int[] cartasTuyas, int posicionJugador, Jugadores[] usuarios) {

        for (int i = 0; i < cartasTuyas[posicionJugador]; i++) {
            if (usuarios[posicionJugador].baralla[i].nom.equalsIgnoreCase(nuevaCarta.nom)) {
                usuarios[posicionJugador].baralla[i].punts += nuevaCarta.punts;
                return true;
            }
        }

        return false;

    }

    private static void mostrarCartes(Jugadores[] usuarios, int posicionJugador, int[] cartasTuyas, Cartas[] disponibles) {

        for (int i = 0; i < cartasTuyas[posicionJugador]; i++) {
            System.out.println("Carta: " + usuarios[posicionJugador].baralla[i].nom + " Elixir: " + usuarios[posicionJugador].baralla[i].elixir
                    + " Nivell: " + usuarios[posicionJugador].baralla[i].nivell + " Puntos: " + usuarios[posicionJugador].baralla[i].punts);
        }

        System.out.println("Tienes " + cartasTuyas[posicionJugador] + " de " + disponibles.length + " cartas.");

    }

    private static void consultarMonedas(Jugadores[] usuarios, int posicionJugador) {

        System.out.println("Dispones de " + usuarios[posicionJugador].monedes + " monedas.");

    }

    private static int subirNivelCarta(int[] cartasTuyas, Jugadores[] usuarios, int posicionJugador, Scanner sc) throws InterruptedException {

        sc.nextLine(); // Limpieza de buffer

        System.out.print("¿Qué carta quieres mejorar de las que tienes? ");
        String carta = sc.nextLine();

        for (int i = 0; i < cartasTuyas[posicionJugador]; i++) {
            if (usuarios[posicionJugador].baralla[i].nom.equalsIgnoreCase(carta)) {
                System.out.println("Carta " + usuarios[posicionJugador].baralla[i].nom + " ha sido encontrada.");
                if ((usuarios[posicionJugador].baralla[i].nivell + 1) * 1000 < usuarios[posicionJugador].monedes
                        && (usuarios[posicionJugador].baralla[i].nivell + 1) * 10 < usuarios[posicionJugador].baralla[i].punts) {
                    System.out.println("Te va a costar " + (usuarios[posicionJugador].baralla[i].nivell + 1) * 1000 + " monedas "
                            + "y tienes " + usuarios[posicionJugador].monedes);
                    System.out.println("Te va a costar " + (usuarios[posicionJugador].baralla[i].nivell + 1) * 10 + " puntos de carta "
                            + "y tienes " + usuarios[posicionJugador].baralla[i].punts);
                    usuarios[posicionJugador].monedes -= (usuarios[posicionJugador].baralla[i].nivell + 1) * 1000;
                    usuarios[posicionJugador].baralla[i].punts -= (usuarios[posicionJugador].baralla[i].nivell + 1) * 10;
                    usuarios[posicionJugador].baralla[i].nivell++;
                    barraSubirNivel(usuarios, posicionJugador, i);
                    return usuarios[posicionJugador].monedes;
                }
            }
        }

        return usuarios[posicionJugador].monedes;

    }

    private static void barraSubirNivel(Jugadores[] usuarios, int posicionJugador, int i) throws InterruptedException {

        System.out.print("La carta " + usuarios[posicionJugador].baralla[i].nom + " va a subir de nivel "
                + (usuarios[posicionJugador].baralla[i].nivell - 1) + " a " + usuarios[posicionJugador].baralla[i].nivell + " \n[");

        for (int j = 0; j < 10; j++) {
            System.out.print("==");
            Thread.sleep(550);
        }

        System.out.println("]");
    }

    private static boolean existeJugador(String cuenta, int numJugadores, Jugadores[] usuarios) {

        for (int i = 0; i < numJugadores; i++) {
            if (usuarios[i].nom.equalsIgnoreCase(cuenta)) {
                return true;
            }
        }

        return false;

    }

    private static int cambiarPosicion(String cuenta, Jugadores[] usuarios, int numJugadores, int posicionJugador) {

        for (int i = 0; i < numJugadores; i++) {
            if (usuarios[i].nom.equalsIgnoreCase(cuenta)) {
                return i;
            }
        }

        return posicionJugador;

    }

    private static void transferirCartas(int posicionJugador, Jugadores[] usuarios, int[] cartasTuyas, Scanner sc, int numJugadores) {

        sc.nextLine(); // Limpieza de buffer

        int monedas;

        System.out.print("¿Nombre de la carta? ");
        String carta = sc.nextLine();

        System.out.print("¿A quién quieres darle puntos? ");
        String cuenta = sc.nextLine();

        for (int i = 0; i < cartasTuyas[posicionJugador]; i++) {
            if (usuarios[posicionJugador].baralla[i].nom.equalsIgnoreCase(carta)) {
                System.out.println("La carta " + carta + " existe en tu cuenta.");
                for (int j = 0; j < numJugadores; j++) {
                    if (usuarios[j].nom.equalsIgnoreCase(cuenta)) {
                        System.out.println("La cuenta: " + cuenta + " existe en los usuarios.");
                        for (int k = 0; k < cartasTuyas[j]; k++) {
                            if (usuarios[j].baralla[k].nom.equalsIgnoreCase(carta)) {
                                System.out.println("El usuario tiene la carta " + carta);
                                monedas = usuarios[posicionJugador].baralla[i].punts; // Cantidad de puntos de cartas de la escogida
                                while (monedas > 8) {
                                    monedas--;
                                    // System.out.println("Hasta que sea menor a 8 " + monedas);
                                }
                                System.out.println("De tus " + usuarios[posicionJugador].baralla[i].punts + " puntos de esta carta se le darán " + monedas);
                                usuarios[j].baralla[k].punts += monedas;
                                usuarios[j].monedes += 200;
                                usuarios[posicionJugador].baralla[i].punts -= monedas;
                            }
                        }
                    }
                }
            }
        }

    }

    private static void ordenarPorCriterios(Jugadores[] usuarios, int posicionJugador, int[] cartasTuyas, Scanner sc, int opcion) {

        Cartas aux = new Cartas(); // Auxiliar para guardar variables

        for (int i = 0; i < cartasTuyas[posicionJugador]; i++) {
            for (int j = 0; j < (cartasTuyas[posicionJugador] - 1); j++) {
                if (opcion == 1) { // Por nombre
                    if (usuarios[posicionJugador].baralla[j].nom.compareTo(usuarios[posicionJugador].baralla[j + 1].nom) > 0) {
                        aux.nom = usuarios[posicionJugador].baralla[j + 1].nom;
                        aux.elixir = usuarios[posicionJugador].baralla[j + 1].elixir;
                        aux.punts = usuarios[posicionJugador].baralla[j + 1].punts;
                        aux.nivell = usuarios[posicionJugador].baralla[j + 1].nivell;
                        usuarios[posicionJugador].baralla[j + 1].nom = usuarios[posicionJugador].baralla[j].nom;
                        usuarios[posicionJugador].baralla[j + 1].elixir = usuarios[posicionJugador].baralla[j].elixir;
                        usuarios[posicionJugador].baralla[j + 1].nivell = usuarios[posicionJugador].baralla[j].nivell;
                        usuarios[posicionJugador].baralla[j + 1].punts = usuarios[posicionJugador].baralla[j].punts;
                        usuarios[posicionJugador].baralla[j].nom = aux.nom;
                        usuarios[posicionJugador].baralla[j].elixir = aux.elixir;
                        usuarios[posicionJugador].baralla[j].nivell = aux.nivell;
                        usuarios[posicionJugador].baralla[j].punts = aux.punts;
                    }
                } else if (opcion == 2) { // Por elixir
                    if (usuarios[posicionJugador].baralla[j].elixir > usuarios[posicionJugador].baralla[j + 1].elixir) {
                        aux.nom = usuarios[posicionJugador].baralla[j + 1].nom;
                        aux.elixir = usuarios[posicionJugador].baralla[j + 1].elixir;
                        aux.punts = usuarios[posicionJugador].baralla[j + 1].punts;
                        aux.nivell = usuarios[posicionJugador].baralla[j + 1].nivell;
                        usuarios[posicionJugador].baralla[j + 1].nom = usuarios[posicionJugador].baralla[j].nom;
                        usuarios[posicionJugador].baralla[j + 1].elixir = usuarios[posicionJugador].baralla[j].elixir;
                        usuarios[posicionJugador].baralla[j + 1].nivell = usuarios[posicionJugador].baralla[j].nivell;
                        usuarios[posicionJugador].baralla[j + 1].punts = usuarios[posicionJugador].baralla[j].punts;
                        usuarios[posicionJugador].baralla[j].nom = aux.nom;
                        usuarios[posicionJugador].baralla[j].elixir = aux.elixir;
                        usuarios[posicionJugador].baralla[j].nivell = aux.nivell;
                        usuarios[posicionJugador].baralla[j].punts = aux.punts;
                    }
                } else if (opcion == 3) { // Por nivell
                    if (usuarios[posicionJugador].baralla[j].nivell < usuarios[posicionJugador].baralla[j + 1].nivell) {
                        aux.nom = usuarios[posicionJugador].baralla[j + 1].nom;
                        aux.elixir = usuarios[posicionJugador].baralla[j + 1].elixir;
                        aux.punts = usuarios[posicionJugador].baralla[j + 1].punts;
                        aux.nivell = usuarios[posicionJugador].baralla[j + 1].nivell;
                        usuarios[posicionJugador].baralla[j + 1].nom = usuarios[posicionJugador].baralla[j].nom;
                        usuarios[posicionJugador].baralla[j + 1].elixir = usuarios[posicionJugador].baralla[j].elixir;
                        usuarios[posicionJugador].baralla[j + 1].nivell = usuarios[posicionJugador].baralla[j].nivell;
                        usuarios[posicionJugador].baralla[j + 1].punts = usuarios[posicionJugador].baralla[j].punts;
                        usuarios[posicionJugador].baralla[j].nom = aux.nom;
                        usuarios[posicionJugador].baralla[j].elixir = aux.elixir;
                        usuarios[posicionJugador].baralla[j].nivell = aux.nivell;
                        usuarios[posicionJugador].baralla[j].punts = aux.punts;
                    }
                }
            }
        }

    }

    private static int tipoOrden(Scanner sc) {

        int opcion;

        do {
            System.out.println("1-Ordenació per nom\n"
                    + "2-Ordenació per elixir\n"
                    + "3-Ordenació per nivell");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
        } while (opcion < 1 || opcion > 3);

        return opcion;

    }

}
