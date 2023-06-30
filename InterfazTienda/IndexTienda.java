package InterfazTienda;

import InterfazIndex.Index;
import InterfazUsuario.MostrarUsuario;
import InterfazUsuario.RegistrarUsuario;

import javax.swing.*;
import java.awt.*;

public class IndexTienda extends JFrame{
    private JPanel panel1, panelCanvas, panelImagen, panelContainer;
    private JButton ADMINISTRADORButton;
    private JButton REPARTIDORButton;
    private JButton REGRESARButton;
    public IndexTienda(){
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
                ImageIcon imagen = new ImageIcon("C:\\Users\\Nayeli Velasco\\IdeaProjects\\Ordinario\\src\\Imagen\\tienda-online (2).png");
                Image img = imagen.getImage();
                g.drawImage(img, 35, 23, null);
            }
        };

        panelImagen = new JPanel();
        panelContainer = new JPanel();
        panelImagen = new JPanel();
    }

    private void setupFrame() {
        setTitle("INDEX DE TIENDA");
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
        ADMINISTRADORButton.addActionListener(e -> {
            this.setVisible(false);
            new LoginAdmin().setVisible(true);
        });
       REPARTIDORButton.addActionListener(e -> {
            this.setVisible(false);
            new LoginRepartidor().setVisible(true);
        });
        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new Index().setVisible(true);
        });

    }

}
