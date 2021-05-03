
public class cofreCorones extends cofreGeneric {

	private int gemas;

	public int getGemas() {
		return gemas;
	}

	@Override
	public void obrirCofre() {
		this.gemas = aleatoria(1, 5);
		System.out.println("Gemas obtenidas: " + getGemas());
		this.monedas = aleatoria(1050, 1200);
		
//		for (int i = 0; i < 3; i++) {
//			Carta escogida = cartaAleatoria();
//			escogida.setPuntos_carta(aleatoria(0, 20));
//			int indice = salen.indexOf(escogida);
//			if (indice == -1) {
//				salen.add(escogida);
//			} else {
//				System.out.println("La carta " + escogida.getNombre() + " se ha repetido, puntos a acumular "
//						+ escogida.getPuntos_carta());
//				salen.get(indice).setPuntos_carta(escogida.getPuntos_carta());
//			}
//		}
		Carta escogida;
		int rara = 4;
		for (int i = 0; i < 7; i++) { // Sacará cuatro cartas distintas tipo RARA
			if (rara > 0) { 
				do {
					escogida = cartaAleatoria();
				} while (escogida.getTipo() != Tipo_carta.RARA || salen.contains(escogida));
				rara--;
			} else { // Con la versión 2.0 no habrán cartas repetidas
				do {
					escogida = cartaAleatoria();
				} while (escogida.getTipo() == Tipo_carta.RARA || salen.contains(escogida));
			}
			escogida.setPuntos_carta(aleatoria(0, 20));
			salen.add(escogida);
		}

	}

}
