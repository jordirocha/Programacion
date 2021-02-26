package clashroyalecartas;

import java.util.Scanner;

public class ClashRoyaleCartas {

    public static void main(String[] args) throws InterruptedException {

        Cartas disponibles[] = new Cartas[15];
        Cartas misCartas[] = new Cartas[disponibles.length - 1];
        int opcion, numCarts = 0, monedas = 0;

        for (int i = 0; i < misCartas.length; i++) { // Inicializamos la memoria que necesita para cada posición de mis cartas
            misCartas[i] = new Cartas();
        }

        incializarCartas(disponibles);

        do {
            opcion = menuOpciones();
            switch (opcion) {
                case 1:
                    mostrarDisponibles(disponibles);
                    break;
                case 2:
                    int coins = darMonedas();
                    monedas += coins; // Acumulado de las monedas obtenias del cofre
                    numCarts = obrirCofre(disponibles, misCartas, numCarts, coins);
                    break;
                case 3:
                    mostrarMisCartas(misCartas, numCarts);
                    break;
                case 4:
                    buscarCarta(misCartas, numCarts);
                    break;
                case 5:
                    consultarSaldoMonedas(monedas);
                    break;
                case 6:
                    monedas = subirNivelCarta(numCarts, misCartas, monedas);
                    break;
                default:
                    System.out.println("Has salido de Clash Royale.");
            }
        } while (opcion != 0);

    }

    private static void incializarCartas(Cartas[] disponibles) {

        for (int i = 0; i < disponibles.length; i++) { // Inicializamos la memoria que necesita para cada posición
            disponibles[i] = new Cartas();
        }

        disponibles[0].nombre = "Ejercito de esqueletos";
        disponibles[1].nombre = "Descarga";
        disponibles[2].nombre = "Tronco";
        disponibles[3].nombre = "Barril de duendes";
        disponibles[4].nombre = "Valquiria";
        disponibles[5].nombre = "Bebe dragón";
        disponibles[6].nombre = "Bola de fuego";
        disponibles[7].nombre = "Flechas";
        disponibles[8].nombre = "P.E.K.A";
        disponibles[9].nombre = "Mega Caballero";
        disponibles[10].nombre = "Mago electrico";
        disponibles[11].nombre = "Bruja";
        disponibles[12].nombre = "Principe";
        disponibles[13].nombre = "Caballero";
        disponibles[14].nombre = "Globo Bombastico";

        for (int i = 0; i < disponibles.length; i++) { // Rellenamos para cada posición de elixir un aleatorio
            disponibles[i].elixir = (int) (Math.random() * (6 - 3)) + 3;
        }

    }

    private static void mostrarDisponibles(Cartas[] disponibles) {

        for (int i = 0; i < disponibles.length; i++) {
            System.out.println(ANSI_BLUE_BACKGROUND + (i + 1) + ": carta -> " + disponibles[i].nombre + " | elixir -> " + disponibles[i].elixir + ANSI_RESET);
        }

    }

