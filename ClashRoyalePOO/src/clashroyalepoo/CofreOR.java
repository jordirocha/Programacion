/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clashroyalepoo;

import java.util.ArrayList;

/**
 *
 * @author jordi
 */
public class CofreOR extends cofreGeneric {

    @Override
    public void obrirCofre() {
        this.monedas = numerosAleatorios(420, 480);
        for (int i = 0; i < 3; i++) {
            Carta nueva = cartaEscoger(disponibles);
            int posicion = cartas.indexOf(nueva);
            if (posicion == -1) {
                cartas.add(nueva);
            } else {
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
