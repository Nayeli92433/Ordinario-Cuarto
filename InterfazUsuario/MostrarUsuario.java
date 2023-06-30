package InterfazUsuario;

import Pojo.Empleado;
import Pojo.Persona;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MostrarUsuario extends JFrame {
    private JPanel panel1;
    private JList list1;
    private JList list2;
    private JButton REGRESARButton;
    private DefaultListModel<Persona> elementosModel;
    private DefaultListModel<Empleado> elementosModel2;


    public MostrarUsuario(){
        setupFrame();
        add(panel1);

        addActionListeners();


        llenarListaPersonas();
        llenarListaEmpleados();
    }

    private void setupFrame() {
        setTitle("INDEX");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(650, 500);
    }
    private void llenarListaPersonas() {
        elementosModel = new DefaultListModel<>();
        ArrayList<Persona> lista = RegistrarUsuario.getPersona();
        for (Persona elemento : lista) {
            elementosModel.addElement(elemento);
        }
        list1.setModel(elementosModel);
    }

    private void llenarListaEmpleados() {
        elementosModel2 = new DefaultListModel<>();
        ArrayList<Empleado> lista = RegistrarUsuario.getEmpleado();
        for (Empleado elemento : lista) {
            elementosModel2.addElement(elemento);
        }
        list2.setModel(elementosModel2);
    }

    private void addActionListeners() {

        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new IndexUsuario().setVisible(true);
        });
    }
}
