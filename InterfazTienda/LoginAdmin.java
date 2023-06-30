package InterfazTienda;

import InterfazIndex.Index;

import javax.swing.*;
import java.awt.*;

public class LoginAdmin extends JFrame{
    private JPanel panel1, panelCanvas, panelImagen, panelContainer;
    private JTextField textField1;
    private JTextField textField2;
    private JButton INGRESARButton;
    private JButton REGRESARButton;
    public LoginAdmin(){
        setupFrame();
        initializeComponents();
        setupPanelContainer();
        add(panelContainer);

        addActionListeners();
    }

    private void initializeComponents() {
        panelCanvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imagen = new ImageIcon("C:\\Users\\Nayeli Velasco\\IdeaProjects\\Ordinario\\src\\Imagen\\perfil-del-usuario.png");
                Image img = imagen.getImage();
                g.drawImage(img, 35, 23, null);
            }
        };

        panelImagen = new JPanel();
        panelContainer = new JPanel();
        panelImagen = new JPanel();
    }

    private void setupFrame() {
        setTitle("LOGIN ADMINISTRADOR");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 400);
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
        INGRESARButton.addActionListener(e -> {
            String usuario = textField1.getText();
            String contrasena = textField2.getText();

            if (usuario.equals("admin") && contrasena.equals("admin")) {

                this.setVisible(false);
                new IngresoProductos().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            }
        });

        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new IndexTienda().setVisible(true);
        });/*
        INGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            PanelAdmin panelAdmin= new PanelAdmin();
            panelAdmin.setVisible(true);
        });
*/

    }

}
