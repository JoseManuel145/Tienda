package models;

public class ProductoHogar extends Producto{
    String categoria;
    public ProductoHogar(String id, String name, int cantidad, double precio, String categoria) {
        super(id,name,cantidad,precio);
        this.categoria = categoria;
    }
}
