package InterfazUsuario;

import Pojo.Empleado;
import Pojo.Persona;
import Util.UtilCombo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RegistrarUsuario extends JFrame implements ChangeListener, ItemListener {
    static ArrayList<Persona> persona = new ArrayList<>();
    static ArrayList<Empleado> empleado = new ArrayList<>();
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton GUARDARButton;
    private JButton REGRESARButton;
    private JComboBox comboBox1;
    private JRadioButton clienteRadioButton;
    private JRadioButton empleadoRadioButton;
    private ButtonGroup boton;

    public RegistrarUsuario() {

        initializeComponents();
        setupFrame();
        add(panel1);
        addActionListeners();

        boton = new ButtonGroup();
        boton.add(clienteRadioButton);
        boton.add(empleadoRadioButton);

        clienteRadioButton.addChangeListener(this);
        empleadoRadioButton.addChangeListener(this);

        comboBox1.addItemListener(this);
    }

    private void initializeComponents() {
        EventClick eventClick = new EventClick();
        ArrayList<String> tiposCargo = UtilCombo.tipoCargo();
        for (String tipo : tiposCargo) {
            comboBox1.addItem(tipo);
        }

        textField8 = new JTextField();
    }

    private void setupFrame() {
        setTitle("REGISTRO DE USUARIO");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 400);
    }

    private void addActionListeners() {
        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new IndexUsuario().setVisible(true);
        });
        GUARDARButton.addActionListener(new EventClick());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (clienteRadioButton.isSelected()) {
            textField7.setEditable(false);
            textField9.setEditable(false);
            comboBox1.setEditable(false);

        }
        if (empleadoRadioButton.isSelected()) {
            textField7.setEditable(true);
            textField9.setEditable(true);

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboBox1) {
            String item2 = (String) comboBox1.getSelectedItem();
            textField8.setText(item2);
        }
    }

    public class EventClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = textField1.getText();
            String apellidoP = textField2.getText();
            String apellidoM = textField3.getText();
            int edad = parseTextFieldToInt(textField4);
            String direccion = textField5.getText();
            int telefono = parseTextFieldToInt(textField6);

            if (edad == -1 || telefono == -1) {
                JOptionPane.showMessageDialog(null, "Edad y teléfono deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (clienteRadioButton.isSelected()) {
                persona.add(new Persona(nombre, apellidoP, apellidoM, edad, direccion, telefono));
                clearTextFields();
                JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else if (empleadoRadioButton.isSelected()) {
                int numEmpleado = parseTextFieldToInt(textField7);
                String tipo = textField8.getText();
                String descanso = textField9.getText();

                if (numEmpleado == -1) {
                    JOptionPane.showMessageDialog(null, "Número de empleado debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                empleado.add(new Empleado(nombre, apellidoP, apellidoM, edad, direccion, telefono, numEmpleado, tipo, descanso));
                clearTextFields();
                JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona una opción: Cliente o Empleado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private int parseTextFieldToInt(JTextField textField) {
            try {
                return Integer.parseInt(textField.getText());
            } catch (NumberFormatException e) {
                return -1; // Retorna -1 si la conversión falla
            }
        }


        }



    private void clearTextFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        textField8.setText("");
        textField9.setText("");
    }

    public static ArrayList<Persona> getPersona() {
        return persona;
    }

    public static ArrayList<Empleado> getEmpleado() {
        return empleado;
    }

}
