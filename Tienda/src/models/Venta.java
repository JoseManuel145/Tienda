package models;

import java.util.ArrayList;

public class Venta {
    Inventario inventario;
    double total;
    ArrayList<Producto> productosVender = new ArrayList<>();

    public Venta(Inventario inventario) {
        this.inventario = inventario;
    }

    public void agregarProducto(String id) {
        Producto productoEnInventario = inventario.getProductoPorId(id);
        if (productoEnInventario != null && productoEnInventario.getCantidad() > 0) {
            productosVender.add(productoEnInventario);
            inventario.reducirStock(id);
        }
    }

    public void eliminarProducto(String idDel) {
        productosVender.removeIf(producto -> idDel.equals(producto.getId()));
        inventario.aumentarStock(idDel);
    }

    public double calcularTotal() {
        total = 0;
        for (Producto producto : productosVender) {
            total += producto.getPrecio();
        }
        return total;
    }

    public Ticket finalizarVenta() {
        Ticket ticket = new Ticket();
        ticket.setProductosVendidos(new ArrayList<>(productosVender));
        productosVender.clear();
        return ticket;
    }
}
