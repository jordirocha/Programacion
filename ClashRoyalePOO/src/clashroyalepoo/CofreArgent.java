package clashroyalepoo;

import java.util.ArrayList;

/**
 *
 * @author Alan Jordi Rocha Roc
 */
public class CofreArgent extends cofreGeneric {

    @Override
    public void obrirCofre() {
        this.monedas = numerosAleatorios(105, 120);
        for (int i = 0; i < 2; i++) {
            Carta nueva = cartaEscoger(disponibles);
            int posicion = cartas.indexOf(nueva);
            if (posicion == -1) {
                cartas.add(nueva);
            } else {
               // System.out.println("Ya existe " + nueva.getNombre() + " se acumularán " + nueva.getPuntsCarta());
                cartas.get(posicion).setPuntsCarta(nueva.getPuntsCarta());
            }
        }
    }

    private int numerosAleatorios(int min, int max) { // Este método sería monedas, pero lo he implementado como general de aleatorios
        return (int) (Math.random() * (max - min)) + min;
    }

    private Carta cartaEscoger(ArrayList<Carta> disponibles) {
        int aleatoria = numerosAleatorios(0, disponibles.size());
        int puntos = numerosAleatorios(1, 20);
        Carta temp = disponibles.get(aleatoria);
        Carta escogida = new Carta(temp.getNombre(), temp.getElixir(), temp.getTipo(), temp.getArena());
        escogida.setPuntsCarta(puntos); // Le añado los puntos generados, siempre será 0 + puntos
        return escogida;
    }

}
