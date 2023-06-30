package InterfazUsuario;

import InterfazIndex.Index;

import javax.swing.*;
import java.awt.*;

public class IndexUsuario extends JFrame{
    private JPanel panel1, panelCanvas, panelImagen, panelContainer;
    private JButton REGISTRARButton;
    private JButton MOSTRARButton;
    private JButton REGRESARButton;
    public IndexUsuario(){
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
                ImageIcon imagen = new ImageIcon("C:\\Users\\Nayeli Velasco\\IdeaProjects\\Ordinario\\src\\Imagen\\usuario.png");
                Image img = imagen.getImage();
                g.drawImage(img, 35, 23, null);
            }
        };

        panelImagen = new JPanel();
        panelContainer = new JPanel();
        panelImagen = new JPanel();
    }

    private void setupFrame() {
        setTitle("INGRESO ADMINISTRADOR");
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
        MOSTRARButton.addActionListener(e -> {
            this.setVisible(false);
            new MostrarUsuario().setVisible(true);
        });
        REGISTRARButton.addActionListener(e -> {
            this.setVisible(false);
            new RegistrarUsuario().setVisible(true);
        });
        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new Index().setVisible(true);
        });

    }

}





