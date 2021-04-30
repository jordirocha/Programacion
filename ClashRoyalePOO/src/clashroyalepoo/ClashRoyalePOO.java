/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clashroyalepoo;

import java.util.Scanner;

/**
 *
 * @author Alan Jordi Rocha Roc
 */
public class ClashRoyalePOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcion;

        do {
            opcion = menu();
            System.out.println("");
            switch (opcion) {
                case 1:
                    CofreArgent argent = new CofreArgent();
                    argent.obrirCofre();
                    argent.mostrarCofre();
                    break;
                case 2:
                    CofreOR or = new CofreOR();
                    or.obrirCofre();
                    or.mostrarCofre();
                    break;
                case 3:
                    CofreORCorones cor = new CofreORCorones();
                    cor.obrirCofre();
                    cor.mostrarCofre();
                    break;
                case 4:
                    CofreLighting l = new CofreLighting();
                    l.obrirCofre();
                    l.mostrarCofre();
                    break;
                case 5:
                    CofreLegendario g = new CofreLegendario();
                    g.obrirCofre();
                    g.mostrarCofre();
                    break;
                case 6:
                    System.out.println("Saliendo Clash Royale");
                    break;
                default:
                    System.out.println("Error.");
            }
            System.out.println("");
        } while (opcion != 6);

    }

    private static int menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1- Cofre d’argent\n"
                    + "2- Cofre d’or\n"
                    + "3- Cofre d’or de corones \n"
                    + "4- Cofre Mega Lighting\n"
                    + "5- Cofre Legendari\n"
                    + "6- Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
        } while (opcion < 1 || opcion > 6);
        return opcion;
    }

}
