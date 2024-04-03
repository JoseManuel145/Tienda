package models;

import java.util.Objects;
import java.util.Random;

public class Producto {
    Random random = new Random();
    String id;
    String name;
    int cantidad;
    double precio;

    public Producto() {
    }

    public Producto(String id, String name, int cantidad, double precio) {
        this.id = id;
        this.name = name;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public String generarId(){
        this.id = "";
        for (int i = 0; i<4; i++){
            this.id += String.valueOf(random.nextInt(10));
        }
        return id;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrecio() {
        return precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
