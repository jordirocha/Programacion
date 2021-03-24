/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

enum marca {
    Yamaha, Nissan
}

enum tipoAuto {
    Moto, Coche
}

/**
 *
 * @author jordi
 */
public class Autos {

    private int matricula;
    private tipoAuto tipo;
    private marca marcaAuto;
    private int ruedas;
    private int puertas;
    private int peso;
    private String color;

    public Autos(int matricula) { // Auto de tipo coche, matricula se tiene que ponder

        this.matricula = matricula;
        marcaAuto = marca.Nissan;
        tipo = tipoAuto.Coche;
        ruedas = 4;
        puertas = 4;
        peso = 2000;

    }

    public Autos(int matricula, int peso) { // Auto tipo moto, peso a elegir

        this.matricula = matricula;
        marcaAuto = marca.Yamaha;
        tipo = tipoAuto.Moto;
        ruedas = 2;
        this.peso = peso;

    }

    public int getMatricula() {
        return matricula;
    }

    public tipoAuto getTipo() {
        return tipo;
    }

    public marca getMarcaAuto() {
        return this.marcaAuto;
    }

    public int getRuedas() {
        return this.ruedas;
    }

    public int getPuertas() {
        return this.puertas;
    }

    public int getPeso() {
        return this.peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
