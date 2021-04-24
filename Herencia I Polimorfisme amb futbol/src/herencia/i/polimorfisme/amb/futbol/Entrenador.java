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
public class Entrenador extends EquipoFutbol {

    private boolean tieneTitulo;

    public Entrenador(int id, String nombre, int edad, double salari) {
        super(id, nombre, edad, salari);
        this.tieneTitulo = true;
    }

    public boolean isTieneTitulo() {
        return tieneTitulo;
    }

    public void setTieneTitulo(boolean tieneTitulo) {
        this.tieneTitulo = tieneTitulo;
    }

    public void dirigirPartido() {
        System.out.println("Me encuentro dirigiendo partido.");
    }

    public void entrenar() {
        System.out.println("Me encuentro entrenand equipo.");
    }

}
