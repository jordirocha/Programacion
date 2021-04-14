package practicagestordecançons;

public class cancion {

    private String titulo;
    private String interprete;
    private String album;
    private double duracion;

    public cancion() { // Sin informar nada de entrada(donde se informará todos los strings a blanco
        this.titulo = "";
        this.interprete = "";
        this.album = "";
    }

    public cancion(String titulo, String interprete) { // Informando el nombre y el autor
        this.titulo = titulo;
        this.interprete = interprete;
    }

    public cancion(String titulo, String interprete, String album, double duracion) { // informando todos sus valores 
        this.titulo = titulo;
        this.interprete = interprete;
        this.album = album;
        this.duracion = duracion;
    }

    public void setTitulo(String titulo) { // Se tiene que cumplir el principio de encapsulación con los métodos de acceso para los atributos.
        this.titulo = titulo;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getInterprete() {
        return interprete;
    }

    public String getAlbum() {
        return album;
    }

    public double getDuracion() {
        return duracion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final cancion other = (cancion) obj;
        return this.titulo.equalsIgnoreCase(other.titulo) && this.interprete.equalsIgnoreCase(other.interprete);
    }

    @Override
    public String toString() {
        return " Interprete: " + interprete + ", titulo: " + titulo + ", duracion: " + duracion + "\n";
    }

}
