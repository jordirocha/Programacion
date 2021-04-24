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
public class Futbolista extends EquipoFutbol {

    private int goles;

    public Futbolista(int goles, int id, String nombre, int edad, double salari) {
        super(id, nombre, edad, salari);
        this.goles = goles;
    }

    public void jugarPartido() {
        System.out.println("Me encuentro jugando.");
        this.salari += 1000;
    }

    public void entrenar() {
        System.out.println("Me encuentro entrenando.");
    }

    @Override
    public void viajar() {
        super.viajar(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Viatjo amb primera.");
    }

}
