import models.*;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Inventario inventario = new Inventario();
        Venta venta = new Venta(inventario);
        Scanner scan = new Scanner(System.in);
        boolean tiendaAbierta = true;
        String opcionTienda;
        String opcionInventario;
        String opcionVenta;
        String opcionTicket;
        do {
            opciones();
            opcionTienda = scan.nextLine();
            switch (opcionTienda){
                case "1":
                    boolean inventarioAbierto = true;
                    do {
                        System.out.println("-----Menu Inventario-----");
                        inventario();
                        opcionInventario = scan.nextLine();
                        switch (opcionInventario) {
                            case "1":
                                System.out.println("Agregar producto");
                                System.out.println("1. Producto comestible\n2. Producto del hogar\n3. Salir");
                                opcionTienda = scan.nextLine();
                                if (!opcionTienda.equals("3")) {
                                    agregarProducto(inventario, opcionTienda);
                                } else {
                                    System.out.println("Saliendo...");
                                }
                                break;
                            case "2":
                                System.out.println("Eliminar producto");
                                System.out.print("Ingresa el id del producto a eliminar: ");
                                String idDel = scan.nextLine();
                                eliminarProducto(inventario, idDel);
                                scan.nextLine();
                                break;
                            case "3":
                                System.out.println("Imprimir productos.");
                                for (Producto i:inventario.getProductos()){
                                    System.out.println(i.toString());
                                }

                                break;
                            case "4":
                                System.out.println("Saliendo del inventario... \n");
                                inventarioAbierto = false;
                                break;
                            default:
                                System.out.println("Ingrese una opcion valida porfavor.");
                        }
                    }while (inventarioAbierto);
                    break;
                case "2":
                    boolean ventaAbierto = true;
                    do {
                        System.out.println("-----Menu Venta-----");
                        venta();
                        opcionVenta = scan.nextLine();
                        switch (opcionVenta) {
                            case "1":
                                System.out.println("Agrega un producto a vender.");
                                System.out.println("Ingresa el id del producto:");
                                String idAdd = scan.nextLine();
                                venta.agregarProducto(idAdd);
                                break;
                            case "2":
                                System.out.println("Elimina el producto a vender.");
                                System.out.println("Ingresa el id del producto:");
                                String idDel = scan.nextLine();
                                venta.eliminarProducto(idDel);
                                break;
                            case "3":
                                System.out.println("Vende los productos que tienes.");
                                double total = venta.calcularTotal();
                                System.out.println("El total es: $" + total);
                                System.out.println("Dinero: ");
                                double dinero = scan.nextDouble();
                                double cambio = dinero - total;
                                System.out.println("Su cambio es: $" + cambio);
                                Ticket ticketNuevo = venta.finalizarVenta();
                                tickets.add(ticketNuevo);
                                scan.nextLine();
                                break;
                            case "4":
                                System.out.println("Saliendo de venta... \n");
                                ventaAbierto = false;
                                break;
                            default:
                                System.out.println("Ingrese una opcion valida porfavor.");
                        }
                    }while (ventaAbierto);
                    break;
                case "3":
                    gestionarTickets();
                    break;
                case "4":
                    System.out.println("Cerrando la tienda...");
                    tiendaAbierta = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida porfavor.");
            }
        }while (tiendaAbierta);
    }

    public static void opciones(){
        System.out.println("------BIENVENIDO-----");
        System.out.println("Que desea hacer?\n");
        System.out.println("|1| Inventario.");
        System.out.println("|2| Venta.");
        System.out.println("|3| Tickets.");
        System.out.println("|4| Cerrar la tienda");
    }
    public static void inventario(){
        System.out.println("|1| Agregar producto.");
        System.out.println("|2| Eliminar producto.");
        System.out.println("|3| Imprimir productos.");
        System.out.println("|4| Volver al menu principal");
    }
    public static void venta(){
        System.out.println("|1| Agregar producto.");
        System.out.println("|2| Eliminar producto.");
        System.out.println("|3| Hacer venta.");
        System.out.println("|4| Volver al menu principal.");
    }
    public static void ticket(){
        System.out.println("|1| Mostrar los tickets.");
        System.out.println("|2| Buscar ticket especifico.");
        System.out.println("|3| Volver al menu principal.");
    }
    public static void agregarProducto(Inventario inventario,String opcionTienda) {
        Scanner scan = new Scanner(System.in);
        Producto producto = new Producto();
        String id = producto.generarId();
        System.out.print("Ingresa el nombre: ");
        String name = scan.nextLine();
        System.out.print("Ingresa la cantidad: ");
        int cantidad = scan.nextInt();
        scan.nextLine();
        System.out.print("Ingresa su precio: ");
        double precio = scan.nextDouble();
        scan.nextLine();

        switch (opcionTienda) {
            case "1":
                System.out.print("Ingrese la fecha de caducidad (dd/mm/aa): ");
                String caducidad = scan.nextLine();
                ProductoComestible productoComestible = new ProductoComestible(id, name, cantidad, precio, caducidad);
                inventario.agregarProducto(productoComestible);
                break;
            case "2":
                System.out.print("Ingrese su categoria: ");
                String categoria = scan.nextLine();
                ProductoHogar productoHogar = new ProductoHogar(id, name, cantidad, precio, categoria);
                inventario.agregarProducto(productoHogar);
                break;
        }
        System.out.println("Producto agregado: " + producto.getId());
    }
    public static void eliminarProducto(Inventario inventario,String idDel){
        inventario.eliminarProducto(idDel);
    }
    private static void gestionarTickets() {
        Scanner scan = new Scanner(System.in);
        String opcionTicket;
        boolean ticketAbierto = true;
        do {
            ticket();
            opcionTicket = scan.nextLine();
            switch (opcionTicket) {
                case "1":
                    if (tickets.isEmpty()) {
                        System.out.println("No hay tickets disponibles.");
                    } else {
                        System.out.println("----- Lista de Tickets -----");
                        for (Ticket ticket : tickets) {
                            ticket.imprimirTicket();
                            System.out.println("---------------------------");
                        }
                    }
                    break;
                case "2":
                    System.out.print("Ingrese el ID del ticket: ");
                    int idBuscado = scan.nextInt();
                    boolean encontrado = false;

                    for (Ticket ticket : tickets) {
                        if (ticket.getId() == idBuscado) {
                            ticket.imprimirTicketConPrecio();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró un ticket con el ID especificado.");
                    }
                    scan.nextLine();
                    break;
                    case "3":
                        System.out.println("Saliendo de Tickets... \n");
                        ticketAbierto = false;
                    break;
                    default:
                        System.out.println("Ingrese una opcion valida porfavor.");
            }
        } while (ticketAbierto);
    }
}