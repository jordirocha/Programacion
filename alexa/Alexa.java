package alexa;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Alexa {

    public static void main(String[] args) {

        String nombre = nombre();

        String orden;

        do {
            orden = startAlexa();

            intrucciones(orden, nombre);
        } while (!orden.startsWith("buenas noches"));

    }

    private static String nombre() {

        Scanner sc = new Scanner(System.in);

        String nombre;

        do {
            System.out.print("Introduzca nombre: ");
            nombre = sc.nextLine();
        } while (nombre.isEmpty());

        return nombre;

    }

    private static String startAlexa() {

        Scanner sc = new Scanner(System.in);

        String comando;

        do {
            System.out.print("Esperando a escucharte...\nComando: ");
            comando = sc.nextLine();

            if (!comando.toLowerCase().startsWith("alexa")) {
                System.out.println("No has iniciado con [Alexa].");
            }
        } while (!comando.toLowerCase().startsWith("alexa"));

        return comando.toLowerCase().substring(6);

    }

    private static void intrucciones(String orden, String nombre) {

        if (orden.contains("buenos dias")) {
            System.out.println("Buenos días " + nombre + ", espero que vaya bien el día.");
        } else if (orden.contains("buenas noches")) {
            System.out.println("Adiós " + nombre + ", que duermas bien.");
        } else if (orden.contains("canta una cancion")) {
            alexaCanta();
        } else if (orden.contains("habla con la")) {
            hablar(orden);
        } else if (orden.contains("tablas de multiplicar")) {
            alexaMulti();
        } else if (orden.contains("dame mi edad")) {
            alexaEdad();
        } else if (orden.contains("dame la fecha actual")) {
            alexaFecha();
        } else if (orden.contains("muestrame tus funciones")) {
            alexaFunciones();
        } else {
            System.out.println("No he podido entenderte " + nombre + ", prueba otra vez :(.");
        }

    }

    private static void alexaCanta() {

        for (int i = 2; i <= 10; i++) {
            System.out.println(i + " elefantes se balanceaban sobre la tela de una araña, como veía que resistía, fueron a llamar otro elefante.");
        }

    }

    private static void alexaMulti() {

        Scanner sc = new Scanner(System.in);

        int num1 = (int) (Math.random() * 10 + 1);
        int num2 = (int) (Math.random() * 10 + 1);

        long inicio = System.currentTimeMillis();

        System.out.print("¿Cuánto es " + num1 + " * " + num2 + "? ");
        int solucion = sc.nextInt();

        long fin = System.currentTimeMillis();

        fin -= inicio;

        if (num1 * num2 == solucion) {
            System.out.println("¡Muy bien!");
        } else {
            System.out.println("Estudia más.");
        }

        if ((fin / 1000) > 5) {
            System.out.println("Eres muy lento...");
        }

    }

    private static void hablar(String orden) {

        String frase = orden.substring(20);
        char letra = orden.charAt(13);

        frase = frase.replace('a', letra);
        frase = frase.replace('e', letra);
        frase = frase.replace('i', letra);
        frase = frase.replace('o', letra);
        frase = frase.replace('u', letra);

        System.out.println("Tu nueva frase con la " + letra + ": " + frase);

    }

    private static void alexaEdad() {

        Scanner sc = new Scanner(System.in);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        System.out.print("Dime el año de nacimiento: ");
        int anyo = sc.nextInt();

        System.out.println("Tu edad es de: " + (year - anyo) + " años.");

    }

    private static void alexaFecha() {

        Calendar fecha = new GregorianCalendar();

        Date infoDate = fecha.getTime();

        System.out.println(infoDate);

    }

    private static void alexaFunciones() {

        System.out.println("Mis funciones son las siguientes: ");
        System.out.println("""                          
                           Alexa [buenos dias] 
                           Alexa [buenas noches] 
                           Alexa [habla con la {letra} y di {frase}] 
                           Alexa [tablas de multiplicar] 
                           Alexa [dame mi edad]
                           Alexa [dame la fecha actual]
                           Alexa [muestrame tus funciones]""");

    }

}
