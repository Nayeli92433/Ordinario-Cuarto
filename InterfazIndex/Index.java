package InterfazIndex;

import InterfazPedido.ListaUsuarios;
import InterfazTienda.IndexTienda;
import InterfazUsuario.IndexUsuario;

import javax.swing.*;
import java.awt.*;

public class Index extends JFrame{
    private JPanel panel1, panelCanvas, panelImagen, panelContainer;
    private JButton USUARIOButton;
    private JButton TIENDAButton;
    private JButton PEDIDOButton;

    public Index(){
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
                ImageIcon imagen = new ImageIcon("C:\\Users\\Nayeli Velasco\\IdeaProjects\\Ordinario\\src\\Imagen\\tienda-online.png");
                Image img = imagen.getImage();
                g.drawImage(img, 35, 23, null);
            }
        };

        panelImagen = new JPanel();
        panelContainer = new JPanel();
        panelImagen = new JPanel();
    }

    private void setupFrame() {
        setTitle("INDEX");
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

        USUARIOButton.addActionListener(e -> {
            this.setVisible(false);
            new IndexUsuario().setVisible(true);
        });
        TIENDAButton.addActionListener(e -> {
          this.setVisible(false);
          new IndexTienda().setVisible(true);
        });
        PEDIDOButton.addActionListener(e -> {
           this.setVisible(false);
           new ListaUsuarios().setVisible(true);
        });

        }




}
