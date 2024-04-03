package models;

public class ProductoComestible extends Producto{
    String fechaCaducidad;

    public ProductoComestible(String id, String name, int cantidad, double precio, String fechaCaducidad) {
        super(id,name,cantidad,precio);
        this.fechaCaducidad = fechaCaducidad;
    }
}