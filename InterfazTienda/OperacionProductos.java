package InterfazTienda;

import InterfazUsuario.IndexUsuario;
import InterfazUsuario.RegistrarUsuario;
import Pojo.Empleado;
import Pojo.Persona;
import Pojo.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OperacionProductos extends JFrame{
    private JPanel panel1;
    private JList list1;
    private JButton ELIMINARButton;
    private JButton EDITARButton;
    private JButton REGRESARButton;
    private DefaultListModel<Producto> elementosModel;
    public OperacionProductos(){
        setupFrame();
        add(panel1);

        addActionListeners();


        llenarListaProducto();
    }

    private void setupFrame() {
        setTitle("OPERACIONES DE LOS PRODUCTOS");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(600, 500);
    }
    private void llenarListaProducto() {
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
            new IndexTienda().setVisible(true);
        });
        ELIMINARButton.addActionListener(e -> {
            int indiceSeleccionado = list1.getSelectedIndex();
            if (indiceSeleccionado != -1) {
                Producto productoSeleccionado = elementosModel.getElementAt(indiceSeleccionado);
                elementosModel.removeElementAt(indiceSeleccionado);
                IngresoProductos.eliminarProducto(productoSeleccionado);
            }
        });
        EDITARButton.addActionListener(e -> {
            int indiceSeleccionado = list1.getSelectedIndex();
            if (indiceSeleccionado != -1) {
                Producto productoSeleccionado = elementosModel.getElementAt(indiceSeleccionado);
                Producto productoEditado = mostrarFormularioEdicion(productoSeleccionado);
                if (productoEditado != null) {
                    elementosModel.setElementAt(productoEditado, indiceSeleccionado);
                }
            }
        });
    }

    private Producto mostrarFormularioEdicion(Producto producto) {
        JTextField nombre= new JTextField(producto.getNombre());
        JTextField marca= new JTextField(producto.getMarca());
        JTextField departamento = new JTextField(producto.getDepartamento());
        JTextField descripcion = new JTextField(producto.getDescripcion());
        JTextField cantidad= new JTextField(producto.getCantidad());
        JTextField precio = new JTextField(producto.getPrecio());
        // Añadir más campos de texto para los demás atributos del producto

        Object[] fields = {
                "Cantidad:", cantidad,
                "Precio:", precio,
                // Añadir más etiquetas y campos de texto para los demás atributos del producto
        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Editar producto", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int nuevaCantidad = Integer.parseInt(cantidad.getText());
            int nuevoPrecio = Integer.parseInt(precio.getText());
            // Obtener los valores actualizados de los demás atributos del producto

            // Crear un nuevo objeto Producto con la información actualizada
            Producto productoEditado = new Producto(nombre.getText(), marca.getText(), nuevaCantidad, departamento.getText(), nuevoPrecio, descripcion.getText());;

            return productoEditado;
        }

        return null;
    }
}
