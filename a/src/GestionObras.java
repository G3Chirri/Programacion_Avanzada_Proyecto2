import java.util.ArrayList;
import java.util.List;

public class GestionObras {
    private List<Obra> obras;
    private List<Artista> artistas;

    public GestionObras() {
        obras = new ArrayList<>();
        artistas = new ArrayList<>();
    }

    public void agregarObra(Obra obra) {
        obras.add(obra);
    }

    public void eliminarObra(Obra obra) {
        obras.remove(obra);
    }

    public void agregarArtista(Artista artista) {
        artistas.add(artista);
    }

    public void eliminarArtista(Artista artista) {
        artistas.remove(artista);
    }

    public List<Obra> getObrasDisponibles() {
        return obras;
    }

    public List<Artista> getArtistasDisponibles() {
        return artistas;
    }

    public void listarObras() {
        System.out.println("Obras disponibles:");
        for (Obra obra : obras) {
            System.out.println("Título: " + obra.getTitulo());
            System.out.println("Técnica: " + obra.getTecnica());
            System.out.println("Año de creación: " + obra.getAnioCreacion());
            System.out.println("Precio: " + obra.getPrecio());
            System.out.println("Artista: " + obra.getArtista().getNombre());
            System.out.println("-----------------------");
        }
    }
    public Artista buscarArtistaPorNombre(String nombre) {
        for (Artista artista : artistas) {
            if (artista.getNombre().equalsIgnoreCase(nombre)) {
                return artista;
            }
        }
        return null;
    }

    public Obra buscarObraPorTitulo(String titulo) {
        for (Obra obra : obras) {
            if (obra.getTitulo().equalsIgnoreCase(titulo)) {
                return obra;
            }
        }
        return null;
    }

    


}
