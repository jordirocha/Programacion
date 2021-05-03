
public class cofreLegendari extends cofreGeneric {

	@Override
	public void obrirCofre() {
		Carta escogida;
		do {
			escogida = cartaAleatoria();
		} while (escogida.getTipo() != Tipo_carta.LEGENDARIA);
		salen.add(escogida);
	}

}
