package clashroyalemejora;

import java.util.Arrays;
import java.util.Scanner;

public class ClashRoyaleMejora {

    public static void main(String[] args) throws InterruptedException {

        Cartas disponibles[] = new Cartas[15];
        Cartas misCartas[] = new Cartas[disponibles.length]; // puse length-1
        int opcion, monedas = 0, numCartas = 0;

        inicializarDisponibles(disponibles);
        incializarMisCartas(misCartas);

        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    mostrarDisponibles(disponibles);
                    break;
                case 2:
                    Thread.sleep(650);
                    int monedasNuevas = darMonedas();
                    monedas += monedasNuevas;
                    numCartas = obrirCarta(disponibles, misCartas, numCartas);
                    break;
                case 3:
                    mostrarMisCartas(misCartas, numCartas, monedas);
                    break;
                case 4:
                    buscarCarta(misCartas, numCartas);
                    break;
                case 5:
                    consultarMonedas(monedas);
                    break;
                case 6:
                    monedas = subirNivelCarta(monedas, numCartas, misCartas);
                    break;
                default:
                    System.out.println("Has salido de Clash Royale.");
            }
        } while (opcion != 0);

    }

    private static void inicializarDisponibles(Cartas[] disponibles) {

        for (int i = 0; i < disponibles.length; i++) {
            disponibles[i] = new Cartas();
        }

        disponibles[0].nombre = "Ejercito de esqueletos";
        disponibles[1].nombre = "Descarga";
        disponibles[2].nombre = "Tronco";
        disponibles[3].nombre = "Esqueletos";
        disponibles[4].nombre = "Valquiria";
        /* disponibles[5].nombre = "Bola de nieve";
        disponibles[6].nombre = "Bola de fuego";
        disponibles[7].nombre = "Flechas";
        disponibles[8].nombre = "P.E.K.K.A";
        disponibles[9].nombre = "Dragones esqueleto";
        disponibles[10].nombre = "Lanzafuegos";
        disponibles[11].nombre = "Bruja";
        disponibles[12].nombre = "Megaesbirro";
        disponibles[13].nombre = "Caballero";
        disponibles[14].nombre = "Barril de esqueletos";*/

        for (int i = 0; i < disponibles.length; i++) {
            disponibles[i].elixir = (int) (Math.random() * (7 - 2)) + 2;
        }

    }

    private static void incializarMisCartas(Cartas[] misCartas) {

        for (int i = 0; i < misCartas.length; i++) {
            misCartas[i] = new Cartas();
        }

    }

    private static void mostrarDisponibles(Cartas[] disponibles) {

        for (Cartas d : disponibles) {
            System.out.println("Nombre de la carta: " + ANSI_CYAN + d.nombre + ANSI_RESET + " | Elixir: " + ANSI_CYAN + d.elixir + ANSI_RESET + " | Nivel: " + ANSI_CYAN + d.nivellCarta + ANSI_RESET);
        }

    }

    private static int menu() {

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("1-Mostrar totes les cartes disponibles del joc\n"
                    + "2-Obrir Cofre\n"
                    + "3-Mostrar totes les teves cartes\n"
                    + "4-Buscar Carta\n"
                    + "5-Consulta saldo monedes\n"
                    + "6-Pujar nivell carta\n"
                    + "0.Sortir");
            System.out.print("Escoge opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 6);

        return opcion;

    }

    private static int darMonedas() {

        int monedas = (int) (Math.random() * (650 - 50)) + 50;
        System.out.println("Te han salido " + ANSI_YELLOW + monedas + ANSI_RESET + " monedas.");

        return monedas;

    }

    private static int obrirCarta(Cartas[] disponibles, Cartas[] misCartas, int numCartas) throws InterruptedException {

        Cartas cartaObtenida = new Cartas(); // La usaremos para guardar la carta retornada
        for (int i = 1; i <= 2; i++) {
            Thread.sleep(650);
            int cartaAleatoria = (int) (Math.random() * disponibles.length - 1);
            cartaObtenida = buscarDisponible(cartaAleatoria, disponibles);
            System.out.println("Has obtenido la carta: " + ANSI_CYAN + cartaObtenida.nombre + ANSI_RESET + " con " + ANSI_CYAN + cartaObtenida.puntsCarta + ANSI_RESET + " puntos de carta.");
            if (laTienes(cartaObtenida, misCartas, numCartas)) {
                System.out.println("Ya tienes la carta " + ANSI_RED + cartaObtenida.nombre + ANSI_RESET + " se acumalarán los " + ANSI_RED + cartaObtenida.puntsCarta + ANSI_RESET + " puntos de carta.");
            } else {
                System.out.println("Carta " + ANSI_PURPLE + cartaObtenida.nombre + ANSI_RESET + " desbloqueada.");
                misCartas[numCartas].nombre = cartaObtenida.nombre;
                misCartas[numCartas].elixir = cartaObtenida.elixir;
                misCartas[numCartas].nivellCarta = cartaObtenida.nivellCarta;
                misCartas[numCartas].puntsCarta = cartaObtenida.puntsCarta;
                numCartas++;
            }
        }

        return numCartas;

    }

    private static Cartas buscarDisponible(int cartaAleatoria, Cartas[] disponibles) {

        Cartas nueva = new Cartas();

        nueva.nombre = disponibles[cartaAleatoria].nombre;
        nueva.elixir = disponibles[cartaAleatoria].elixir;
        nueva.nivellCarta = disponibles[cartaAleatoria].nivellCarta;
        nueva.puntsCarta = puntsCarta();
        return nueva;

    }

    private static int puntsCarta() {

        return (int) (Math.random() * 20) + 1;

    }

    private static boolean laTienes(Cartas cartaObtenida, Cartas[] misCartas, int numCartas) {

        for (int i = 0; i < numCartas; i++) {
            if (misCartas[i].nombre.equalsIgnoreCase(cartaObtenida.nombre)) {
                misCartas[i].puntsCarta += cartaObtenida.puntsCarta;
                return true;
            }
        }

        return false;

    }

    private static void mostrarMisCartas(Cartas[] misCartas, int numCartas, int monedas) {

        for (int i = 0; i < numCartas; i++) {
            System.out.println("Nombre de la carta: " + ANSI_CYAN + misCartas[i].nombre + ANSI_RESET
                    + " | Elixir: " + ANSI_CYAN + misCartas[i].elixir + ANSI_RESET + " | Nivel: "
                    + ANSI_CYAN + misCartas[i].nivellCarta + ANSI_RESET + " | Puntos de carta: " + ANSI_CYAN + misCartas[i].puntsCarta + ANSI_RESET);
        }

        System.out.println("Tienes " + ANSI_YELLOW + numCartas + ANSI_RESET + " de " + ANSI_YELLOW + misCartas.length + ANSI_RESET + " cartas.");
        System.out.println("Tienes " + ANSI_YELLOW + monedas + ANSI_RESET + " monedas.");

    }

    private static void buscarCarta(Cartas[] misCartas, int numCartas) {

        Scanner sc = new Scanner(System.in);

        boolean encontrada = false;

        System.out.print("¿Nombre de la carta? ");
        String carta = sc.nextLine();

        for (int i = 0; i < numCartas; i++) {
            if (misCartas[i].nombre.equalsIgnoreCase(carta)) {
                encontrada = true;
                System.out.println("La carta " + ANSI_CYAN + misCartas[i].nombre + ANSI_RESET + " ha sido entrada.");
                System.out.println("Nombre de la carta: " + ANSI_CYAN + misCartas[i].nombre + ANSI_RESET
                        + " | Elixir: " + ANSI_CYAN + misCartas[i].elixir + ANSI_RESET + " | Nivel: "
                        + ANSI_CYAN + misCartas[i].nivellCarta + ANSI_RESET + " | Puntos de carta: " + ANSI_CYAN + misCartas[i].puntsCarta + ANSI_RESET);
                break;
            }
        }

        if (!encontrada) {
            System.out.println("La carta " + ANSI_RED + carta + ANSI_RESET + " no ha sido entrada.");
        }

    }

    private static void consultarMonedas(int monedas) {

        System.out.println("Tienes " + ANSI_YELLOW + monedas + ANSI_RESET + " monedas.");

    }

    private static int subirNivelCarta(int monedas, int numCartas, Cartas[] misCartas) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        boolean encontrada = false;

        System.out.print("¿Nombre de la carta? ");
        String carta = sc.nextLine();

        for (int i = 0; i < numCartas; i++) {
            if (misCartas[i].nombre.equalsIgnoreCase(carta)) {
                encontrada = true;
                if ((misCartas[i].nivellCarta + 1) * 1000 < monedas
                        && (misCartas[i].nivellCarta + 1) * 10 <= misCartas[i].puntsCarta) {
                    System.out.println("Mejorar cuesta " + ANSI_YELLOW + (misCartas[i].nivellCarta + 1) * 1000 + ANSI_RESET + " y tienes " + ANSI_YELLOW + monedas + ANSI_RESET
                            + " monedas\nPuntos de carta " + ANSI_YELLOW + (misCartas[i].nivellCarta + 1) * 10 + ANSI_RESET + " y tienes " + ANSI_YELLOW + misCartas[i].puntsCarta + ANSI_RESET + " puntos");
                    misCartas[i].puntsCarta -= (misCartas[i].nivellCarta + 1) * 10;
                    monedas -= (misCartas[i].nivellCarta + 1) * 1000;
                    misCartas[i].nivellCarta++;
                    barraNivel(misCartas, i);
                    ordenarPorNivel(numCartas, misCartas);
                    return monedas;
                } else {
                    System.out.println("No dispones de suficientes puntos para mejorar la carta " + ANSI_YELLOW + misCartas[i].nombre + ANSI_RESET);
                }
            }
        }

        if (!encontrada) {
            System.out.println("La carta " + ANSI_YELLOW + carta + ANSI_RESET + " no ha sido entrada.");
        }

        return monedas;

    }

    private static void ordenarPorNivel(int numCartas, Cartas[] misCartas) {

        Cartas aux = new Cartas();

        for (int i = 0; i < numCartas; i++) {
            for (int j = 0; j < (numCartas - 1); j++) {
                if (misCartas[j].nivellCarta < misCartas[j + 1].nivellCarta) {
                    aux.nombre = misCartas[j + 1].nombre;
                    aux.elixir = misCartas[j + 1].elixir;
                    aux.nivellCarta = misCartas[j + 1].nivellCarta;
                    aux.puntsCarta = misCartas[j + 1].puntsCarta;
                    misCartas[j + 1].nombre = misCartas[j].nombre;
                    misCartas[j + 1].elixir = misCartas[j].elixir;
                    misCartas[j + 1].nivellCarta = misCartas[j].nivellCarta;
                    misCartas[j + 1].puntsCarta = misCartas[j].puntsCarta;
                    misCartas[j].nombre = aux.nombre;
                    misCartas[j].elixir = aux.elixir;
                    misCartas[j].nivellCarta = aux.nivellCarta;
                    misCartas[j].puntsCarta = aux.puntsCarta;
                }
            }
        }

    }

    private static void barraNivel(Cartas[] misCartas, int i) throws InterruptedException {

        System.out.print("Subiendo " + ANSI_CYAN + misCartas[i].nombre + ANSI_RESET + " de nivel "
                + ANSI_CYAN + (misCartas[i].nivellCarta - 1) + ANSI_RESET + " a nivel " + ANSI_CYAN + misCartas[i].nivellCarta + ANSI_RESET + "\n[");

        for (int j = 0; j < 10; j++) {
            System.out.print(ANSI_PURPLE + "==");
            Thread.sleep(550);
        }

        System.out.println(ANSI_RESET + "]");

    }

    public static final String ANSI_CYAN = "\u001B[36m"; // Para las cartas
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m"; // Volver texto a blanco
    public static final String ANSI_YELLOW = "\u001B[33m"; // Para monedas

}
