/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicizoo;

/**
 *
 * @author jordy
 */
public class AppEjemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Zoologico[] zoos = new Zoologico[2];
        
        zoos[0] = new Zoologico();
        zoos[1] = new Zoologico();
        
        zoos[0].delfines = new Delfin[3];
        zoos[0].jirafas = new Jirafa[2];
        zoos[0].leones = new Leon[4];

        zoos[1].delfines = new Delfin[3];
        zoos[1].jirafas = new Jirafa[2];
        zoos[1].leones = new Leon[4];

    }

}
