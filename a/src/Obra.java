import java.util.ArrayList;

public class Obra {
    private String titulo;
    private String tecnica;
    private int anioCreacion;
    private double precio;
    private boolean vendida;
    private Artista artista;

    public Obra(String titulo, String tecnica, int anioCreacion, double precio, boolean vendida, Artista artista) {
        this.titulo = titulo;
        this.tecnica = tecnica;
        this.anioCreacion = anioCreacion;
        this.precio = precio;
        this.vendida = vendida;
        this.artista = artista;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isVendida() {
        return vendida;
    }

    public void setVendida(boolean vendida) {
        this.vendida = vendida;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public static void agregarObra(ArrayList<Obra> obras, Obra obra) {
        obras.add(obra);
    }

    public static void eliminarObra(ArrayList<Obra> obras, Obra obra) {
        obras.remove(obra);
    }

    public static void mostrarObras(ArrayList<Obra> obras) {
        System.out.println("Obras en la galería:");
        for (Obra obra : obras) {
            System.out.println("Título: " + obra.getTitulo());
            System.out.println("Técnica: " + obra.getTecnica());
            System.out.println("Año de creación: " + obra.getAnioCreacion());
            System.out.println("Precio: " + obra.getPrecio());
            System.out.println("Artista: " + obra.getArtista().getNombre());
            System.out.println();
        }
    }
}
