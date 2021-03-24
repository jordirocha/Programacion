package poo;

public class POO {

    public static void main(String[] args) {

        Autos coche = new Autos(20); // Uno ya construido, matricula
        Autos moto = new Autos(3434, 90); // Otro de tipo moto, matricula y peso

        coche.setColor("Rojo");
        moto.setColor("Negro");

        System.out.println("Matricula: " + coche.getMatricula()
                + " Marca del vehiculo: " + coche.getMarcaAuto()
                + " Tipo de vehiculo: " + coche.getTipo()
                + " Ruedas: " + coche.getPuertas()
                + " Puertas: " + coche.getRuedas()
                + " Peso: " + coche.getPeso() + " KG"
                + " Color: " + coche.getColor());

        System.out.println("Matricula: " + moto.getMatricula()
                + " Marca del vehiculo: " + moto.getMarcaAuto()
                + " Tipo de vehiculo: " + moto.getTipo()
                + " Ruedas: " + moto.getRuedas()
                + " Peso: " + moto.getPeso() + " KG"
                + " Color: " + moto.getColor());

    }

}
