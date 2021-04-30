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
public class CofreLighting extends cofreGeneric {

    @Override
    public void obrirCofre() {
        this.monedas = 7614;
        ArrayList<Carta> diferentes = diferentesCartas(disponibles); // Me devolverán un ArrayList con las 5 cartas
        System.out.println("Tamaño de las 5 cartas sacadas: " + diferentes.size());
        for (int i = 0; i < diferentes.size(); i++) {
            cartas.add(diferentes.get(i));
        }
    }

    private int numerosAleatorios(int min, int max) { // Este método sería monedas, pero lo he implementado como general de aleatorios
        return (int) (Math.random() * (max - min)) + min;
    }

    private ArrayList<Carta> diferentesCartas(ArrayList<Carta> disponibles) {
        ArrayList<Carta> escogidas = new ArrayList<>();
        int aleatoria;
        int epicas = 2;
        for (int i = 0; i < 5; i++) {
            if (epicas > 0) {
                do {
                    aleatoria = numerosAleatorios(0, disponibles.size());
                } while (disponibles.get(aleatoria).getTipo() != Tipo_carta.EPICA || escogidas.contains(disponibles.get(aleatoria)));
                escogidas.add(disponibles.get(aleatoria));
                epicas--;
            } else {
                do {
                    aleatoria = numerosAleatorios(0, disponibles.size());
                } while (escogidas.contains(disponibles.get(aleatoria)));
                escogidas.add(disponibles.get(aleatoria));
            }
            // escogidas.get(i).setPuntsCarta(numerosAleatorios(1, 20)); Según la tabla estas no tendrán puntos
        }
        return escogidas;
    }
}
