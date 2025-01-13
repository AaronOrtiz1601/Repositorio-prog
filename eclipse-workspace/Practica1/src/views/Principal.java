package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import mainApp.App; // Asegúrate de que puedes acceder a App.clientes
import models.Clientes;

public class Principal {

    private JFrame frame;
    private JTextArea textArea; // Mueve la declaración aquí para acceder en otros métodos

    /**
     * Create the application.
     */
    public Principal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JLabel lblNewLabel = new JLabel("Clientes Registrados");
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
          groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap(37, Short.MAX_VALUE)
              .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
              .addGap(32))
            .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
              .addGap(159)
              .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
              .addContainerGap(121, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
          groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap(27, Short.MAX_VALUE)
              .addComponent(lblNewLabel)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
              .addGap(26))
        );
        frame.getContentPane().setLayout(groupLayout);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnCliente = new JMenu("Cliente");
        menuBar.add(mnCliente);

        JMenuItem mntmAltaCliente = new JMenuItem("Alta cliente");
        mntmAltaCliente.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            AltaClientes ventana = new AltaClientes();
            ventana.setVisible(true);

            // Agregar un listener para actualizar el JTextArea cuando se cierre la ventana de AltaClientes
            ventana.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    // Actualizamos el JTextArea
                    actualizarTextArea();
                }
            });
          }
        });
        mnCliente.add(mntmAltaCliente);

        JMenuItem mntmBajaCliente = new JMenuItem("Baja cliente");
        mntmBajaCliente.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            BajaClientes ventana2 = new BajaClientes();
            ventana2.setVisible(true);
            ventana2.addWindowListener(new java.awt.event.WindowAdapter() {
              @Override
              public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                  // Actualizamos el JTextArea
                  actualizarTextArea();
              }
          });
          }
        });
        mnCliente.add(mntmBajaCliente);

        JMenu mnProductos = new JMenu("Productos");
        menuBar.add(mnProductos);

        JMenuItem mntmAltaProductos = new JMenuItem("Alta productos");
        mntmAltaProductos.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            AltaProducto ventana = new AltaProducto();
            ventana.setVisible(true);
          }
        });
        mnProductos.add(mntmAltaProductos);

        JMenuItem mntmListar = new JMenuItem("Listar Productos");
        mntmListar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            ListarProductos ventana = new ListarProductos();
            ventana.setVisible(true);
          }
        });
        mnProductos.add(mntmListar);

        // Hacer que la ventana sea visible
        frame.setVisible(true);
    }

    private void actualizarTextArea() {
        // Limpiar el JTextArea antes de agregar nuevos datos
        textArea.setText("");

        // Iterar sobre los clientes y concatenar los datos en el JTextArea
        for (Clientes cliente : App.clientes) {
            String textoCliente = "Nombre: " + cliente.getNombre()
                                + ", Apellidos: " + cliente.getApellido()
                                + ", Edad: " + cliente.getEdad()
                                + ", Provincia: " + cliente.getProvincia()
                                + "\n";

            // Agregamos el texto directamente al JTextArea
            textArea.append(textoCliente);
        }

        // Forzamos el repintado del JTextArea
        textArea.revalidate();
        textArea.repaint();
    }
    

    public void setVisible(boolean b) {
        frame.setVisible(b); 
    }
}
