
public class cofreLighting extends cofreGeneric {

	@Override
	public void obrirCofre() {
		this.monedas = 7614;
		int epicas = 3;
		int rara = 4; // Version 2.0
		Carta escogida;
//		for (int i = 0; i < 5; i++) {
//			if (epicas > 0) { // Primero sacaré las cartas epicas
//				do {
//					escogida = cartaAleatoria();
//				} while (escogida.getTipo() != Tipo_carta.EPICA || salen.contains(escogida));
//				salen.add(escogida);
//				epicas--;
//			} else { // Cartas aleatorias que siempre serán disintas
//				do {
//					escogida = cartaAleatoria();
//				} while (salen.contains(escogida));
//				salen.add(escogida);
//			}
//		}	

		for (int i = 0; i < 10; i++) { // Sacará 3 epicas y 4 raras distintas
			if (rara > 0) {
				do {
					escogida = cartaAleatoria();
				} while (escogida.getTipo() != Tipo_carta.RARA || salen.contains(escogida));
				rara--;
			} else if (epicas > 0) {

				do {
					escogida = cartaAleatoria();
				} while (escogida.getTipo() != Tipo_carta.EPICA || salen.contains(escogida));
				epicas--;

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
