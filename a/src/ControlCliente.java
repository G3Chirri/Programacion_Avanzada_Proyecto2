import java.util.ArrayList;
import java.util.List;

public class ControlCliente {
    private List<Cliente> clientes;

    public ControlCliente() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void listarComprasCliente(Cliente cliente) {
        System.out.println("Compras realizadas por el cliente " + cliente.getNombre() + ":");
        /*for (Compra compra : cliente.get)) {
            System.out.println("Fecha de compra: " + compra.getFechaCompra());
            System.out.println("Obra comprada: " + compra.getObra().getTitulo());
            System.out.println("Precio: $" + compra.getPrecio());
            System.out.println("-----------------------");
        }*/
    }
    public Cliente buscarClientePorNombre(String nombreCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente, se devuelve null
    }
    public void registrarCompra(Cliente cliente, Compra compra) {
        cliente.agregarCompra(compra);
    }

}
