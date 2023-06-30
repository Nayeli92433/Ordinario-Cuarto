package InterfazPedido;

import InterfazIndex.Index;
import Pojo.Carrito;
import Pojo.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MostrarCarrito extends JFrame{
    private JPanel panel1;
    private JList list1;
    private JButton REGRESARButton;
    private JButton REALIZARCOMPRAButton;
    private DefaultListModel<String> elementosModel;
    public  MostrarCarrito() {

        setupFrame();

        add(panel1);

        addActionListeners();


        llenarListaPCarrito();

    }


    void setupFrame() {
        setTitle("MI CARRITO DE COMPRAS");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 500);
    }


    private void llenarListaPCarrito() {
        elementosModel = new DefaultListModel<String>();
        ArrayList<Carrito> lista = ListaProductos.getCarrito();
        for (Carrito elemento : lista) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cliente: ").append(elemento.getCliente()).append("\n");
            stringBuilder.append("Productos:\n");
            /*for (Producto producto : elemento.getProductos()) {
                stringBuilder.append("- ").append(producto.toString()).append("\n");
            }
            elementosModel.addElement(stringBuilder.toString());
        }*/
        }
        list1.setModel(elementosModel);
    }


    private void addActionListeners() {

        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new Index().setVisible(true);
        });

    }

}
