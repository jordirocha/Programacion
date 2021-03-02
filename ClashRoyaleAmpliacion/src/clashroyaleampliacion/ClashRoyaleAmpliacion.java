package clashroyaleampliacion;

import java.util.Scanner;

public class ClashRoyaleAmpliacion {

    public static void main(String[] args) throws InterruptedException {

        Cartas disponibles[] = new Cartas[5];
        Usuarios player[] = new Usuarios[4];
        int[] cartasJugador = new int[player.length];
        String nuevoUsuario;
        int posicion = 0, opcion, count = 0;
        //boolean existe;

        inicializarDisponibles(disponibles);

        //System.out.println("Iniciado Clash Royale...");
        //Thread.sleep(850);
        nuevoUsuario = introducirCuenta();

        count = inicializarPlayers(nuevoUsuario, player, posicion, count);
        //System.out.println("Jugadores actualmente: " + count);

        inicializarBarrallaJugador(posicion, player, disponibles);

        do {
            System.out.println("Conectado en la cuenta: " + player[posicion].nom.toUpperCase() + " ID " + posicion);
            System.out.println("Jugadores actualmente: " + count);
            opcion = menu();
            switch (opcion) {
                case 1:
                    mostrarDisponibles(disponibles);
                    break;
                case 2:
                    int coins = darMonedas();
                    player[posicion].monedas += coins;
                    cartasJugador[posicion] = abriCofre(disponibles, cartasJugador, posicion, player);
                    break;
                case 3:
                    mostrarCartas(cartasJugador, posicion, player);
                    break;
                case 4:
                    encontrarCarta(cartasJugador, posicion, player);
                    break;
                case 5:
                    consultarSaldo(posicion, player);
                    break;
                case 6:
                    player[posicion].monedas = subirNivelCarta(posicion, player, cartasJugador);
                    break;
                case 7:
                    nuevoUsuario = introducirCuenta();
                    boolean encontrada = existeJugador(nuevoUsuario, count, player);
                    if (!encontrada) {
                        if (count < 4) {
                            System.out.println("No se ha encontrado el usuario: " + nuevoUsuario + " será creado con una baraja de cartas.");
                            count = inicializarPlayers(nuevoUsuario, player, posicion, count);
                            posicion = canviarDeJugador(nuevoUsuario, count, player);
                            inicializarBarrallaJugador(posicion, player, disponibles);
                        } else {
                            System.out.println("No puedes tener más de " + player.length + " jugadores.");
                        }
                    } else {
                        System.out.println("Usuario " + nuevoUsuario + " se ha encontrado.");
                        posicion = canviarDeJugador(nuevoUsuario, count, player);
                    }
                    //posicion = canviarDeJugador(nuevoUsuario, player, posicion);
                    //inicializarPlayers(nuevoUsuario, player, posicion);
                    //inicializarBarrallaJugador(posicion, player, disponibles);
                    break;
                case 8:
                    transferirCartas(player, count, posicion, cartasJugador);
                    break;
                case 9:
                    int ordenacio = metodoOrdenacion();
                    switch (ordenacio) {
                        case 1:
                            porNombre(player, posicion, cartasJugador);
                            break;
                        case 2:
                            porElixir(player, posicion, cartasJugador);
                            break;
                        case 3:
                            porNivell(player, posicion, cartasJugador);
                            break;
                        default:
                            System.out.println("Opcion incorrecta.");
                    }
                    break;
                default:
                    System.out.println("Adiós.");
            }
        } while (opcion != 0);

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
                    + "7-Canviar de compte de jugador\n"
                    + "8-Transferir carta a un company clan\n"
                    + "9-Ordenació per criteris\n"
                    + "0.Sortir");
            System.out.print("Escoge opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 9);

        return opcion;

    }

    private static void inicializarDisponibles(Cartas[] disponibles) {

        for (int i = 0; i < disponibles.length; i++) {
            disponibles[i] = new Cartas();
            disponibles[i].elixir = (int) (Math.random() * (7 - 2)) + 2;
        }

        disponibles[0].nom = "Ejercito de esqueletos";
        disponibles[1].nom = "Descarga";
        disponibles[2].nom = "Tronco";
        disponibles[3].nom = "Esqueletos";
        disponibles[4].nom = "Valquiria";
//        disponibles[5].nom = "Bola de nieve";
//        disponibles[6].nom = "Bola de fuego";
//        disponibles[7].nom = "Flechas";
//        disponibles[8].nom = "P.E.K.K.A";
//        disponibles[9].nom = "Dragones esqueleto";
//        disponibles[10].nom = "Lanzafuegos";
//        disponibles[11].nom = "Bruja";
//        disponibles[12].nom = "Megaesbirro";
//        disponibles[13].nom = "Caballero";
//        disponibles[14].nom = "Barril de esqueletos";

    }

