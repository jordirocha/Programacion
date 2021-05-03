
public class cofreArgent extends cofreGeneric {

	@Override
	public void obrirCofre() {
		this.monedas = aleatoria(105, 120);
//		for (int i = 0; i < 2; i++) { // Sin version 2.0
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
		int rara = 1;
		for (int i = 0; i < 2; i++) {
			if (rara > 0) { // Sacará una carta tipo RARA
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
