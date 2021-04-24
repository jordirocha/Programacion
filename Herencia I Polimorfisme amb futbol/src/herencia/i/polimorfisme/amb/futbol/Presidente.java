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
public class Presidente extends EquipoFutbol {

    private int añosCargo;

    public Presidente(int añosCargo, int id, String nombre, int edad, double salari) {
        super(id, nombre, edad, salari);
        this.añosCargo = añosCargo;
    }

    public void irPalcoPartido() {
        System.out.println("Estoy en el palco partido.");
    }

    public void tratarContrato(String equipoFutbol) {
        System.out.println("Tratand con equipo " + equipoFutbol);
    }

    @Override
    public void viajar() {
        super.viajar(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Viatjo amb primera.");
    }

}
