package Pojo;

public class Producto {
    private String nombre;
    private String marca;
    private int cantidad;
    private String departamento;
    private int precio;
    private String descripcion;


    public Producto(String nombre, String marca, int cantidad, String departamento, int precio, String descripcion) {
        this.nombre = nombre;
        this.marca = marca;
        this.cantidad = cantidad;
        this.departamento = departamento;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "-> " + nombre + " Marca: " + marca + " Cantidad: " + cantidad + " Departamento: " + departamento +" Precio: $" + precio ;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
