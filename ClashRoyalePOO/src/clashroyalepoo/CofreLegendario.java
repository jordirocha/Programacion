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
public class CofreLegendario extends cofreGeneric {

    @Override
    public void obrirCofre() {
        int aleatoria;
        do {
            aleatoria = numerosAleatorios(0, disponibles.size());
        } while (disponibles.get(aleatoria).getTipo() != Tipo_carta.LEGENDARIA);
        // Segun la tabla la carta no tendrá puntos
        cartas.add(disponibles.get(aleatoria));
    }

    private int numerosAleatorios(int min, int max) { // Este método sería monedas, pero lo he implementado como general de aleatorios
        return (int) (Math.random() * (max - min)) + min;
    }

}
