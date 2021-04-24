/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.i.polimorfisme.amb.futbol;

/**
 *
 * @author Alan Jordi Rocha Roc
 */
public class Masajista extends EquipoFutbol {

    private boolean titulacion;

    public Masajista(boolean titulacion, int id, String nombre, int edad, double salari) {
        super(id, nombre, edad, salari);
        this.titulacion = titulacion;
    }

 

    public void darMasaje() {
        System.out.println("Estoy masajenado.");
    }

}
