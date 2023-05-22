import java.util.Date;

public class Compra {
    private Date fechaCompra;
    private String cliente;
    private String obra;
    private double precio;

    public Compra(Date fechaCompra, String cliente, String obra, double precio) {
        this.fechaCompra = fechaCompra;
        this.cliente = cliente;
        this.obra = obra;
        this.precio = precio;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void registrarCompra() {
        // Lógica para registrar la compra en la galería
        System.out.println("Se ha registrado una compra:");
        System.out.println("Fecha de compra: " + fechaCompra);
        System.out.println("Cliente: " + cliente);
        System.out.println("Obra comprada: " + obra);
        System.out.println("Precio: $" + precio);
    }
}