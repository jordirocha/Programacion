package amigospoo;

public class Persona {

    private String nombre;
    private int edad;
    private int dni;
    private char sexo;
    private double peso;
    private double altura;

    public Persona(String nombre) { // La uso para Constains en el 3 y 4 
        this.nombre = nombre;
    }

    public Persona() {
        this.dni = generarDNI();
        this.sexo = 'H';
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        setEdad(edad);
        this.dni = generarDNI();
        this.sexo = comprobarSexo(sexo);
        setPeso(peso);
        setAltura(altura);
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            this.edad = 0;
        }
    }

    public void setSexo(char sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        } else {
            this.peso = 0;
        }
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            this.altura = 0;
        }
    }

    private char comprobarSexo(char sexo) { // Método para comprobar que el sexo es correcto
        if (sexo == 'M' || sexo == 'H') {
            return sexo;
        }
        return 'H';
    }

    private int generarDNI() {
        return (int) (Math.random() * (10000000 - 99999999) + 10000000);
    }

    @Override
    public boolean equals(Object obj) { // Mi método equalsIgnoreCas,e comprueba si los nomnbres son iguales 
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return this.nombre.equalsIgnoreCase(other.nombre);
    }

    @Override
    public String toString() { // Método que muestra los datos de nuestros amigos
        return "Datos de la persona " + "nombre: " + nombre + ", dni: " + dni + ", edad: " + edad + ", sexo: " + sexo;
    }

}
