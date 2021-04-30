package clashroyalepoo;

import java.util.Objects;

enum Tipo_carta {
    LEGENDARIA, EPICA, RARA, COMUN
}

public class Carta {

    private String nombre;
    private int elixir;
    private int level;
    protected int puntsCarta;
    private Tipo_carta tipo;
    private int arena;

    public Carta(String nombre, int elixir, Tipo_carta tipo, int arena) {
        this.nombre = nombre;
        this.elixir = elixir;
        this.tipo = tipo;
        this.arena = arena;
        this.puntsCarta = 0;
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

    public int getPuntsCarta() {
        return puntsCarta;
    }

    public Tipo_carta getTipo() {
        return tipo;
    }

    public int getArena() {
        return arena;
    }

    public void setPuntsCarta(int puntsCarta) {
        this.puntsCarta += puntsCarta; // Implementado para que vaya acumulando puntos obtenidos
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        return this.nombre.equalsIgnoreCase(other.nombre);
    }

    @Override
    public String toString() {
        return "nombre " + nombre.toUpperCase() + ", puntos de la carta: " + puntsCarta + ", tipo " + tipo;
    }

}
