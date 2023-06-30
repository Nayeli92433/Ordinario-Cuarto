package InterfazPedido;

import InterfazIndex.Index;
import InterfazUsuario.IndexUsuario;
import InterfazUsuario.RegistrarUsuario;
import Pojo.Empleado;
import Pojo.Persona;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListaUsuarios extends JFrame{
    private JPanel panel1, panelCanvas, panelImagen, panelContainer;
    private JList list1;
    private JButton REGRESARButton;
    private JButton SELECCIONARButton;
    private Persona usuarioSeleccionado;
    private DefaultListModel<Persona> elementosModel;
    public ListaUsuarios(){
        initializeComponents();
        setupFrame();
        setupPanelContainer();
        add(panelContainer);

        addActionListeners();


        llenarListaPersonas();
    }

    private void setupFrame() {
        setTitle("LISTA DE USUARIOS");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }
    private void initializeComponents() {
        panelCanvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imagen = new ImageIcon("C:\\Users\\Nayeli Velasco\\IdeaProjects\\Ordinario\\src\\Imagen\\grupos.png");
                Image img = imagen.getImage();
                g.drawImage(img, 35, 23, null);
            }
        };

        panelImagen = new JPanel();
        panelContainer = new JPanel();
        panelImagen = new JPanel();
    }
    private void llenarListaPersonas() {
        elementosModel = new DefaultListModel<>();
        ArrayList<Persona> lista = RegistrarUsuario.getPersona();
        for (Persona elemento : lista) {
            elementosModel.addElement(elemento);
        }
        list1.setModel(elementosModel);
    }

    private void setupPanelContainer() {

        panelImagen.setLayout(new BorderLayout());
        panelImagen.setPreferredSize(new Dimension(200, 200));
        panelImagen.add(panelCanvas, BorderLayout.CENTER);

        panelContainer.setLayout(new GridLayout(5, 0));
        panelContainer.add(panelImagen);
        panelContainer.add(panel1);

        add(panelContainer);
    }
    private void addActionListeners() {

        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new Index().setVisible(true);
        });
        SELECCIONARButton.addActionListener(e -> {
            usuarioSeleccionado = (Persona) list1.getSelectedValue();
            this.setVisible(false);
            ListaProductos listaProductosFrame = new ListaProductos(usuarioSeleccionado);
            listaProductosFrame.setupFrame();
            listaProductosFrame.setVisible(true);


        });
    }
}