    private static String introducirCuenta() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce nombre de cuenta: ");
        String carta = sc.nextLine();

        return carta;

    }

    private static int inicializarPlayers(String nuevoUsuario, Usuarios[] player, int posicion, int count) {

        player[count] = new Usuarios();
        player[count].nom = nuevoUsuario;
//        for (int i = 0; i < player.length; i++) {
//            player[i] = new Usuarios();
//        }

        // player[posicion].nom = nuevoUsuario; // Para el jugador que inicia el programa
        return ++count;
    }

    private static void inicializarBarrallaJugador(int posicion, Usuarios[] player, Cartas[] disponibles) {

        player[posicion].baralla = new Cartas[disponibles.length]; // Le damos el espacio en memoria

        for (int i = 0; i < disponibles.length; i++) { // Inicializamos las 15 posiciones con memoria de las carta
            player[posicion].baralla[i] = new Cartas();
        }

    }

    private static void mostrarDisponibles(Cartas[] disponibles) {

        for (Cartas d : disponibles) {
            System.out.println("Nombre de la carta: " + d.nom + " | Elixir: " + d.elixir);
        }

    }

    private static int darMonedas() {

        int monedas = (int) (Math.random() * (650 - 50)) + 50;
        System.out.println("Te han salido " + monedas + " monedas.");

        return monedas;

    }

    private static int abriCofre(Cartas[] disponibles, int[] cartasJugador, int posicion, Usuarios[] player) {

        Cartas cartaObtenida = new Cartas();

        for (int i = 1; i <= 2; i++) {
            int cartaAleatoria = (int) (Math.random() * disponibles.length);
            cartaObtenida = buscarCarta(cartaAleatoria, disponibles);
            if (yaExiste(cartaObtenida, player, posicion, cartasJugador)) {
                System.out.println("Ya tienes la carta: " + cartaObtenida.nom.toUpperCase() + " sus " + cartaObtenida.puntsCarta + " puntos se acumulan.");
            } else {
                System.out.println("Nueva carta " + cartaObtenida.nom.toUpperCase() + " obtenida con " + cartaObtenida.puntsCarta);
                player[posicion].baralla[cartasJugador[posicion]].nom = cartaObtenida.nom;
                player[posicion].baralla[cartasJugador[posicion]].elixir = cartaObtenida.elixir;
                player[posicion].baralla[cartasJugador[posicion]].puntsCarta = cartaObtenida.puntsCarta;
                player[posicion].baralla[cartasJugador[posicion]].nivell = cartaObtenida.nivell;
                cartasJugador[posicion]++;
            }
        }

        return cartasJugador[posicion];
    }

    private static Cartas buscarCarta(int cartaAleatoria, Cartas[] disponibles) {

        Cartas nueva = new Cartas();

        nueva.nom = disponibles[cartaAleatoria].nom;
        nueva.elixir = disponibles[cartaAleatoria].elixir;
        nueva.nivell = disponibles[cartaAleatoria].nivell;
        nueva.puntsCarta = puntsCarta();

        return nueva;

    }

    private static int puntsCarta() {

        return (int) (Math.random() * 20) + 1;

    }

    private static boolean yaExiste(Cartas cartaObtenida, Usuarios[] player, int posicion, int[] cartasJugador) {

        for (int i = 0; i < cartasJugador[posicion]; i++) {
            if (player[posicion].baralla[i].nom.equalsIgnoreCase(cartaObtenida.nom)) {
                player[posicion].baralla[i].puntsCarta += cartaObtenida.puntsCarta;
                return true;
            }
        }

        return false;

    }

    private static void mostrarCartas(int[] cartasJugador, int posicion, Usuarios[] player) {

        for (int i = 0; i < cartasJugador[posicion]; i++) {
            System.out.println(player[posicion].baralla[i].nom + " | Nivell: "
                    + player[posicion].baralla[i].nivell + " | Puntos carta:"
                    + player[posicion].baralla[i].puntsCarta + " | Elixir " + player[posicion].baralla[i].elixir);
        }

        System.out.println("Tienes " + cartasJugador[posicion] + " de " + player[posicion].baralla.length + " cartas.");
        System.out.println("Tienes " + player[posicion].monedas + " monedas.");

    }

    private static void consultarSaldo(int posicion, Usuarios[] player) {

        System.out.println("Tienes " + player[posicion].monedas + " moendas disponibles.");

    }

    private static int canviarDeJugador(String nuevoUsuario, int count, Usuarios[] player) {

//        for (int i = 0; i < player.length; i++) {
//            if (player[posicion].nom.equalsIgnoreCase(player[i].nom)) {
//                System.out.println("Conectado con la cuenta " + nuevoUsuario);
//                return i;
//            }
//        }
        for (int i = 0; i < count; i++) {
            if (nuevoUsuario.equalsIgnoreCase(player[i].nom)) {
                //System.out.println("Se ha encontrado el jugador: " + nuevoUsuario);
                return i;
            }
        }

        return count;

    }

    private static int metodoOrdenacion() {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("1-Ordenació per nom\n"
                    + "2-Ordenació per elixir\n"
                    + "3-Ordenació per nivell");
            System.out.print("Escoge opción: ");
            opcion = sc.nextInt();
        } while (opcion < 1 && opcion > 3);

        return opcion;

    }

    private static void porNombre(Usuarios[] player, int posicion, int[] cartasJugador) {

        Cartas aux = new Cartas();

        for (int i = 0; i < cartasJugador[posicion]; i++) {
            for (int j = 0; j < (cartasJugador[posicion] - 1); j++) {
                if (player[posicion].baralla[j].nom.compareTo(player[posicion].baralla[j + 1].nom) > 0) {
                    aux.nom = player[posicion].baralla[j + 1].nom;
                    aux.elixir = player[posicion].baralla[j + 1].elixir;
                    aux.nivell = player[posicion].baralla[j + 1].nivell;
                    aux.puntsCarta = player[posicion].baralla[j].puntsCarta;
                    player[posicion].baralla[j + 1].nom = player[posicion].baralla[j].nom;
                    player[posicion].baralla[j + 1].elixir = player[posicion].baralla[j].elixir;
                    player[posicion].baralla[j + 1].nivell = player[posicion].baralla[j].nivell;
                    player[posicion].baralla[j + 1].puntsCarta = player[posicion].baralla[j].puntsCarta;
                    player[posicion].baralla[j].nom = aux.nom;
                    player[posicion].baralla[j].elixir = aux.elixir;
                    player[posicion].baralla[j].nivell = aux.nivell;
                    player[posicion].baralla[j].puntsCarta = aux.puntsCarta;
                }
            }
        }

    }

    private static void porElixir(Usuarios[] player, int posicion, int[] cartasJugador) {

        Cartas aux = new Cartas();

        for (int i = 0; i < cartasJugador[posicion]; i++) {
            for (int j = 0; j < (cartasJugador[posicion] - 1); j++) {
                if (player[posicion].baralla[j].elixir > player[posicion].baralla[j + 1].elixir) {
                    aux.nom = player[posicion].baralla[j + 1].nom;
                    aux.elixir = player[posicion].baralla[j + 1].elixir;
                    aux.nivell = player[posicion].baralla[j + 1].nivell;
                    aux.puntsCarta = player[posicion].baralla[j].puntsCarta;
                    player[posicion].baralla[j + 1].nom = player[posicion].baralla[j].nom;
                    player[posicion].baralla[j + 1].elixir = player[posicion].baralla[j].elixir;
                    player[posicion].baralla[j + 1].nivell = player[posicion].baralla[j].nivell;
                    player[posicion].baralla[j + 1].puntsCarta = player[posicion].baralla[j].puntsCarta;
                    player[posicion].baralla[j].nom = aux.nom;
                    player[posicion].baralla[j].elixir = aux.elixir;
                    player[posicion].baralla[j].nivell = aux.nivell;
                    player[posicion].baralla[j].puntsCarta = aux.puntsCarta;
                }
            }
        }

    }

    private static void porNivell(Usuarios[] player, int posicion, int[] cartasJugador) {
        
        Cartas aux = new Cartas();

        for (int i = 0; i < cartasJugador[posicion]; i++) {
            for (int j = 0; j < (cartasJugador[posicion] - 1); j++) {
                if (player[posicion].baralla[j].nivell > player[posicion].baralla[j + 1].nivell) {
                    aux.nom = player[posicion].baralla[j + 1].nom;
                    aux.elixir = player[posicion].baralla[j + 1].elixir;
                    aux.nivell = player[posicion].baralla[j + 1].nivell;
                    aux.puntsCarta = player[posicion].baralla[j].puntsCarta;
                    player[posicion].baralla[j + 1].nom = player[posicion].baralla[j].nom;
                    player[posicion].baralla[j + 1].elixir = player[posicion].baralla[j].elixir;
                    player[posicion].baralla[j + 1].nivell = player[posicion].baralla[j].nivell;
                    player[posicion].baralla[j + 1].puntsCarta = player[posicion].baralla[j].puntsCarta;
                    player[posicion].baralla[j].nom = aux.nom;
                    player[posicion].baralla[j].elixir = aux.elixir;
                    player[posicion].baralla[j].nivell = aux.nivell;
                    player[posicion].baralla[j].puntsCarta = aux.puntsCarta;
                }
            }
        }
        
    }

    private static boolean existeJugador(String nuevoUsuario, int count, Usuarios[] player) {

        for (int i = 0; i < count; i++) {
            if (nuevoUsuario.equalsIgnoreCase(player[i].nom)) {
                return true;
            }
        }

        return false;

    }

    private static void transferirCartas(Usuarios[] player, int count, int posicion, int[] cartasJugador) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce nombre de cuenta: ");
        String usuario = sc.nextLine();

        System.out.print("Introduce nombre de la carta: ");
        String carta = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (player[i].nom.equalsIgnoreCase(usuario)) {
                System.out.println("Se ha encontrado el usuario.");
                for (int j = 0; j < cartasJugador[posicion]; j++) {
                    if (player[posicion].baralla[j].nom.equalsIgnoreCase(carta)
                            && player[posicion].baralla[j].puntsCarta > 0) {
                        System.out.println("Tienes la carta.");
                        for (int k = 0; k < cartasJugador[i]; k++) {
                            if (player[i].baralla[k].nom.equalsIgnoreCase(carta)) {
                                System.out.println("El jugador tiene la carta.");
                                System.out.print("¿Cuántas cartas quieres darle? dispones de" + player[posicion].baralla[j].puntsCarta + " puntos.");
                                int numero = sc.nextInt();
                                player[i].baralla[k].puntsCarta += numero;
                                player[i].monedas += 200;
                                player[posicion].baralla[j].puntsCarta -= numero;
                            }
                        }
                    }
                }
            }

        }

    }

    private static void encontrarCarta(int[] cartasJugador, int posicion, Usuarios[] player) {

        Scanner sc = new Scanner(System.in);

        boolean encontrada = false;

        System.out.print("Introduce nombre de la carta: ");
        String carta = sc.nextLine();

        for (int i = 0; i < cartasJugador[posicion]; i++) {
            if (player[posicion].baralla[i].nom.equalsIgnoreCase(carta)) {
                encontrada = true;
                System.out.println("Nombre de la carta: " + player[posicion].baralla[i].nom
                        + " | Elixir: " + player[posicion].baralla[i].elixir + " | Nivel: "
                        + player[posicion].baralla[i].nivell + " | Puntos de carta: " + player[posicion].baralla[i].puntsCarta);
                break;
            }
        }

        if (!encontrada) {
            System.out.println("La carta " + carta + " no ha sido entrada.");
        }

    }

    private static int subirNivelCarta(int posicion, Usuarios[] player, int[] cartasJugador) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        boolean encontrada = false;

        System.out.print("¿Nombre de la carta? ");
        String carta = sc.nextLine();

        for (int i = 0; i < cartasJugador[posicion]; i++) {
            if (player[posicion].baralla[i].nom.equalsIgnoreCase(carta)) {
                encontrada = true;
                if ((player[posicion].baralla[i].nivell + 1) * 1000 < player[posicion].monedas
                        && (player[posicion].baralla[i].nivell + 1) * 10 < player[posicion].baralla[i].puntsCarta) {
                    player[posicion].monedas -= (player[posicion].baralla[i].nivell + 1) * 1000;
                    player[posicion].baralla[i].puntsCarta -= (player[posicion].baralla[i].nivell + 1) * 10;
                    player[posicion].baralla[i].nivell++;
                    barraSubirNivel(player, posicion, i);
                    return player[posicion].monedas;
                }
            }
        }

        if (!encontrada) {
            System.out.println("La carta " + carta + " no ha sido entrada.");
        }

        return player[posicion].monedas;

    }

    private static void barraSubirNivel(Usuarios[] player, int posicion, int i) throws InterruptedException {

        System.out.print("La carta " + player[posicion].baralla[i].nom + " va a subir de nivel "
                + (player[posicion].baralla[i].nivell - 1) + " a " + player[posicion].baralla[i].nivell + " \n[");

        for (int j = 0; j < 10; j++) {
            System.out.print("==");
            Thread.sleep(550);
        }

        System.out.println("]");

    }

}
