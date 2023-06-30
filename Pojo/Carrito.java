package Pojo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private String cliente;
    private List<Producto> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "cliente='" + cliente + '\'' +
                ", productos=" + productos +
                '}';
    }
}
