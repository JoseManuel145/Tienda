package models;
import java.util.ArrayList;

public class Inventario {
    ArrayList<Producto> productos = new ArrayList<>();

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String idDel) {
        productos.removeIf(producto -> idDel.equals(producto.getId()));
    }

    public Producto getProductoPorId(String id) {
        for (Producto producto : productos) {
            if (id.equals(producto.getId())) {
                return producto; // Devuelve el producto si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra ningún producto con ese ID
    }

    public void reducirStock(String id) {
        Producto producto = getProductoPorId(id);
        if (producto != null && producto.getCantidad() > 0) {
            producto.setCantidad(producto.getCantidad() - 1);
        }
    }

    public void aumentarStock(String id) {
        Producto producto = getProductoPorId(id);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + 1);
        }
    }
}
