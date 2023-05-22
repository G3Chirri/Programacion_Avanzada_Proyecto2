import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String direccion;
    private String correoElectronico;
    private ArrayList<Compra> compras;

    public Cliente(String nombre, String direccion, String correoElectronico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.compras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void agregarCompra(Compra compra) {
        compras.add(compra);
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public static void agregarCliente(ArrayList<Cliente> listaClientes, Cliente clienteNuevo) {
        listaClientes.add(clienteNuevo);
    }

    public static void eliminarCliente(ArrayList<Cliente> listaClientes, Cliente clienteAEliminar) {
        listaClientes.remove(clienteAEliminar);
    }

    public static Cliente buscarClientePorNombre(ArrayList<Cliente> listaClientes, String nombreCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente
    }
}
