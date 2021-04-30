/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clashroyalepoo;

import java.util.ArrayList;

/**
 *
 * @author Alan Jordi Rocha Roc
 */
public abstract class cofreGeneric {

    protected int monedas;
    protected ArrayList<Carta> cartas;
    protected ArrayList<Carta> disponibles;

    public cofreGeneric() {
        cartas = new ArrayList<>();
        disponibles = new ArrayList<>();
        cargarCartas(disponibles);
    }

    public abstract void obrirCofre();

    public void mostrarCofre() {
        System.out.println("Monedas del cofre " + monedas + " monedas");
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println(cartas.get(i).toString());
        }
    }

    private void cargarCartas(ArrayList<Carta> disponibles) {
        disponibles.add(new Carta("Pekka", 7, Tipo_carta.EPICA, 0));
        disponibles.add(new Carta("Mosquetera", 2, Tipo_carta.RARA, 0));
        disponibles.add(new Carta("Lenyador", 1, Tipo_carta.COMUN, 2));
        disponibles.add(new Carta("Bombastico", 4, Tipo_carta.RARA, 4));
        disponibles.add(new Carta("Chispas", 3, Tipo_carta.LEGENDARIA, 5));
        disponibles.add(new Carta("Minero", 4, Tipo_carta.LEGENDARIA, 2));
        disponibles.add(new Carta("Lanzafuegos", 1, Tipo_carta.COMUN, 2));
        disponibles.add(new Carta("Torre tesla", 1, Tipo_carta.RARA, 2));
        disponibles.add(new Carta("Dragones esqueleto", 1, Tipo_carta.EPICA, 2));
        disponibles.add(new Carta("Paquete real", 1, Tipo_carta.EPICA, 2));
    }

}
