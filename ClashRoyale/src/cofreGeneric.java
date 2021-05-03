import java.util.ArrayList;

public abstract class cofreGeneric {

	// private int nivelCofre;
	protected int monedas;
	protected ArrayList<Carta> salen;
	private ArrayList<Carta> Disponibles;

	public cofreGeneric() {
		salen = new ArrayList<>();
		Disponibles = new ArrayList<>();
		cargarDisponibles(Disponibles);
		// nivelCofre = 2;
	}

//	public int getNivelCofre() {
//		return nivelCofre;
//	}

//	public void setNivelCofre(int nivelCofre) {
//		this.nivelCofre = nivelCofre;
//	}

	public abstract void obrirCofre();

	public void mostrarCofre() {
		System.out.println("Monedas que te ha tocado: " + this.monedas);
		for (int i = 0; i < salen.size(); i++) {
			System.out.println(salen.get(i).toString());
		}
	}

	protected Carta cartaAleatoria() { // Sin nivel implementado
		Carta temp = Disponibles.get(aleatoria(0, Disponibles.size()));
		Carta escogida = new Carta(temp.getNombre(), temp.getElixir(), temp.getTipo(), temp.getArena());
		return escogida;
	}

//	protected Carta cartaAleatoria() { // Sacará cartas segun el nivel del cofre
//		Carta temp;
//		do {
//			temp = Disponibles.get(aleatoria(0, Disponibles.size()));
//		} while (temp.getArena() > getNivelCofre()); // Sacaremos cartas inferiores al nivel del usuario
//		Carta escogida = new Carta(temp.getNombre(), temp.getElixir(), temp.getTipo(), temp.getArena());
//		return escogida;
//	}

	protected int aleatoria(int min, int max) {
		return (int) (Math.random() * (max - min)) + min;
	}

	private void cargarDisponibles(ArrayList<Carta> disponibles) {
		disponibles.add(new Carta("Pekka", 7, Tipo_carta.EPICA, 4));
		disponibles.add(new Carta("Mosquetera", 2, Tipo_carta.RARA, 3));
		disponibles.add(new Carta("Lenyador", 1, Tipo_carta.COMUN, 2));
		disponibles.add(new Carta("Bombastico", 4, Tipo_carta.RARA, 4));
		disponibles.add(new Carta("Chispas", 3, Tipo_carta.RARA, 1));
		disponibles.add(new Carta("Minero", 4, Tipo_carta.LEGENDARIA, 2));
		disponibles.add(new Carta("Lanzafuegos", 1, Tipo_carta.COMUN, 1));
		disponibles.add(new Carta("Torre tesla", 1, Tipo_carta.RARA, 2));
		disponibles.add(new Carta("Dragones esqueleto", 1, Tipo_carta.EPICA, 2));
		disponibles.add(new Carta("Paquete real", 1, Tipo_carta.EPICA, 1));
	}

}
