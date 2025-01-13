package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Productos extends JPanel {
    private JLayeredPane layeredPane; 

    public Productos(JLayeredPane layeredPane) { 
        this.layeredPane = layeredPane;

        setBackground(new Color(0, 128, 192));

        JLabel lblNewLabel = new JLabel("Bienvenido a la gestión de productos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblNewLabel_1 = new JLabel("¿Qué operación quieres realizar?");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JButton btnDarAlta = new JButton("Dar de alta un producto");
        JButton btnListarProducto = new JButton("Listar productos");
        JButton btnEliminarProducto = new JButton("Eliminar un producto");

        // Acción para el botón "Dar de alta a un cliente"
        btnDarAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPanel(new DarAltaProducto(layeredPane)); 
            }
        });

        // Acción para el botón "Listar clientes"
        btnListarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              // Cambiar al panel correspondiente
                cambiarPanel(new ListarProductos(layeredPane)); 
            }
        });

        // Acción para el botón "Eliminar un cliente"
        btnEliminarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPanel(new EliminarProducto(layeredPane)); 
            }
        });

        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
          groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
              .addGap(228))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(299)
              .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
              .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(328)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(btnListarProducto, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnDarAlta)
                .addComponent(btnEliminarProducto, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
              .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
          groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(lblNewLabel)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(lblNewLabel_1)
              .addGap(18)
              .addComponent(btnDarAlta)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(btnListarProducto)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(btnEliminarProducto)
              .addContainerGap(148, Short.MAX_VALUE))
        );
        setLayout(groupLayout);
    }

    private void cambiarPanel(JPanel newPanel) {
   // Limpiar contenido anterior
        layeredPane.removeAll(); 
        newPanel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight()); 
        layeredPane.add(newPanel);
        layeredPane.repaint(); 
        layeredPane.revalidate();
    }
}
