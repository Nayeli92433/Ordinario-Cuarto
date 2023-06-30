package InterfazTienda;


import Pojo.Producto;
import Util.UtilCombo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class IngresoProductos extends JFrame implements ItemListener {
    static ArrayList<Producto> producto = new ArrayList<>();
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton GUARDARButton;
    private JButton MOSTRARButton;
    private JButton REGRESARButton;
    private JComboBox comboBox1;

    public IngresoProductos(){
        initializeComponents();
        setupFrame();
        add(panel1);
        addActionListeners();

        addActionListeners();

        comboBox1.addItemListener(this);
    }

    private void initializeComponents() {

        EventClick eventClick = new EventClick();
        ArrayList<String> tiposDep = UtilCombo.tipoDepartamento();
        for (String tipo : tiposDep) {
            comboBox1.addItem(tipo);
        }

        textField6 = new JTextField();
    }

    private void setupFrame() {
        setTitle("INGRESAR PRODUCTOS");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 400);
    }


    private void addActionListeners() {
        GUARDARButton.addActionListener(new EventClick());
        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new IndexTienda().setVisible(true);
        });
        MOSTRARButton.addActionListener(e -> {
            this.setVisible(false);
            new OperacionProductos().setVisible(true);
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboBox1) {
            String item2 = (String) comboBox1.getSelectedItem();
            textField6.setText(item2);
        }

    }
    public class EventClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = textField1.getText();
            String marca = textField2.getText();
            int cantidad = Integer.parseInt(textField3.getText());
            String departamento = textField6.getText();
            int precio = Integer.parseInt(textField4.getText());
            String descripcion = textField5.getText();



            producto.add(new Producto(nombre, marca, cantidad, departamento, precio, descripcion));
            clearTextFields();
        }
    }

    private void clearTextFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
    }
    public static ArrayList<Producto> getProducto() {
        return producto;
    }
    public static void eliminarProducto(Producto producto) {
        if (producto != null) {
            IngresoProductos.producto.remove(producto);
        }
    }
}
