package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ticket {
    private static int nextId = 0;
    private int id;
    private ArrayList<Producto> productosVendidos;
    private LocalDateTime fechaCreacion;

    public Ticket() {
        this.id = ++nextId;
        this.productosVendidos = new ArrayList<>();
        this.fechaCreacion = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setProductosVendidos(ArrayList<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public void imprimirTicket() {
        System.out.println("Título: Ticket de Venta");
        System.out.println("ID del Ticket: " + id);
        System.out.println("Productos Vendidos:");
        for (Producto producto : productosVendidos) {
            System.out.println("- " + producto.getName());
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("Fecha de Creación: " + dtf.format(fechaCreacion)); // Se utiliza la fecha de creación del ticket
    }
    public void imprimirTicketConPrecio() {
        System.out.println("Título: Ticket de Venta");
        System.out.println("ID del Ticket: " + id);
        System.out.println("Productos Vendidos:");
        for (Producto producto : productosVendidos) {
            System.out.println("- " + producto.getName() + " - Precio: $" + producto.getPrecio());
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("Fecha de creación: " +  dtf.format(fechaCreacion));
    }
}
