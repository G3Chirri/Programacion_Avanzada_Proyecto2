import java.util.ArrayList;
import java.util.*;

public class Artista {
    private String nombre;
    private String fechaNacimiento;
    private String nacionalidad;
    private String biografia;
    private Boolean eliminado;

    public Artista (String nombre , String fechaNacimiento , String nacionalidad , String biografia , Boolean eliminado){
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.biografia = biografia;
        this.eliminado = eliminado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getBiografia() {
        return biografia;
    }



    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    //Metodos
    public void agregarArtista(ArrayList<Artista> artistas, Artista artista) {
        artistas.add(artista);
    }
    public void eliminarArtista(ArrayList<Artista> artistas, Artista artista) {
        artistas.remove(artista);
    }

    public void mostrarArtistas(ArrayList<Artista> artistas) {
        System.out.println("Lista de artistas:");

        for (Artista artista : artistas) {
            System.out.println("Nombre: " + artista.getNombre());
            System.out.println("Fecha de nacimiento: " + artista.getFechaNacimiento());
            System.out.println("Nacionalidad: " + artista.getNacionalidad());
            System.out.println("Biografía: " + artista.getBiografia());
            System.out.println("-----------------------");
        }
    }



}


