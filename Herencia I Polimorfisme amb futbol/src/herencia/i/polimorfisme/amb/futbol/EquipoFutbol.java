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
public class EquipoFutbol {

    private int id;
    private String nombre;
    private int edad;
    protected double salari;

    public EquipoFutbol(int id, String nombre, int edad, double salari) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.salari = salari;
    }

    public void mostrarSalario(){
        System.out.println(this.salari);
    }
    
    public void mostrarNom() {
        System.out.println(this.nombre);
    }

    public void viajar() {
        System.out.println(this.nombre + " viajo al partit");
    }

    public void concentrarse() {
        System.out.println(this.nombre + " hem concentro a l'hotel.");
    }

}
