enum Tipo_carta {
	LEGENDARIA, EPICA, RARA, COMUN
}

public class Carta {

	String nombre;
	int elixir;
	int level;
	int puntos_carta;
	Tipo_carta tipo;
	int arena;

	public Carta(String nombre, int elixir, Tipo_carta tipo, int arena) {
		this.nombre = nombre;
		this.elixir = elixir;
		this.tipo = tipo;
		this.arena = arena;
	}

	public String getNombre() {
		return nombre;
	}

	public int getElixir() {
		return elixir;
	}

	public int getLevel() {
		return level;
	}

	public int getPuntos_carta() {
		return puntos_carta;
	}

	public Tipo_carta getTipo() {
		return tipo;
	}

	public int getArena() {
		return arena;
	}

	public void setPuntos_carta(int puntos_carta) {
		this.puntos_carta += puntos_carta;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return this.nombre.equalsIgnoreCase(other.nombre);
	}

	@Override
	public String toString() {
		return nombre + " | Puntos Carta:  " + puntos_carta + " | Tipo: " + tipo + " | Arena: " + arena;
	}

}
