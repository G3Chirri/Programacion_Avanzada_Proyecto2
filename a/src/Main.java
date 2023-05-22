import java.time.Instant;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        ControlGaleria controlGaleria = new ControlGaleria();
        ControlCliente controlCliente = new ControlCliente();

        System.out.println();
        do {
            System.out.println("_____ MENÚ -______");
            System.out.println("| 1. Agregar Artista               |");
            System.out.println("| 2. Eliminar Artista              |");
            System.out.println("| 3. Agregar Obra                  |");
            System.out.println("| 4. Eliminar Obra                 |");
            System.out.println("| 5. Lista Obras                   |");
            System.out.println("| 6. Lista Artistas                |");
            System.out.println("| 7. Agregar Cliente               |");
            System.out.println("| 8. Eliminar Cliente              |");
            System.out.println("| 9. Realizar Compra               |");
            System.out.println("| 10. Mostrar compras por cliente  |");
            System.out.println("| 11. Lista de compras             |");
            System.out.println("| 12. Salir:                       |");
            System.out.println("|____________|");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    AgregarArtista(scanner, controlGaleria);
                    break;
                case 2:
                    EliminarArtista(scanner, controlGaleria);
                    break;
                case 3:
                    AgregarObra(scanner, controlGaleria);
                    break;
                case 4:
                    EliminarObra(scanner, controlGaleria);
                    break;
                case 5:
                    controlGaleria.listarObras();
                    break;
                case 6:
                    controlGaleria.listarArtistas();
                    break;
                case 7:
                    agregarCliente(scanner, controlCliente,controlGaleria);
                    break;
                case 8:
                    eliminarCliente(scanner, controlCliente);
                    break;
                case 9:
                    //realizar compra

                    comprarObra(scanner, controlGaleria);
                    break;
                case 10:

                    MostrarCompras( scanner, controlCliente,  controlGaleria);
                    break;
                case 11:
                    controlGaleria.listarCompras();
                    break;
                case 12:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 12);

        scanner.close();
    }


    //Metodos
    public static void AgregarArtista(Scanner scanner, ControlGaleria controlGaleria) {
        System.out.println("Ingrese el nombre del artista:");
        String nombreArtista = scanner.next();

        if (controlGaleria.buscarArtistaExistente(nombreArtista)) {
            System.out.println("El nombre del artista ya está en uso.");
        } else {
            // Limpiar el búfer de entrada
            scanner.nextLine();

            System.out.println("Ingrese la fecha de nacimiento del artista:");
            String fechaNacimiento = scanner.nextLine();
            System.out.println("Ingrese la nacionalidad del artista:");
            String nacionalidad = scanner.nextLine();
            System.out.println("Ingrese la biografía del artista:");
            String biografia = scanner.nextLine();

            // Crear una instancia de Artista con los datos ingresados
            Artista nuevoArtista = new Artista(nombreArtista, fechaNacimiento, nacionalidad, biografia, false);

            // Agregar el nuevo artista a la lista de artistas
            controlGaleria.agregarArtista(nuevoArtista);

            System.out.println("El artista ha sido agregado exitosamente.");
        }
    }
    public static void EliminarObra(Scanner scanner, ControlGaleria controlGaleria) {
        System.out.println("Ingrese el nombre del artista:");
        String nombreArtista = scanner.next();

        Artista artista = controlGaleria.getArtistaPorNombre(nombreArtista);
        if (artista != null) {
            System.out.println("Ingrese el título de la obra a eliminar:");
            String tituloObra = scanner.next();

            Obra obra = controlGaleria.getObraPorTituloYArtista(tituloObra, artista);
            if (obra != null) {
                controlGaleria.eliminarObra(obra);
                System.out.println("La obra ha sido eliminada exitosamente.");
            } else {
                System.out.println("No se encontró una obra con ese título para el artista especificado.");
            }
        } else {
            System.out.println("No se encontró un artista con ese nombre.");
        }
    }


    public static void EliminarArtista(Scanner scanner, ControlGaleria controlGaleria) {
        System.out.println("Ingrese el nombre del artista que desea eliminar:");
        String nombreArtistaEliminar = scanner.next();

        // Limpiar el búfer de entrada
        scanner.nextLine();

        if (controlGaleria.buscarArtistaExistente(nombreArtistaEliminar)) {
            Artista artista = controlGaleria.getArtistaPorNombre(nombreArtistaEliminar);
            controlGaleria.eliminarArtista(artista);
            System.out.println("El artista ha sido eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un artista con ese nombre.");
        }
    }



    public static void AgregarObra(Scanner scanner, ControlGaleria controlGaleria) {
        System.out.println("Ingrese el nombre del artista:");
        String nombreArtista = scanner.next();

        Artista artista = controlGaleria.getArtistaPorNombre(nombreArtista);
        if (artista != null) {
            System.out.println("Ingrese el título de la obra:");
            String tituloObra = scanner.next();

            System.out.println("Ingrese la técnica de la obra:");
            String tecnicaObra = scanner.next();

            System.out.println("Ingrese el año de creación de la obra:");
            int anioCreacion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el búfer

            System.out.println("Ingrese el precio de la obra:");
            double precioObra = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el búfer

            Obra obra = new Obra(tituloObra, tecnicaObra, anioCreacion, precioObra,false, artista);
            controlGaleria.agregarObra(obra);

            System.out.println("La obra ha sido agregada exitosamente.");
        } else {
            System.out.println("No se encontró un artista con ese nombre.");
        }
    }



    public static void comprarObra(Scanner scanner, ControlGaleria controlGaleria) {
        System.out.println("Ingrese el nombre del artista:");
        String nombreArtista = scanner.next();

        System.out.println("Ingrese el nombre de la obra:");
        String nombreObra = scanner.next();

        Artista artista = controlGaleria.getArtistaPorNombre(nombreArtista);
        if (artista != null) {
            Obra obra = controlGaleria.getObraPorTituloYArtista(nombreObra, artista);
            if (obra != null) {
                System.out.println("Ingrese nombre del cliente:");
                String nombreCliente = scanner.next();


                System.out.println("Ingrese el monto de dinero disponible:");
                double montoDinero = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el búfer

                double precioObra = obra.getPrecio();
                if (montoDinero >= precioObra) {
                    double cambio = montoDinero - precioObra;
                    System.out.println("La obra ha sido comprada exitosamente.");
                    System.out.println("Cambio: $" + cambio);

                    Date fecha = Date.from(Instant.now());
                    Compra compra= new Compra(fecha,nombreCliente,nombreObra,precioObra);
                    controlGaleria.registrarCompra(compra);
                    Artista artista1 = controlGaleria.getArtistaPorNombre(nombreArtista);
                    Obra obra1 = controlGaleria.getObraPorTituloYArtista(nombreObra, artista1);
                    controlGaleria.eliminarObra(obra1);

                } else {
                    System.out.println("No tiene suficiente dinero para comprar la obra.");
                }
            } else {
                System.out.println("El artista no tiene una obra con ese nombre.");
            }
        } else {
            System.out.println("No se encontró un artista con ese nombre.");
        }
    }

    public static void agregarCliente(Scanner scanner, ControlCliente controlCliente, ControlGaleria controlGaleria) {
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.next();

        Cliente clienteExistente = controlCliente.buscarClientePorNombre(nombreCliente);
        if (clienteExistente != null) {
            System.out.println("El cliente ya existe.");
        } else {
            System.out.println("Ingrese la dirección del cliente:");
            String direccionCliente = scanner.next();

            System.out.println("Ingrese el correo del cliente:");
            String correo = scanner.next();

            Cliente nuevoCliente = new Cliente(nombreCliente, direccionCliente, correo);
            controlCliente.agregarCliente(nuevoCliente);
            controlGaleria.agregarCliente(nuevoCliente);
            System.out.println("El cliente ha sido creado y agregado exitosamente.");
        }
    }

    public static void eliminarCliente(Scanner scanner, ControlCliente controlCliente) {
        System.out.println("Ingrese el nombre del cliente que desea eliminar:");
        String nombreCliente = scanner.next();

        Cliente clienteExistente = controlCliente.buscarClientePorNombre(nombreCliente);
        if (clienteExistente != null) {
            controlCliente.eliminarCliente(clienteExistente);
            System.out.println("El cliente ha sido eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un cliente con ese nombre.");
        }
    }

    public static void MostrarCompras(Scanner scanner, ControlCliente controlCliente, ControlGaleria controlGaleria){
        System.out.println("Ingrese el nombre del cliente");
        String nombreCliente = scanner.next();


        controlGaleria.mostrarComprasCliente(nombreCliente);
    }

}