    private static int menuOpciones() {

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("1-Mostrar todas las cartas disponibles del juego\n"
                    + "2-Obrir Cofre\n"
                    + "3-Mostrar totes les teves cartes\n"
                    + "4-Buscar Carta\n"
                    + "5-Consulta saldo monedes\n"
                    + "6-Pujar nivell carta\n"
                    + "0. Sortir");
            System.out.print("Escoge opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 6);

        return opcion;

    }

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private static int obrirCofre(Cartas[] disponibles, Cartas[] misCartas, int numCarts, int coins) throws InterruptedException {

        Cartas nuevaCarta = new Cartas(); // Almaceno la carta que me devolverá para ser guardada o sino solo acumular los puntos en el caso de que sea repetida

        for (int i = 1; i <= 2; i++) {
            nuevaCarta = obrirCarta(disponibles);
            System.out.println("Te ha salido la carta " + nuevaCarta.nombre + " Elixir " + nuevaCarta.elixir + " Nivel carta " + nuevaCarta.nivellCarta + " Puntos carta " + nuevaCarta.puntsCarta);
            if (yaExiste(disponibles, misCartas, numCarts, nuevaCarta)) {
                System.out.println("Ya tienes está carta " + ANSI_RED + nuevaCarta.nombre + ANSI_RESET + " se acumularán los " + ANSI_RED + nuevaCarta.puntsCarta + ANSI_RESET + " puntos obtenidos.");
            } else {
                System.out.println(ANSI_GREEN + "Nueva carta, añadirá a tu zona de cartas." + ANSI_RESET);
                misCartas[numCarts].nombre = nuevaCarta.nombre;
                misCartas[numCarts].elixir = nuevaCarta.elixir;
                misCartas[numCarts].nivellCarta = nuevaCarta.nivellCarta;
                misCartas[numCarts].puntsCarta = nuevaCarta.puntsCarta;
                numCarts++;
            }
            Thread.sleep(650);
        }

        return numCarts;

    }

    private static int darMonedas() {

        int monedas = (int) (Math.random() * (800 - 50)) + 50;
        System.out.println("Has recibido " + ANSI_YELLOW + monedas + ANSI_RESET + " monedas.");

        return monedas;

    }

    private static Cartas obrirCarta(Cartas[] disponibles) {

        int cartaAleatoria = (int) (Math.random() * disponibles.length);

        Cartas anyadir = new Cartas();

        anyadir.nombre = disponibles[cartaAleatoria].nombre;
        anyadir.elixir = disponibles[cartaAleatoria].elixir;
        anyadir.nivellCarta = disponibles[cartaAleatoria].nivellCarta;
        anyadir.puntsCarta = puntsCarta();

        return anyadir;

    }

    private static int puntsCarta() {

        return (int) (Math.random() * 20) + 1;

    }

    private static void mostrarMisCartas(Cartas[] misCartas, int numCarts) {

        for (int i = 0; i < numCarts; i++) {
            System.out.println(ANSI_YELLOW + "Carta " + misCartas[i].nombre + " con " + misCartas[i].puntsCarta
                    + " puntos, nivel " + misCartas[i].nivellCarta + " y " + misCartas[i].elixir + " de elixir." + ANSI_RESET);
        }

        System.out.println("Tienes un total de " + ANSI_GREEN + numCarts + ANSI_RESET + " cartas de " + ANSI_GREEN + misCartas.length + "." + ANSI_RESET);

    }

    private static boolean yaExiste(Cartas[] disponibles, Cartas[] misCartas, int numCarts, Cartas nuevaCarta) {

        for (int i = 0; i < numCarts; i++) {
            if (misCartas[i].nombre.equalsIgnoreCase(nuevaCarta.nombre)) {
                misCartas[i].puntsCarta += nuevaCarta.puntsCarta;
                return true;
            }
        }

        return false;

    }

    private static void consultarSaldoMonedas(int monedas) {

        System.out.println("Tienes " + ANSI_YELLOW + monedas + ANSI_RESET + " monedas disponibles.");

    }

    private static void buscarCarta(Cartas[] misCartas, int numCarts) {

        Scanner sc = new Scanner(System.in);

        boolean encontrada = false;

        System.out.print("¿Nombre de la carta? ");
        String carta = sc.nextLine();

        for (int i = 0; i < numCarts; i++) {
            if (misCartas[i].nombre.equalsIgnoreCase(carta)) {
                encontrada = true;
                System.out.println("Carta encontrada:");
                System.out.println(ANSI_YELLOW + "Carta " + misCartas[i].nombre + " con " + misCartas[i].puntsCarta
                        + " puntos, nivel " + misCartas[i].nivellCarta + " y " + misCartas[i].elixir + " de elixir." + ANSI_RESET);
            }
        }

        if (!encontrada) {
            System.out.println("La carta " + ANSI_RED + carta + ANSI_RESET + " no existe :(.");
        }

    }

    private static int subirNivelCarta(int numCarts, Cartas[] misCartas, int monedas) {

        Scanner sc = new Scanner(System.in);

        boolean encontrada = false;

        System.out.print("¿Nombre de la carta? ");
        String carta = sc.nextLine();

        for (int i = 0; i < numCarts; i++) {
            if (misCartas[i].nombre.equalsIgnoreCase(carta)) {
                if ((misCartas[i].nivellCarta + 1) * 1000 < monedas
                        && (misCartas[i].nivellCarta + 1) * 10 < misCartas[i].puntsCarta) {
                    encontrada = true;
                    System.out.println("Tus puntos " + monedas + " son mayores a " + (misCartas[i].nivellCarta + 1) * 1000
                            + " y " + (misCartas[i].nivellCarta + 1) * 10 + " es menor a sus " + misCartas[i].puntsCarta + " puntos.");
                    // Aquí cometí el error de novato, yo primero le sumaba 1 nivel y claro las otras dos dependen de él, si subo a nivel 1, cuandos restemos le sumará 1 de más
                    // en puntos no restará 1000 sino 2000, por eso obtenia valores negativos
                    monedas = monedas - ((misCartas[i].nivellCarta + 1) * 1000); // Primero restamos las monedas, ya que si primero aumentamos de nivel le sumará otro más
                    System.out.println(monedas);

                    misCartas[i].puntsCarta -= ((misCartas[i].nivellCarta + 1) * 10);
                    System.out.println(misCartas[i].puntsCarta);

                    misCartas[i].nivellCarta += 1; // Es nivel debe ser lo último que se debe cambiar, sino podriamos devolver datos erroneos
                    System.out.println("Nivel subido a " + misCartas[i].nivellCarta);

                    return monedas;
                }
            }
        }

        if (!encontrada) {
            System.out.println("La carta " + ANSI_RED + carta + ANSI_RESET + " no puede ser subida de nivel.");
        }

        return monedas;

    }

}
