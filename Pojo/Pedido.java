package Pojo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private List<Carrito> pedido;

    // Constructor y métodos de la clase Carrito

    // Constructor
    public Pedido() {
        this.pedido = new ArrayList<>();
    }

    // Método para agregar un producto al carrito
    public void agregarPedido(Carrito carrito) {
        pedido.add(carrito);
    }
}
