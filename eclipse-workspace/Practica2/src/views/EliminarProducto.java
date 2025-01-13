package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import mainApp.MainApp;
import models.Producto;

public class EliminarProducto extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField textNombreProducto; 
    private JPanel contentPanel; 

    public EliminarProducto(JLayeredPane layeredPane) {
        setBackground(new Color(0, 128, 192)); 
        contentPanel = new JPanel(); 
        contentPanel.setBackground(new Color(0, 128, 192));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(contentPanel);

        JLabel lblNombreProducto = new JLabel("Nombre del producto a eliminar:");

        textNombreProducto = new JTextField();
        textNombreProducto.setColumns(20); 

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textNombreProducto.setText(""); 
            }
        });

        JButton okButton = new JButton("Eliminar");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreProducto = textNombreProducto.getText().trim();

                // Verificar que se ha ingresado un nombre de producto
                if (nombreProducto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa el nombre del producto.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Buscar el producto en la lista
                Producto productoAEliminar = null;
                for (Producto producto : MainApp.productos) {
                    if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                        productoAEliminar = producto;
                        break;
                    }
                }

                // Verificar si se encontró el producto
                if (productoAEliminar == null) {
                    JOptionPane.showMessageDialog(null, "El producto no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Confirmar la eliminación del producto
                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar " + productoAEliminar.getNombre() + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Eliminar el producto de la lista
                    MainApp.productos.remove(productoAEliminar);

                    // Mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    textNombreProducto.setText(""); 
                }
            }
        });

        // Establecer el GroupLayout
        GroupLayout groupLayout = new GroupLayout(contentPanel);
        contentPanel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true); 
        groupLayout.setAutoCreateContainerGaps(true); 

        // Configurar el GroupLayout
        groupLayout.setHorizontalGroup(
            groupLayout.createSequentialGroup()
                .addGap(50) 
                .addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
                    .addComponent(lblNombreProducto)
                    .addComponent(textNombreProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(okButton)
                        .addGap(10) 
                        .addComponent(cancelButton)))
                .addGap(50) 
        );

        groupLayout.setVerticalGroup(
            groupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNombreProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}
