
import java.util.Scanner;

public class ClashRoyale {

	public static void main(String[] args) {

		int opcion = menu();

		do {
			opcion = menu();
			System.out.println("");
			switch (opcion) {
			case 1:
				cofreArgent argent = new cofreArgent();
				argent.obrirCofre();
				argent.mostrarCofre();

				break;
			case 2:
				cofreOr or = new cofreOr();
				or.obrirCofre();
				or.mostrarCofre();
				break;
			case 3:
				cofreCorones corones = new cofreCorones();
				corones.obrirCofre();
				corones.mostrarCofre();
				break;
			case 4:
				cofreLighting lighting = new cofreLighting();
				lighting.obrirCofre();
				lighting.mostrarCofre();
				break;
			case 5:
				cofreLegendari legendari = new cofreLegendari();
				legendari.obrirCofre();
				legendari.mostrarCofre();
				break;
			case 6:
				System.out.println("Saliendo Clash Royale");
				break;
			default:
				System.out.println("Error.");
			}
			System.out.println("");
		} while (opcion != 6);

	}

	private static int menu() {

		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("1- Cofre d’argent\n" + "2- Cofre d’or\n" + "3- Cofre d’or de corones \n"
					+ "4- Cofre Mega Lighting\n" + "5- Cofre Legendari\n" + "6- Salir");
			System.out.print("Opción: ");
			opcion = sc.nextInt();
		} while (opcion < 1 || opcion > 6);
		return opcion;

	}

}
