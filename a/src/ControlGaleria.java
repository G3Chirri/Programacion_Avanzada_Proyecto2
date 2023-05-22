import java.util.ArrayList;
import java.util.*;

public class ControlGaleria {
    private List<Artista> artistas;  //arreglos
    private List<Cliente> clientes;
    private List<Obra> obras;
    private List<Compra> compras;



    public ControlGaleria() { //constructor
        artistas = new ArrayList<>();
        clientes = new ArrayList<>();
        obras = new ArrayList<>();
        compras = new ArrayList<>();
    }

    public void agregarArtista(Artista artista) {
        artistas.add(artista);
    }

    public void eliminarArtista(Artista artista) {
        artistas.remove(artista);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void agregarObra(Obra obra) {
        obras.add(obra);
    }

    public void eliminarObra(Obra obra) {
        obras.remove(obra);
    }

    public void registrarCompra(Compra compra) {
        compras.add(compra);
    }

    public List<Artista> getArtistasDisponibles() {
        return artistas;
    }

    public List<Obra> getObrasDisponibles() {
        return obras;
    }

    public void listarArtistas() {
        System.out.println("Lista de artistas:");
        for (Artista artista : artistas) {
            System.out.println("Nombre: " + artista.getNombre());
            System.out.println("Fecha de nacimiento: " + artista.getFechaNacimiento());
            System.out.println("Nacionalidad: " + artista.getNacionalidad());
            System.out.println("Biografía: " + artista.getBiografia());
            System.out.println("-----------------------");
        }
    }

    public void listarObras() {
        System.out.println("Lista de obras:");
        for (Obra obra : obras) {
            System.out.println("Título: " + obra.getTitulo());
            System.out.println("Técnica: " + obra.getTecnica());
            System.out.println("Año de creación: " + obra.getAnioCreacion());
            System.out.println("Precio: $" + obra.getPrecio());
            System.out.println("Artista: " + obra.getArtista().getNombre());
            System.out.println("-----------------------");
        }
    }
    public boolean buscarArtistaExistente(String nombreArtista) {
        for (Artista artista : artistas) {
            if (artista.getNombre().equalsIgnoreCase(nombreArtista)) {
                return true; // El artista ya existe
            }
        }
        return false; // El artista no existe
    }


    public boolean buscarObraExistente(String tituloObra) {
        for (Obra obra : obras) {
            if (obra.getTitulo().equalsIgnoreCase(tituloObra)) {
                return true; // La obra ya existe
            }
        }
        return false; // La obra no existe
    }




    public void mostrarComprasCliente(String nombreCliente) {
        List<Compra> comprasCliente = new ArrayList<>();

        for (Compra compra : compras) {
            if (compra.getCliente().equalsIgnoreCase(nombreCliente)) {
                comprasCliente.add(compra);
            }
        }

        if (comprasCliente.isEmpty()) {
            System.out.println("El cliente no ha realizado ninguna compra.");
        } else {
            System.out.println("Compras realizadas por el cliente " + nombreCliente + ":");
            for (Compra compra : comprasCliente) {
                System.out.println("Fecha de compra: " + compra.getFechaCompra());
                System.out.println("Obra: " + compra.getObra());
                System.out.println("Precio: " + compra.getPrecio());
                System.out.println("-----------------------------");
            }
        }
    }


    public void listarCompras() {
        System.out.println("Listado de compras realizadas:");

        for (Compra compra : compras) {
            System.out.println("Fecha de compra: " + compra.getFechaCompra());
            System.out.println("Cliente: " + compra.getCliente());
            System.out.println("Obra comprada: " + compra.getObra());
            System.out.println("Precio: $" + compra.getPrecio());
            System.out.println("-----------------------");
        }
    }
    public Artista getArtistaPorNombre(String nombreArtista) {
        for (Artista artista : artistas) {
            if (artista.getNombre().equalsIgnoreCase(nombreArtista)) {
                return artista;
            }
        }
        return null; // Si no se encuentra el artista, se devuelve null
    }

    public Obra getObraPorTituloYArtista(String titulo, Artista artista) {
        for (Obra obra : obras) {
            if (obra.getTitulo().equalsIgnoreCase(titulo) && obra.getArtista().getNombre().equalsIgnoreCase(artista.getNombre())) {
                return obra;
            }
        }
        return null;
    }




}