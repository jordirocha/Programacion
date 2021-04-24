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
public class HerenciaIPolimorfismeAmbFutbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Futbolista messi = new Futbolista(43, 1, "messi", 45, 1233);
        messi.viajar();
        messi.jugarPartido();
        messi.mostrarSalario();
        messi.jugarPartido();
        messi.mostrarSalario();

        Presidente jordi = new Presidente(44, 1, "jordi", 22, 2324);
        jordi.viajar();

    }

}
