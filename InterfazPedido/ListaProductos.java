package InterfazPedido;

import InterfazIndex.Index;
import InterfazTienda.IngresoProductos;
import Pojo.Carrito;
import Pojo.Persona;
import Pojo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaProductos extends JFrame{
    static ArrayList<Carrito> carrito = new ArrayList<>();
    private JPanel panel1;
    private JList list1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton AGREGARButton;
    private JButton MOSTRARCARRITOButton;
    private JButton REGRESARButton;
    private DefaultListModel<Producto> elementosModel;
    private Persona usuarioSeleccionado;

    public  ListaProductos(Persona usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
        initializeComponents();
        setupFrame();

        add(panel1);

        addActionListeners();


        llenarListaProductos();

    }


    void setupFrame() {
        setTitle("LISTA DE PRODUCTOS");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 500);
    }
    private void initializeComponents() {

        EventClick eventClick = new EventClick();
    }

    private void llenarListaProductos() {
        elementosModel = new DefaultListModel<>();
        ArrayList<Producto> lista = IngresoProductos.getProducto();
        for (Producto elemento : lista) {
            elementosModel.addElement(elemento);
        }
        list1.setModel(elementosModel);
    }


    private void addActionListeners() {

        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new Index().setVisible(true);
        });
        list1.addListSelectionListener(e -> {
            datos();
        });
        AGREGARButton.addActionListener(new EventClick());
        MOSTRARCARRITOButton.addActionListener(e -> {
            this.setVisible(false);
            new MostrarCarrito().setVisible(true);
        });
    }

    public void datos() {
        int indice = list1.getSelectedIndex();
        textField1.setText(IngresoProductos.getProducto().get(indice).getNombre());
        textField2.setText(IngresoProductos.getProducto().get(indice).getMarca());
        textField3.setText(String.valueOf(IngresoProductos.getProducto().get(indice).getCantidad()));
        textField4.setText(IngresoProductos.getProducto().get(indice).getDepartamento());
        textField5.setText(String.valueOf(IngresoProductos.getProducto().get(indice).getPrecio()));
        textField6.setText(IngresoProductos.getProducto().get(indice).getDepartamento());
    }

    public class EventClick implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cliente = usuarioSeleccionado.getNombre(); // Obtener el nombre del cliente desde usuarioSeleccionado
                String producto = textField1.getText();
                String marca = textField2.getText();
                int cantidad = Integer.parseInt(textField3.getText());
                String departamento = textField4.getText();
                int precio = Integer.parseInt(textField5.getText());
                String descripcion = textField6.getText();

                Carrito carritoCliente = usuarioSeleccionado.getCarrito();
                carritoCliente.setCliente(cliente); // Asignar el nombre del cliente al carrito
                carritoCliente.agregarProducto(new Producto(producto, marca, cantidad, departamento, precio, descripcion));
                clearTextFields();
            }
        }


    private void clearTextFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
    }
    public static ArrayList<Carrito> getCarrito() {
        return carrito;
    }

}
